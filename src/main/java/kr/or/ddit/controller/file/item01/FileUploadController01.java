package kr.or.ddit.controller.file.item01;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.service.IItemService;
import kr.or.ddit.vo.Item;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/item")
public class FileUploadController01 {

	/*
	 * 13장 파일 업로드
	 * 
	 * 1. 파일업로드 설명
	 * - 서블릿 3.0 에서 지원하는 파일 업로드 기능과 스프링 웹엥서 제공하는 컴포넌트를 사용하여 파일을 업로드한다.
	 * 
	 * 	파일 업로드 설정
	 * 	1) 서블릿 3.0 이상 지원
	 * 	2) 서블릿 표준 파일 업로드 기능을 활성화
	 * 	3) 스프링 MVC와 연계
	 * 	4) 업로드 된 파일 저장 위치 설정
	 * 
	 * (Servers 프로젝트 안에 context.xml 안에 <Context allowCasualMultipartParsing="true" path="/"> 맞는지 확인하기)
	 * 
	 * 	환경 설정
	 * 	1) 의존 관계 정의
	 * 	- 파일을 처리하기 위해서 의존 라이브러리를 추가한다.
	 * 		> pom.xml commons-io  추가
	 *  2) 웹 컨테이너 설정
	 *  	> web.xml 서블릿 표준버전 3.1로 설정
	 *  	> multipart-config 활성화
	 *  3) 스프링 웹 설정
	 *  	> servlet-context.xml
	 *  	> multipartResolver Bean 등록
	 *  
	 *  	[ 파일 업로드 설정 ]
	 *  	1. StandardServletMultipartResolver 사용
	 *  		> servlet-context.xml 에 설정
	 *  			> StandardServletMultilpartResolver bean 등록
	 *  		> root-context.xml 설정		
	 *  			> uploadPath bean 등록 (서버 경로 설정)
	 *  		> web.xml에 설정
	 *  			> multipart-config 추가 (servlet 태그 안에 설정)
	 *  
	 *  	2. CommonsMultipartResolver 사용 시 설정,
	 *  		> pom.xml 설정
	 *  			> commons-io 추가
	 *  		> root-context.xml 설정
	 *  			> CommonsMultipartResolver bean 등록
	 *  	
	 *  
	 *  4) 필터 설정
	 *  	> web.xml 설정
	 *  		> multipartFilter 등록 
	 *  	
	 *  
	 *  
	 *  	데이터베이스 준비
	 *  	1) item 관련 테이블 설정
	 *  		> item, item2, item3, item3_attach
	 * 
	 * 2. 이미지 업로드
	 * 	- 한 개의 이미지를 업로드한느 기본 파일 업로드 기능을 구현합니다.
	 * 
	 * 		1. 파일 업로드 구현 설명
	 * 			- 파일 업로드 등록 화면 컨트롤러 만들기 (FileUploadController01)
	 * 			- 파일 업로드 등록 화면 컨트롤러 메서드 만들기(itemRegisterForm:get)\
	 * 			- 파일 업로드 등록 화면 만들기 (item/regisger.jsp)
	 * 			- 확인하기
	 * 
	 * 
	 * 			- 파일 업로드 등록 기능 컨트롤러 메소드 만들기(itemsRegister:post)
	 * 			- 파일 업로드 등록 기능 서비스 인터페이스 메소드 만들기
	 *          - 파일 업로드 등록 기능 서비스 클래스 메소드 만들기
	 *          - 파일 업로드 등록 기능 Mappper 인터페이스 메소드 만들기
	 *          - 파일 업로드 등록 기능 Mapper xml 쿼리 만들기
	 *          - 파일 업로드 등록 완료 페이지 만들기
	 *          	- 확인하기
	 *          
	 *           - 파일 업로드 목록 화면 컨터롤러 메소드 만들기(itemListt:get)
	 *           - 파일 업로드 목록 화면 서비스 인터페이스 메소드 만들기      
	 *           - 파일 업로드 목록 화면 서비스 클래스 메소드 만들기        
	 *           - 파일 업로드 목록 화면 Mappper 인터페이스 메소드 만들기  
	 *           - 파일 업로드 목록 화면 Mapper xml 쿼리 만들기      
	 *           - 파일 업로드 목록 화면 페이지 만들기  
	 *           	- 확인하기              
	 *           
	 *           - 파일 업로드 수정 화면 컨터롤러 메소드 만들기(itemModify:get)   
	 *           - 파일 업로드 수정 화면 서비스 인터페이스 메소드 만들기            
	 *           - 파일 업로드 수정 화면 서비스 클래스 메소드 만들기              
	 *           - 파일 업로드 수정 화면 Mappper 인터페이스 메소드 만들기        
	 *           - 파일 업로드 수정 화면 Mapper xml 쿼리 만들기            
	 *           - 파일 업로드 수정 기능 컨터롤러 메소드 만들기(itemModify:post)   
	 *           - 파일 업로드 수정 기능 서비스 인터페이스 메소드 만들기            
	 *           - 파일 업로드 수정 기능 서비스 클래스 메소드 만들기              
	 *           - 파일 업로드 수정 기능 Mappper 인터페이스 메소드 만들기        
	 *           - 파일 업로드 수정 기능 Mapper xml 쿼리 만들기           
	 *           	- 확인하기
	 *          
	 *           
	 *           - 파일 업로드 삭제 화면 컨트롤러 메소드 만들기(itemRemoveForm:get)
	 *           - 파일 업로드 삭제 화면 서비스 인터페이스 메소드 만들기
	 *           - 파일 업로드 삭제 화면 서비스 클래스 메소드 만들기
	 *           - 파일 업로드 삭제 화면 Mapper 인터페이스 메소드 만들기
	 *           - 파일 업로드 삭제 화면 Mapper xml 쿼리 만들기
	 *           - 파일 업로드 삭제 화면 만들기
	 *           - 파일 업로드 삭제 기능 컨트롤러 메소드 만들기(itemRemoveForm:post)  
	 *           - 파일 업로드 삭제 기능 서비스 인터페이스 메소드 만들기                 
	 *           - 파일 업로드 삭제 기능 서비스 클래스 메소드 만들기                   
	 *           - 파일 업로드 삭제 기능 Mapper 인터페이스 메소드 만들기              
	 *           - 파일 업로드 삭제 기능 Mapper xml 쿼리 만들기                 
	 *           - 파일 업로드 삭제 기능 만들기                               
	 *           
	 *           
	 */          
	

