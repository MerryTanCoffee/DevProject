package kr.or.ddit.controller.file.item03;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/item3")
public class FileUploadController03 {

	
	/*
	 * 13장 파일 업로드
	 * 	
	 * 4. 비동기 방식 업로드
	 * - 비동기 방식으로 여러 개의 이미지를 업로드 하는 파일 업로드 기능을 구현한다.
	 * 
	 * 	
	 * 		1. 환경설정
	 * 
	 * 			1-1) 의존관계 정의
	 * 				- commons-io 		: 파일을 처리하기 위한 의존 라이브러리 
	 * 				- imgscalr-lib		: 이미지 변환을 처리하기 위한 의존 라이브러리
	 * 				- jackson-databind  : json 데이터 바인딩 위한 의존 라이브러리
	 * 			***** MAVEN > update projects 진행하여 의존 등록 완료	
	 * 				
	 * 		2. 파일 업로드 구현 설명
	 * 
	 * 			- 파일 업로드 등록 화면 컨트롤러 만들기(FileUploadController03)
	 * 			- 파일 업로드 등록 화면 컨트롤러 메소드 만들기(item3RegisterForm:get)
	 * 			- 파일 업로드 등록 화면 (item3/register.jsp)
	 * 				- 확인하기
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String item3RegisterForm() {
		return "item3/register";
	}
	
	@ResponseBody
	@RequestMapping(value="/uploadAjax",method=RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {

		String savedName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(),file.getBytes());
		return new ResponseEntity<String>(savedName, HttpStatus.CREATED);
	}
}
