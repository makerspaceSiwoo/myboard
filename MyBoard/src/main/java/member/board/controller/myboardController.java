package member.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import member.board.dto.BoardDto;
import member.board.dto.MemDto;
import member.board.service.BoardService;

@Controller
@SessionAttributes("user")
public class myboardController {
	@Autowired
	BoardService service;
	
	// 게시판 리스트
	@GetMapping("/myboard/list")
	public String myboardList(@RequestParam(name="p",defaultValue = "1" ) int page) {
		
		return "myboard/list";
	}
	
	// 게시글 작성
	@GetMapping("/myboard/write")
	public String writeForm() {
		return "myboard/writeform";
	}
	@PostMapping("/myboard/write")
	public String write(@ModelAttribute("board") BoardDto dto) {
		int no = service.write(dto);
		return "myboard/content/"+no;
	}
	
	// 게시글 수정
	// 게시글 삭제 - 글 내용만 안 보여주고, 좋아요 , 신고 버튼 사라짐
	// 댓글 / 대댓글
	// 좋아요 기능 (좋아요/좋아요취소)
	// 핫게시판
	// 공지사항
	// 신고
	

}
