package kr.or.ddit.vo;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Member {
	@NotBlank
	private String userId = "a001";
	@NotBlank
	@Size(max=3)
	private String userName = "hongkd";
	@NotBlank
	private String password = "1234";
	private int coin = 100;
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Past
	private Date dateOfBirth;
	@Email
	private String email;
	private String birthDay;
	@Valid
	private Address address;
	@Valid
	private List<Card> cardList;
	
	private String cars;
	private String[] carArray;
	private List<String> carList;
	
	private String gender;
	private String hobby;
	private String[] hobbyArray;
	private List<String> hobbyList;
	private String developer;
	private boolean foreigner;
	private String nationality;
	
	private String introduction;
}
