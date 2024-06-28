package member.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import member.board.dao.MemDao;
import member.board.dto.MemDto;

@Service
public class MemService {

	@Autowired
	MemDao dao;
	
	public int insertMember(MemDto dto) {
		return dao.insertMember(dto);
	}
	
	public int idChk(String id) {
		return dao.idChk(id);
	}
	
	public MemDto login(MemDto dto) {
		return dao.login(dto);
	}
}