	// c 드라이브 안에 upload 폴더로 서버 경로를 설정 
	
	@Resource(name = "uploadPath")
	private String resourcePath;
	
	private String uploadPath = "C://upload";
	
	@Inject
	private IItemService itemService;
	
	@RequestMapping(value= "/register", method = RequestMethod.GET)
	public String itemRegisterForm(Model model) {
		model.addAttribute("item", new Item());
		return "item/register"; // tiles 설정 없이 뷰리졸버가 후순위로 해당 경로를 잡음
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String itemRegister(Item item, Model model) throws Exception {
		MultipartFile file = item.getPicture();
		
		log.info("originalName : " + file.getOriginalFilename());
		log.info("size : " + file.getSize());
		log.info("contentType : " + file.getContentType());
	
		// 넘겨 받은 파일을 이용하여 파일 업로드(복사) 진행
		String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
	
		item.setPictureUrl(createdFileName);
		itemService.register(item);
		model.addAttribute("msg","등록 완료");
		return "item/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String itemList(Model model) throws Exception {
		List<Item> itemList =  itemService.list();
		model.addAttribute("itemList",itemList);
		return "item/list";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String itemModifyForm(int itemId, Model model) throws Exception {
		Item item = itemService.read(itemId);
		model.addAttribute("item",item);
		return "item/modify";
	}
	
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String itemModify(Item item, Model model) throws Exception {
		
		MultipartFile file = item.getPicture();
		if(file != null && file.getSize() > 0 ) {
			
			log.info("originalName : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
			log.info("contentType : " + file.getContentType());
		 String createFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
		 item.setPictureUrl(createFileName);
		}
		
		itemService.modify(item);
		model.addAttribute("msg","수정 완료");
		return "item/success";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String itemRemoveForm(int itemId, Model model) throws Exception {
		
		Item item = itemService.read(itemId);
		model.addAttribute("item",item);
		return "item/remove";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String itemRemove(Item item, Model model) throws Exception {
		itemService.remove(item.getItemId());
		model.addAttribute("msg","삭제 완료");
		return "item/success";
	}
	
	@RequestMapping("/display")
	public ResponseEntity<byte[]> displayFile(int itemId) throws Exception{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		String fileName = itemService.getPicture(itemId);
		log.info("filemNem : " + fileName) ;
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".")+1);
			
			MediaType mType = getMediaType(formatName);
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(resourcePath + File.separator + fileName);
			if(mType != null) {
				headers.setContentType(mType);
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
	
	private String uploadFile(String originalName,byte[] fileData) throws Exception {
		
		File uploadLocate = new File(resourcePath);
		if(!uploadLocate.exists()) {
			uploadLocate.mkdirs();
		}
		
		
		String uuid = UUID.randomUUID().toString(); // 유효아이디 UUID
		String createFileName = uuid + "_" + originalName;
		File target = new File(resourcePath, createFileName);
		FileCopyUtils.copy(fileData, target);
		return createFileName;
	}
	
	public MediaType getMediaType(String formatName) {
		if(formatName != null) {
			if(formatName.toUpperCase().equals("JPG")) {
				return MediaType.IMAGE_JPEG;
			}
				
			if(formatName.toUpperCase().equals("GIF")) {
				return MediaType.IMAGE_GIF;
			}
			
			if(formatName.toUpperCase().equals("PNG")) {
				return MediaType.IMAGE_PNG;
			}
			
		}
		return null;
	}
}
