package member.board.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import member.board.dto.MemDto;

@Mapper
public interface MemDao {
	
	@Insert("insert into member (id, password,name,email,birth) values(#{id},#{password},#{name},#{email},#{birth})")
	int insertMember(MemDto dto);
	
	@Select("select count(*) from member where id=#{id}")
	int idChk(String id);
	
	@Select("select * from member where id=#{id} and password=#{password}")
	MemDto login(MemDto dto);
}
