package member.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import member.board.dto.MemDto;

@Controller
@SessionAttributes("user")
public class myboardController {

	// 게시판 리스트
	@GetMapping("/myboard/list")
	public String myboardList(@RequestParam(name="p",defaultValue = "1" ) int page) {
		
		return "myboard/list";
	}
	
	@GetMapping("/myboard/write")
	public String writeForm() {
		return "myboard/writeform";
	}
	// 게시글 작성
	// 게시글 수정
	// 게시글 삭제 - 글 내용만 안 보여주고, 좋아요 , 신고 버튼 사라짐
	// 댓글 / 대댓글
	// 좋아요 기능 (좋아요/좋아요취소)
	// 핫게시판
	// 공지사항
	// 신고
	

}
