package member.board.controller;

import javax.naming.Binding;

import org.jsoup.helper.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import member.board.dto.MemDto;
import member.board.service.MemService;

@Controller
@SessionAttributes("user")
public class MemberController {

	@Autowired
	MemService service;
	
	@ModelAttribute("user")
	public MemDto getMem() {
		return new MemDto();
	}
	// 로그인
	@GetMapping("")
	public String main() {
		return "mem/login";
	}
	@GetMapping("/mem/login")
	public String loginForm() {
		return "mem/login";
	}
	@PostMapping("/mem/login")
	public String login(@ModelAttribute("member") @Validated MemDto dto, BindingResult error,
			Model m) {
		if(error.hasErrors()) {
			error.reject("nocode","모든 항목을 채워주세요");
			m.addAttribute("bef",dto);
			return "mem/login";
		}
		
		MemDto db = service.login(dto);
		if(db == null) {
			error.reject("nocode","아이디나 비번이 틀렸습니다.");
			return "/mem/login";
		}else {
			m.addAttribute("user",db);
		}
		return "myboard/list";
	}

	// 회원 가입
	@GetMapping("/mem/join")
	public String joinForm() {
		return "mem/joinform";
	}
	
	@GetMapping("/mem/id_chk/{id}")
	@ResponseBody
	public String idChk(@PathVariable("id") String id) {
		int i = service.idChk(id);
		if(i != 0) {
			return "false";
		}
		return "true";
	}
	
	@PostMapping("/mem/join")
	public String join(@ModelAttribute @Validated MemDto dto, BindingResult error
			, Model m) {
		System.out.println(dto);
		if(error.hasErrors()) {
			error.reject("nocode","모든 항목을 채워주세요");
			m.addAttribute("bef",dto);
			return "mem/joinform";
		}
		int i = service.insertMember(dto);
		System.out.println(i);

		return "redirect:/mem/login";
	}
	
	//회원 정보 수정
}
