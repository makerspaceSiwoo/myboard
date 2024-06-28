package member.board.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import member.board.dto.BoardDto;

@Mapper
public interface BoardDao {
	
	
	int write(BoardDto dto);
}
