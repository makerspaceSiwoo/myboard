package member.board.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardDto {

	private int no;
	private String id;
	private String title;
	private String content;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;
	private int readcount;
}
