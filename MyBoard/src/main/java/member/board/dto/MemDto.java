package member.board.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemDto {

	@NotNull(message="id가 없습니다.")
	@NotEmpty(message="id가 비었습니다.")
	private String id;
	@NotNull(message="pw가 없습니다.")
	@NotEmpty(message="pw가 비었습니다.")
	private String password;
	private String name;
	private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
}
