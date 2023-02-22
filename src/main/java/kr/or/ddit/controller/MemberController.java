package kr.or.ddit.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.vo.Address;
import kr.or.ddit.vo.Member;
import kr.or.ddit.vo.register.MemberVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {

	/*
	 * 5장 : 컨트롤러 요청 처리
	 * 
	 * 1. 컨트롤러 메서드 매개변수
	 * 
	 * 	Model
	 * 	- 이동 대상에 전달할 데이터를 가지고 있는 인터페이스
	 * 	RedirectAttributes
	 * 	- 리다이렉트 대상에 전달할 데이터를 가지고 있는 인터페이스
	 * 	java beans 클래스
	 * 	- 요청 파라미터를 가지고 있는 자바빈즈 클래스
	 * 	MultipartFile
	 * 	- 멀티파트 요청을 사용해 업로드된파일 정보를 가지고 있는 인터페이스
	 *  BindingResult 
	 *  - 도메인 클래스의 입력값 검증을 가지고 있는 인터페이스
	 *  java.security.Principal
	 *  - 클라이언트 인증을 위한 사용자 정보를 가지고 있는 인터페이스	
	 *
	 * 2. 요청 처리
	 * 
	 */
	
	// 컨트롤러 요청 처리를 위한 페이지(5장 시작점) 
	@RequestMapping(value = "/registerForm",method = RequestMethod.GET)
	public String registerForm() {
		log.info("요청처리");
		log.info("registerForm()");
		
		return "registerForm";
	}
	
	// 1) URL 경로 상의 쿼리 파라미터 정보로부터 요청 데이터를 취득할 수 있다.
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm(String userId, String password) {
		log.info("요청 처리");
		log.info("registerByParameter()");
		log.info("userId : " + userId);
		log.info("password : " + password);
		return "success";
	}
	
	@RequestMapping(value = "/register/{userId}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable String userId) {
		// userId가 null 로 표시된다
		// 넘겨 받은 id 를 @PathVariable 사용하지 않고 값을 받는 경우 null 이다
		// 값을 넘겨 받는 경우엔 @PathVariable을 사용한다.
		log.info("요청 처리");
		log.info("registerByPath()");
		log.info("userId : " + userId);
		return "success";
	}
	
	// 3) HTML 폼 필드명과 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.
	@RequestMapping(value="/register01", method = RequestMethod.POST)
	public String register01(String userId) {
		log.info("요청 처리");
		log.info("register01()");
		log.info("userId : " + userId);
		return "success";
	}
	
	// 4) HTML 폼 필드가 여러 개일 경우에도 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득 할 수 있다.
	@RequestMapping(value = "/register02", method = RequestMethod.POST )
	public String register02(String userId, String password) {
		log.info("요청처리");
		log.info("register02()");
		log.info("userId : " + userId);
		log.info("password : " + password);
		return "success";
	}
	
	// 5) HTML 폼 필드가 여러 개일 경우에 컨트롤러 매개변수의 위치는 상관없다.
	@RequestMapping(value = "/register03", method = RequestMethod.POST )
	public String register03(String password, String userId) {
		log.info("요청처리");
		log.info("register03()");
		log.info("password : " + password);
		log.info("userId : " + userId);
		return "success";
	}
	
	// 6) HTML 폼 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 문자열이면 그대로 문자열 형태로 요청 데이터를  취득한다.
	@RequestMapping(value = "/register04", method = RequestMethod.POST )
	public String register04(String password, String userId, String coin) {
		log.info("요청처리");
		log.info("register04()");
		log.info("password : " + password);
		log.info("userId : " + userId);
		log.info("coin : " + coin);
		return "success";
	}
	
	// 7) HTML 폼 필드 값이 숫자일 경우에는 컨트롤러 매개변수 타입이 숫자형이면 숫자로 타입 변환하여 요청 데이터를 취득한다.
	@RequestMapping(value = "/register05", method = RequestMethod.POST )
	public String register05(String password, String userId, int coin) {
		// coin에 문자값을 입력해서 전송하면 400(값이 누락되었을 때 뜨는 에러)발생
		log.info("요청처리");
		log.info("register05()");
		log.info("password : " + password);
		log.info("userId : " + userId);
		log.info("coin : " + coin);
		return "success";
	}
    
	/*
	 * 3. 요청 데이터 처리 어노테이션
	 *  @PathVariable
	 *  	- URL 경로에서 경로 변수 값을 가져오기 위한 어노테이션
	 *  @RequestParam
	 *  	- 요청 파라미터 값을 가져오기 위한 어노테이션
	 *  @RequestHeader
	 *  	- 요청 헤더 값을 가져오기 위한 어노테이션
	 *  @RequestBody
	 *  	- 요청 본문 내용을 가져오기 위한 어노테이션
	 *  @CookieValue
	 *  	- 쿠키 값을 가져오기 위한 어노테이션
	 */
	
	// 1) URL 경로 상의 경로 변수가 여러 개 일 때 @PathVariable 어노테이션을 사용하여 특정한 경로 변수명 지정
	@RequestMapping(value ="/register/{userId}/{coin}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable("userId") String userId, @PathVariable("coin") int coin) {
		log.info("요청 데이터 처리 어노테이션 ");
		log.info("register05()");
		log.info("userId : " + userId);
		log.info("coin : " + coin);
		return "success";
	}
	
	//// 1) URL 경로 상의 경로 변수가 여러 개 일 때 @PathVariable 어노테이션을 사용하여 특정한 경로 변수명 지정
	@RequestMapping(value ="/register0201", method = RequestMethod.POST)
	public String register0201(String username) {
		log.info("요청 데이터 처리 어노테이션 ");
		log.info("register0201()");
		log.info("username : " + username);
		return "success";
	}
	
	@RequestMapping(value ="/register0202", method = RequestMethod.POST)
	public String register0202(@RequestParam("userId") String username) {
		log.info("요청 데이터 처리 어노테이션 ");
		log.info("register0202()");
		log.info("username : " + username);
		return "success";
	}
	
	/*
	 * 4. 요청 처리 자바빈즈
	 */
	
	// 1) 폼 텍스트 필드 요소 값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value ="/beans/register01", method= RequestMethod.POST)
	public String registerJavaBeans01(Member member) {
		log.info("요청 처리 자바빈즈");
		log.info("registerJavaBeans01()");
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassword() : " + member.getPassword());
		log.info("member.getCoin() : " + member.getCoin());
	
		return "success";
	}
	
	// 2) 폼 텍스트 필드 요소 값을 자바빈즈 매개변수와 기본 덷이터 타입인 정수 타입 매개변수로 처리한다.
	@RequestMapping(value ="/beans/register02", method= RequestMethod.POST)
	public String registerJavaBeans02(Member member,int coin) {
		log.info("요청 처리 자바빈즈");
		log.info("registerJavaBeans02()");
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassword() : " + member.getPassword());
		log.info("member.getCoin() : " + member.getCoin());
		log.info("coin" + coin);
		
		return "success";
	}

	@RequestMapping(value = "/beans/register03", method = RequestMethod.POST)
	public String registerJavaBeans03(int uId, Member member) {
		log.info("요청 처리 자바빈즈");
		log.info("registerJavaBeans03()");
		log.info("uId : " + uId);
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassword() : " + member.getPassword());
		log.info("member.getCoin() : " + member.getCoin());
		
		return "success";
	}
	
	/*
	 * 5. Date 타입 처리
	 * - 스프링 MVC는 Date 타입의 테이터를 처리하는 여러 방법을 제공한다.
	 * 
	 */
	
	@RequestMapping(value = "/registerByGet01", method = RequestMethod.GET)
	public String registerByGet01(String userId, Date dateOfBirth) {
		log.info("DATE type");
		log.info("registerByGet01()");
		log.info("userId"+ userId);
		log.info("dateOfBirth" + dateOfBirth);
		return "success";
	}
	
	@RequestMapping(value = "/registerByGet02", method = RequestMethod.GET)
	public String registerByGet02(Member member) {
		log.info("DATE type");
		log.info("registerByGet01()");
		log.info("member.getUserId"+ member.getUserId());
		log.info("member.getDateOfBirth" + member.getDateOfBirth());
		return "success";
	}
	
	@RequestMapping(value ="/register", method = RequestMethod.POST)
	public String register(Member member) {
		log.info("DATE type");
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getPassword() : " + member.getPassword());
		log.info("member.getDateOfBirth() : " + member.getDateOfBirth());
		return "success";
	}
	
	/*
	 * 7. 폼 방식 요청 처리
	 */
	
	//1) 폼 텍스트 필드 요소 값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다
	@RequestMapping(value ="/registerUserId", method = RequestMethod.POST)
	public String registerUserId(String userId) {
		log.info("registerUserId()");
		log.info("userId : " + userId);
		return "success";
		
	}
	
	// 2) 폼 텍스트 필드 요소 값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value ="/registerMemberUserId", method = RequestMethod.POST)
	public String registerMemberUserId(Member member) {
		log.info("registerMemberUserId()");
		log.info("member.getUserId : " + member.getUserId());
		return "success";
		
	}
	
	// 3) 폼 비밀번호 필드 요소 값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/registerPassword",method = RequestMethod.POST)
	public String registerPassword(String password) {
		log.info("registerpassword");
		log.info("password : " + password);
		return "success";
	}
	
	// 4) 폼 라디오버튼 요소 값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerRadio", method = RequestMethod.POST)
	public String registerRadio(String gender) {
		log.info("registerRadio()");
		log.info("gender : " + gender);
		return "success";
	}
	//5) 폼 셀렉트 박스 요소 값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerSelect", method = RequestMethod.POST)
	public String registerSelect(String nationality) {
		log.info("registerSelect()");
		log.info("nationality : " + nationality);
		return "success";
	}
	
	//6) 복수 선택이 가능한 폼 셀렉트 박스 요소 값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerMultipleSelect01", method = RequestMethod.POST)
	public String registerMultipleSelect01(String cars) {
		log.info("registerMultipleSelect01()");
		log.info("cars : " + cars);
		return "success";
	}
	
	//7) 복수 선택이 가능한 폼 셀렉트 박스 요소값을 문자열 배열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerMultipleSelect02", method = RequestMethod.POST)
	public String registerMultipleSelect02(String[] carArray) {
		log.info("registerMultipleSelect02()");
		
		if(carArray != null) {
			log.info("carArray.length : " + carArray.length);
			for(int i = 0; i < carArray.length; i++) {
				log.info("carArray[" + i + "] : " + carArray[i]);
			} 
		}else {
				log.info("carArray : null");
		}
		return "success";
	}
	
	// 8) 복수 선택이 가능한 폼 셀렉트 박스 요소 값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerMultipleSelect03", method = RequestMethod.POST)
	public String registerMultipleSelect03(ArrayList<String> carList) {
		log.info("registerMultipleSelect03()");
		
		// 리스트로는 셀렉트 박스 값을 가져올 수 없다. 배열 형태를 이용하여 받아오거나 String type 으로 받아온다.
		if(carList != null && carList.size()>0) {
			log.info("carList.size : " + carList.size());
			for(int i = 0; i < carList.size(); i++) {
				log.info("carList[" + i + "] : " + carList.get(i));
			} 
		}else {
			log.info("carList : null");
		}
		return "success";
	}
	
	// 9) 폼 체크박스 요소 값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerCheckbox01", method = RequestMethod.POST) 
	public String registerCheckbox01(String hobby) {
		log.info("registerCheckbox01");
		log.info("hobby : " + hobby);
		return "success";
	}
	
	// 10) 폼 체크박스 요소 값을 문자열 배열 타입 매개변수로 처리한다.
	@RequestMapping(value="/registerCheckbox02", method = RequestMethod.POST) 
	public String registerCheckbox02(String[] hobbyArray) {
		log.info("registerCheckbox02");
		if(hobbyArray != null) {
			log.info("hobbyArray.length : " + hobbyArray.length);
			for(int i = 0; i < hobbyArray.length; i++) {
				log.info("hobbyArray[" + i + "] : " + hobbyArray[i]);
			} 
		}else {
				log.info("hobbyArray : null");
		}
		return "success";
	}
	// 11) 폼 체크박스 요소 값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerCheckbox03", method = RequestMethod.POST)
	public String registerCheckbox03(ArrayList<String> hobbyList) {
		
		// List로 가져오게 되면 이때 List는 인터페이스 List인 경우
		// No primary or default constructor found for interface java.util.List 에러가 발생한다.
		// Spring 에서는 List로는 데이터를 받는게 되지 않는다.
		// 리스트와 같은 형태의 값을 받으려면 String[]로 여러 데이터를 받아서  List에 담는 방법이 있다.
		log.info("registerCheckbox03()");
		
		// 리스트로는 셀렉트 박스 값을 가져올 수 없다. 배열 형태를 이용하여 받아오거나 String type 으로 받아온다.
		if(hobbyList != null && hobbyList.size()>0) {
			log.info("hobbyList.size : " + hobbyList.size());
			for(int i = 0; i < hobbyList.size(); i++) {
				log.info("hobbyList[" + i + "] : " + hobbyList.get(i));
			} 
		}else {
			log.info("hobbyList : null");
		}
		return "success";
	}
	
	// 12) 폼 체크 박스 요소 값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerCheckbox04", method=RequestMethod.POST)
	public String registerCheckbox04(String developer) {
		log.info("registerCheckbox04");
		log.info("developer : " + developer);
		return "success";
	}
	
	// 13) 폼 체크 박스 요소 값을 기본 데이터 타입인 불리언 타입 매개변수로 처리한다.
	@RequestMapping(value = "/registerCheckbox05", method=RequestMethod.POST)
	public String registerCheckbox05(boolean foreigner) {
		log.info("registerCheckbox05");
		log.info("foreigner : " + foreigner);
		return "success";
	}
	
	// 14) 폼 텍스트 필드 요소 값을 자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/registerAddress", method = RequestMethod.POST)
	public String registerAddress(Address address) {
		log.info("registerAddress");
		if(address != null) {
			
		log.info("address.getPostCode : " + address.getPostCode());
		log.info("address.getLocation : " + address.getLocation());
		} else {
			log.info("address : null");
		}
		return "success";
	}
	
	// 15) 폼 텍스트 필드 요소 값을 중첩된  자바빈즈 매개변수로 처리한다.
	@RequestMapping(value = "/registerUserAddress", method = RequestMethod.POST)
	public String registerUserAddress(Member member) {
		log.info("registerUserAddress");
		
		// 멤버 클래스에 address 클래스를 타고 감.
		Address address = member.getAddress();
		if(address != null) {
			
			log.info("address.getPostCode : " + address.getPostCode());
			log.info("address.getLocation : " + address.getLocation());
			} else {
				log.info("address : null");
			}
			return "success";
	}
	
	// 총 정리
	@RequestMapping(value ="/registerAllForm", method = RequestMethod.GET) 
	public String registerAllForm() {
		log.info("registerAllForm : ");
		return "registerAllForm";
	}
	@RequestMapping(value ="/registerUser", method = RequestMethod.POST) 
	public String registerUser(MemberVO memberVO) {
		
		// log.info() 를 이용해서 memberVO안의 모든 내용을 출력하시오.
		log.info("유저 ID : " + memberVO.getUserId());
		log.info("패스워드 : " + memberVO.getPassword());
		log.info("이름 : " + memberVO.getUserName());
		log.info("Email : " + memberVO.getEmail());
		SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
		String birth = dtFormat.format(memberVO.getDateOfBirth());
		log.info("생년월일 : " + birth);
		log.info("성별 : " + memberVO.getGender());
		
		if (memberVO.getDeveloper() == "Y") {
			
			log.info("개발자 여부 : 개발자");
		} else {
			log.info("개발자 여부 : 비개발자");
		}
		
		
		if (memberVO.getForeigner() == "여") {
			
			log.info("외국인 여부 : 외국인");
		} else {
			log.info("외국인 여부 : 내국인");
		}
		
		log.info("국적 : " + memberVO.getNationality());
		
		String[] carArray = memberVO.getCars();
		
		if(carArray != null) {
			log.info("carArray.length : " + carArray.length);
			for(int i = 0; i < carArray.length; i++) {
				log.info("carArray[" + i + "] : " + carArray[i]);
			} 
		}else {
				log.info("carArray : null");
		}
		
		String[] hobbyArray = memberVO.getHobby();
		
		if(hobbyArray != null) {
			log.info("hobbyArray.length : " + hobbyArray.length);
			for(int i = 0; i < hobbyArray.length; i++) {
				log.info("취미 [" + i + "] : " + hobbyArray[i]);
			} 
		}else {
				log.info("취미  : null");
		}
		
		
		// 멤버 클래스에 address 클래스를 타고 감.
		Address address = memberVO.getAddress();
			if(address != null) {
					
			log.info("address.postcode: " + address.getPostCode());
			log.info("address.location : " + address.getLocation());
			} else {
				log.info("address : null");
			}
			log.info("memberVO.getIntroduce() : " + memberVO.getIntroduction());
		return "success";
	}
}	