package kr.or.ddit.controller.form.checkbox;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/formtag/checkbox")
public class JSPFormCheckboxTagController {

	/*
	 * 8. 체크박스 요소
	 * - HTML 체크박스를 출력하려면 <form:checkBox> 요소를 사용한다.
	 * 
	 */
	
	// 1) 모델에 기본 생성자로 생성한 폼 객체를 추가한 후 화면에 전달한다.
	@RequestMapping(value = "/registerForm01", method = RequestMethod.GET)
	public String registerForm01(Model model) {
		log.info("registerForm01");
		model.addAttribute("member",new Member());
		return "form/checkbox/registerForm01";
	}
	
	// 2) 객체를 생성하여 값을 설정한 후 화면에 전달한다.
	@RequestMapping(value = "/registerForm02", method = RequestMethod.GET)
	public String registerForm02(Model model) {
		log.info("registerForm02 : ");
		
		Member member= new Member();
		member.setDeveloper("Y"); 	// 개발자 여부
		member.setForeigner(true);	// 외국인 여부
		member.setHobby("Movie");	// 취미
		
		String[] hobbyArray = {"Music", "Movie"};
		member.setHobbyArray(hobbyArray);	// 취미(array)
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		
		member.setHobbyList(hobbyList);		//  취미(list)
		model.addAttribute("member",member);
		return "form/checkbox/registerForm01";
	}
	
	// 3) 결과
	@RequestMapping(value ="/result", method = RequestMethod.POST)
	public String registerResult(Member member, Model model) {
		log.info("registerResult : ");
		log.info("member.isForeigner() : " + member.isForeigner());
		log.info("member.getDeveloper()" + member.getDeveloper());
		log.info("member.getHobby()" + member.getHobby());
		
		String[] hobbyArray = member.getHobbyArray();
		
		if(hobbyArray != null) {
			log.info("hobbyArray != null : " + hobbyArray.length);
			for(int i = 0; i < hobbyArray.length; i++) {
				log.info("hobbyArray [" + i + "]" + hobbyArray[i]);
			}
		} else {
		log.info("hobbyArray == null");
		}
		
		List<String> hobbyList = member.getHobbyList();
		
		if(hobbyList != null) {
			log.info("hobbyList != null : " + hobbyList.size());
			for(int i = 0; i < hobbyList.size(); i++) {
				log.info("hobbyList [" + i + "]" + hobbyList.get(i));
			}
		} else {
			log.info("hobbyList == null");
		}
		model.addAttribute("member",member);
		return "form/checkbox/result";
	}
}