package kr.or.ddit.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.Card;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ModelMemberController {

	/*
	 * 6장 : 데이터 전달자 모델
	 * 1. 모델 객체
	 * - Model 객체는 뷰(view)에 컨트롤러에서 생성된 데이터를 담아서 전달하는 역할을 한다.	
	 */
	
	
	// 매개변수에 선언된 Model 객체의 addAttribute() 메서드를  호출하여 데이터를 뷰(view)에 전달한다.
	@RequestMapping(value = "/read01",method = RequestMethod.GET)
	public String read01(Model model) {
		log.info("read01()");
		
		model.addAttribute("userId","a001");
		model.addAttribute("password","1234");
		model.addAttribute("email","aaa@ccc.com");
		model.addAttribute("userName","gildong");
		model.addAttribute("birthDay","1111-08-21");
		return "member/read01";
	}
	// Model 객체에 자바빈즈 클래스 객체를 값으로만 전달할 때는 뷰에서 참조할 이름을 클래스 명의 앞글자를 소문자로 변환해서 처리해야한다.
	@RequestMapping(value = "/read02",method = RequestMethod.GET)
	public String read02(Model model) {
		log.info("read02()");
		
		Member member = new Member();
		member.setUserId("a001");
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("js");
		member.setBirthDay("11230202");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1322);
		cal.set(Calendar.MONTH, 8);
		cal.set(Calendar.DAY_OF_MONTH, 8);
	
		member.setDateOfBirth(cal.getTime());
		
		model.addAttribute(member);
		return "member/read02";
	}
	
	// Model 객체에 자바빈즈 클래스 객체를 특정한 이름을 지정하여 전달할 수 있다.
	@RequestMapping(value ="read03",method =RequestMethod.GET)
	public String read03(Model model) {
		log.info("read03()");
		
		Member member = new Member();
		member.setUserId("a001");
		member.setPassword("1234");
		member.setEmail("aaa@ccc.com");
		member.setUserName("js");
		member.setBirthDay("11230202");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1322);
		cal.set(Calendar.MONTH, 8);
		cal.set(Calendar.DAY_OF_MONTH, 8);
	
		member.setDateOfBirth(cal.getTime());
		
		model.addAttribute("user", member);
		return "member/read03";
	}
	
	// Model 객체를 통해 배열과 컬렉션 객체를 전달할 수 있다.
	@RequestMapping(value = "/read04",method= RequestMethod.GET)
	public String read04(Model model) {
		log.info("read04");
		
		String[] carArray = {"bmw","jeep"};
		
		List<String> carList = new ArrayList<String>();
		carList.add("bmw");
		carList.add("jeep");
	
		String[] hobbyArray = {"music","movie"};
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("music");
		hobbyList.add("movie");

		model.addAttribute("carArray",carArray);
		model.addAttribute("carList",carList);
		model.addAttribute("hobbyArray",hobbyArray);
		model.addAttribute("hobbyList",hobbyList);
		return "member/read04";
	}
	
	// Model 객체를 통해 중첩된 자바빈즈 클래스 객체를 전달할 수 있다.
	@RequestMapping(value="/read05",method = RequestMethod.GET)
	public String read05(Model model) {
		log.info("read05");
		
		Member member = new Member();
		
		Address address = new Address();
		address.setPostCode("090988");
		address.setLocation("Seoul");
		
		member.setAddress(address);
		
		List<Card> cardList = new ArrayList<Card>();
		
		Card card1 = new Card();
		card1.setNo("123456");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1994);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DAY_OF_MONTH, 2);
		card1.setValidMonth(cal.getTime());
		cardList.add(card1);
		
		Card card2 = new Card();
		card2.setNo("123456");
		cal.set(Calendar.YEAR, 2023);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DAY_OF_MONTH, 22);
		card1.setValidMonth(cal.getTime());
		cardList.add(card2);
		
		member.setCardList(cardList);
		model.addAttribute("user",member);
		return "member/read05";
	}
	
	@RequestMapping(value="/read06", method = RequestMethod.GET)
	public String read06(Model model) {
		log.info("read06() : ");
		
		Member member = new Member();
		member.setUserId("a001");
		member.setPassword("1234");
		member.setEmail("aaa@aaa.com");
		member.setUserName("hongkd");
		member.setBirthDay("2023-02-22");
		member.setGender("male");
		member.setDeveloper("Y");
		member.setForeigner(false);
		member.setNationality("korea");
		member.setCars("jeep");
	
		String[] carArray = {"jeep","bmw"};
		member.setCarArray(carArray);

		List<String> carList = new ArrayList<String>();
		carList.add("jeep");
		carList.add("bmw");
		member.setCarList(carList);
		
		member.setHobby("music");
		
		String[] hobbyArray = {"music","movie"};
		member.setHobbyArray(hobbyArray);
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("music");
		hobbyList.add("movie");
		member.setHobbyList(hobbyList);
		
		Address address = new Address();
		address.setPostCode("090909");
		address.setLocation("DAEJEON");
		member.setAddress(address);
		
		List<Card> cardList = new ArrayList<Card>();
		Card card1 = new Card();
		card1.setNo("1234");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 1322);
		cal.set(Calendar.MONTH, 8);
		cal.set(Calendar.DAY_OF_MONTH, 8);
		card1.setValidMonth(cal.getTime());
		cardList.add(card1);
		
		Card card2 = new Card();
		card1.setNo("2344");
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 2);
		cal.set(Calendar.DAY_OF_MONTH, 8);
		card2.setValidMonth(cal.getTime());
		cardList.add(card2);
		
		member.setCardList(cardList);
		
		cal.set(Calendar.YEAR, 1999);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DAY_OF_MONTH, 11);
		
		member.setDateOfBirth(cal.getTime());
		String introduction = "하이루";
		member.setIntroduction(introduction);
		model.addAttribute("user",member);
		return "member/read06";
	}
}
