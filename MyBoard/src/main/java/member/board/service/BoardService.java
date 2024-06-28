package member.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.board.dao.BoardDao;
import member.board.dto.BoardDto;

@Service
public class BoardService {
	
	@Autowired
	BoardDao dao;
	
	public int write(BoardDto dto) {
		return dao.write(dto); // 글번호
	}

}
