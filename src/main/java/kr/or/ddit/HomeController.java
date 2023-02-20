package kr.or.ddit;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// http 메서드 매핑을 요청할 formHome 페이지
	@RequestMapping(value = "/formHome",method = RequestMethod.GET)
	public String formHome() {
		logger.info("formHome()");
		return "formHome";
	}
	
	// headers 매핑을 요청할 ajaxHome 페이지
	@RequestMapping(value = "/ajaxHome", method = RequestMethod.GET)
	public String ajaxHome() {
		logger.info("ajaxHome()");
		return "ajaxHome";
		
	}
}
