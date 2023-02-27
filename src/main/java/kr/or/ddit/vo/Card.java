package kr.or.ddit.vo;

import java.util.Date;

import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Card {
	@NotBlank
	private String no;
	@DateTimeFormat(pattern="yyyyMMdd")
	@Future
	private Date validMonth;
}
