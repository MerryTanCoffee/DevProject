package kr.or.ddit.controller.file.item02;

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

import kr.or.ddit.service.IItem2Service;
import kr.or.ddit.vo.Item;
import kr.or.ddit.vo.Item2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/item2")
public class FileUploadController02 {

	
	/*
	 * 13장 파일 업로드
	 * 
	 * 3. 여러 개의 이미지 업로드
	 * - 한 번에 여러 개의 이미지를 업로드하는 파일 업로드 기능을 구현한다.
	 * 
	 * 		1. 파일 업로드 구현 설명
	 * 			- 파일 업로드 등록 화면 컨트롤러 만들기(FileUploadController02)
	 * 			- 파일 업로드 등록 화면 컨트롤러 메소드 만들기(Item2RegisterForm:get)
	 * 			- 파일 업로드 등록 화면 만들기(item2/register.jsp)
	 * 			- 확인하기
	 * 
	 * 
	 *  		- 파일 업로드 등록 기능 컨트롤러 메소드 만들기(itemRegister:post)
	 *  		- 파일 업보드 등록 기능 서비스 인터페이스 메소드 만들기 
	 *  		- 파일 업로드 등록 기능 서비스 클래스 메소드 만들기
	 *  		- 파일 업로드 등록 Mapper 인터페이스 메소드 만들기
	 *  		- 파일 업로드 등록 Mapper xml 쿼리 만들기
	 *  		- 파일 업로드 등록 완료 페이지 만들기
	 *  		- 확인하기
	 *  
	 *  		- 파일 업로드 목록 화면 컨트롤러 메소드 만들기(item2List:get)
	 *  		- 파일 업로드 목록 화면 서비스 인터페이스 메소드 만들기
	 *  		- 파일 업로드 목록 화면 서비스 클래스 메소드 만들기
	 *  		- 파일 업로드 목록 Mapper 인터페이스 메소드 만들기
	 *  		- 파일 업로드 목록 Mapper xml 쿼리 만들기
	 *  		- 파일 업로드 목록 화면 만들기(item2/list.jsp)
	 *  		- 확인하기
	 *  
	 *  		- 파일 업로드 수정 화면 컨트롤러 메소드 만들기(item2ModifyForm:get)
	 *  		- 파일 업로드 수정 화면 서비스 인터페이스 메소드 만들기
	 *  		- 파일 업로드 수정 화면 서비스 클래스 메소드 만들기
	 *  		- 파일 업로드 수정 화면 Mapper 인터페이스 메소드 만들기
	 *  		- 파일 업로드 수정 화면 Mapper xml 쿼리 만들기
	 *  		- 파일 업로드 수정 화면 만들기(item2/modify.jsp)
	 *  		- 파일 업로드 수정 기능 컨트롤러 메서드 만들기(item2Modify:post)
	 *  		- 파일 업로드 수정 기능 서비스 클래스 만들기
	 *  		- 파일 업로드 수정 Mapper 인터페이스 메소드 만들기
	 *  		- 파일 업로드 수정 Mppaer xml 쿼리 만들기
	 *  		- 확인하기
	 *  
	 *  		
	 *  		- 파일 업로드 삭제 화면 컨트롤러 메소드 만들기(item2RemoverForm:get)
	 *  		- 파일 업로드 삭제 화면 서비스 인터페이스 메소드 만들기
	 *  		- 파일 업로드 삭제 화면 서비스 클래스 메소드 만들기
	 *  		- 파일 업로드 삭제 화면 Mapper 인터페이스 메소드 만들기
	 *  		- 파일 업로드 삭제 화면 Mapper xml 쿼리 만들기
	 *  		- 파일 업로드 삭제 화면 만들기(item2/remove.jsp)
	 *  		- 파일 업로드 삭제 기능 컨트롤러 메소드 만들기(item2RemoveForm:POST) 
	 *  		- 파일 업로드 삭제 기능 서비스 인터페이스 메소드 만들기      
	 *  		- 파일 업로드 삭제 기능 서비스 클래스 메소드 만들기        
	 *  		- 파일 업로드 삭제 기능 Mapper 인터페이스 메소드 만들기   
	 *          - 파일 업로드 삭제 기능 Mapper xml 쿼리 만들기      
	 *          - 파일 업로드 삭제 기능 만들기(item2/remove.jsp)  
	 *  
	 *  
	 *  
	 *  
	 *  
	 *  
	 */
	
	@Resource(name = "uploadPath")
	private String resourcePath;
	
	
	@Inject
	private IItem2Service itemService;
	
	@RequestMapping(value ="/register")
	public String item2RegisterForm() {
		return "item2/register";
	}
	
	@RequestMapping(value ="/register",method = RequestMethod.POST)
	public String item2Register(Item2 item, Model model) throws Exception {
		List<MultipartFile> pictures = item.getPictures();
		
		
		for(int i = 0; i < pictures.size(); i++) {
			MultipartFile file = pictures.get(i);
			
			log.info("originalName : " + file.getOriginalFilename());
			log.info("size : " + file.getSize());
			log.info("contentType : " + file.getContentType());
			
			
			String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
			
			if(i == 0 ) {
				item.setPictureUrl(savedName);
			} else if(i==1) {
				item.setPictureUrl2(savedName);
			}
		}
		
		
		itemService.register(item);
		model.addAttribute("msg","등록 완료");
		return "item2/success";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		List<Item2> itemList = itemService.list();
		model.addAttribute("itemList",itemList);
		return "item2/list";
	
	}
	
	
	@RequestMapping("/display2")
	public ResponseEntity<byte[]> displayFile2(int itemId) throws Exception{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		String fileName = itemService.getPicture2(itemId);
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
	
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	public String item2RemoveForm(int itemId, Model model) throws Exception {
		
		Item2 item = itemService.read(itemId);
		model.addAttribute("item",item);
		return "item2/remove";
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String item2Remove(Item2 item, Model model) throws Exception {
		itemService.remove(item.getItemId());
		model.addAttribute("msg","삭제 완료");
		return "item2/success";
	}
	
	
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String item2ModifyForm(int itemId, Model model) throws Exception {
		Item2 item = itemService.read(itemId);
		model.addAttribute("item",item);
		return "item2/modify";
		
	}
	
	
	@RequestMapping(value= "/modify", method = RequestMethod.POST)
	public String item2Modify(Item2 item, Model model) throws Exception {
		List<MultipartFile> pictures = item.getPictures();
		
		for(int i = 0; i < pictures.size(); i++) {
			MultipartFile file = pictures.get(i);
			
			if(file != null && file.getSize()>0) {
				log.info("originalName : " + file.getOriginalFilename());
				log.info("size  : " + file.getSize());
				log.info("contentType : "  +file.getContentType());
				
				String savedName = uploadFile(file.getOriginalFilename(), file.getBytes());
			
				if(i==0) {
					item.setPictureUrl(savedName);
				} else if(i==1) {
					item.setPictureUrl2(savedName);
				}
			}
		}
		
		itemService.modify(item);
		model.addAttribute("msg","수정 완료");
		return "item2/success";
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
