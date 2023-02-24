package kr.or.ddit.controller.form.radio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.CodeLabelValue;
import kr.or.ddit.vo.Member;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/formtag/radio")
public class JSPFormRadioTagController {
	
	/*
	 *  9.여러개의 라디오 버튼 요소
	 *  
	 *  -HTML 라디오 버튼을 출력하려면 <form:radiobutton>요소를 사용한다
	 *  
	 *  
	 */
	//1)모델 MAP타입의 데이터를 생성하여 추가한 후에 화면에 전달
	@GetMapping("/registerFormRadis01")
	public String registerFormRadios01(Model model) {
		log.info("registerFormRadios01");
		
		
		Map<String, String> genderCodeMap = new HashMap<String, String>();
		genderCodeMap.put("01", "Male");
		genderCodeMap.put("02", "Female");
		genderCodeMap.put("03", "Other");
		
		model.addAttribute("genderCodeMap", genderCodeMap);
		model.addAttribute("member", new Member());
		return "form/radio/registerFormRadios01";
				
	}
	
	// 2) 모델에 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormRadios02", method = RequestMethod.GET)
	public String registerFormRadios02(Model model) {
		log.info("registerFormRadios02");
		
		List<CodeLabelValue> genderCodeList = new ArrayList<CodeLabelValue>();
		
		genderCodeList.add(new CodeLabelValue("Male","01"));
		genderCodeList.add(new CodeLabelValue("Female","02"));
		genderCodeList.add(new CodeLabelValue("Other","03"));
		
		model.addAttribute("genderCodeList",genderCodeList);
		model.addAttribute("member",new Member());
		return "form/radio/registerFormRadios02";
				
	}
	
	// Result
	@RequestMapping(value ="/result", method = RequestMethod.POST)
	public String registerFormRadioResult(Member member, Model model) {
		log.info("registerFormRadioResult : ");
		log.info("member.getGender():" + member.getGender());
		model.addAttribute("gender",member.getGender());
		return "form/radio/result";
	}
	
	/*
	 * 10. 라디오 버튼 요소
	 * - HTML 라디오 버튼을 출력하려면 <form:radiobutton> 요소를 사용한다.
	 */
	
	// 1) 모델에 기본 생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@RequestMapping(value = "/registerFormRadio01", method = RequestMethod.GET)
	public String registerFormRadio01(Model model) {
		log.info("registerFormRadio01 : ");
		model.addAttribute("member", new Member());
		return "form/radio/registerFormRadio01";
	}
	
	// 2) 객체를 생성하여 값을 설정한 후 화면에 전달한다.
	@RequestMapping(value = "/registerFormRadio02", method = RequestMethod.GET)
	public String registerFormRadio02(Model model) {
		log.info("registerFormRadio02 : ");
		Member member = new Member();
		model.addAttribute("member", member);
		return "form/radio/registerFormRadio02";
	}
	
	@RequestMapping(value = "/result2", method = RequestMethod.POST)
	public String registerFormRadiosResult2(Member member, Model model) {
		log.info("registerFormRadiosResult2() : ");
		log.info("member.getGender()"+member.getGender());
		model.addAttribute("member", member);
		return "form/radio/result2";
	}
}
 