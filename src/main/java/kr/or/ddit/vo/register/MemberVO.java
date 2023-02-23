package kr.or.ddit.vo.register;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import kr.or.ddit.vo.Address;
import lombok.Data;
@Data
public class MemberVO {
	private String userId;
	private String password;
	private String userName;
	private String email;
	@DateTimeFormat(pattern ="yyyyMMdd")
	private Date dateOfBirth;
	private String gender;
	private String developer;
	private String foreigner;
	private String nationality;
	private String[] cars;
	private String[] hobby;
	private String postCode;
	private Address address;
	private String introduction;
}
