package kr.or.ddit.vo.test;

import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class DDITBoardVO {
	private int boNo;
	private String boTitle;
	private String boContent;
	private String boWriter;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String boDate;
	private int boHit;
	private List<DDITTagVO> tagList;
}
 