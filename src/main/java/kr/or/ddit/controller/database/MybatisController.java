package kr.or.ddit.controller.database;

import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MybatisController {

	/*
	 * 12. 마이바티스
	 * 
	 * 	1. 마이바티스란?
	 * 		
	 *	- 마이바티스는 자바 퍼시스턴스 프레임워크의 하나로 xml 서술자나 어노테이션을 사용하여 저장 프로시저난 SQL문으로 객체들을 연결시킨다.
	 *	  마이바티스는 Apache 라이선스 2.0으로 배포되는 자유 소프트웨어입니다.
	 *
	 *	- 마이바티스를 사용함으로 얻을 수 있는 이점.
	 *	1) SQL의 체계적 관리	
	 * 	2) 자바 객체와 SQL 입출력 값의 투명한 바인딩
	 *  3) 동적 SQL 조합
	 *  
	 *  - 마이바티스 설정
	 *  	1) 의존관계 정의
	 *  	- mybatis
	 *  	- mybatis-spring
	 *  	- spring-jdbc
	 *  	- commons-dbcp2
	 *  	- log4jdbc-log4j2-jdbc4
	 *  	- ojdbc6 or 8
	 *  
	 *  	2) 스프링과 마이바티스 연결 설정
	 *  	- root-context.xml 설정
	 *  	> dataSource
	 *  	> sqlSessionFactory
	 *  	> sqlSessionTemplate
	 *  	> basePackage
	 *  
	 *  	3) 마이바티스 설정ㄹ
	 *  	- WEB-INF/mybatisAlias/mybatisAlias.xml 설정
	 *  	- 마이바티스의 위치 설정은 root-context의 'sqlSessionFatory' 설정할 때 property 요소로 적용한다.
	 *  	
	 *  	4) 테이블 설정
	 *  		- board, member, member_auth 설정
	 *  	
	 *  2. Mapper 인터페이스
	 *  - 인터페이스의 구현을  mybatis-spring에서 자동으로 생성할 수 있다.
	 *  
	 *  	1) 마이바티스 구현
	 *  	
	 *  		1-1) Mapper 인터페이스
	 *  		- BoardMapper.java 생성	 
	 * 			
	 * 			1-2) Mapper 인터페이스와 매핑할 Mapper
	 * 			- sqlmap/boardMapper_SQL.xml 생성
	 * 
	 * 			1-3) 게시판 구현 설명
	 * 			- 게시판 컨트롤러 만들기(board/CrudBoardController)
	 * 			- 게시판 등록화면 컨트롤러 메소드 만들기(crudRegister:get)
	 * 			- 게시판 등록화면 만들기(crud/register.jsp)
	 * 			- 확인하기
	 * 
	 * 			- 게시판 등록 기능 컨트롤러 메서드 만들기	
	 * 			- 게시판 등록 기능 서비스 인터페이스 메소드 만들기	
	 * 			- 게시판 등록 기능 서비스 클래스 메소드 만들기	 
	 * 			- 게시판 등록 기능 Mapper 인터페이스 메소드 만들기		
	 * 			- 게시판 등록 기능 Mapper xml 쿼리 만들기	 
	 * 			- 게시판 등록 완료 페이지 만들기
	 * 				확인하기	
	 * 			
	 * 			- 게시판 목록 화면 컨트롤러 메소드 만들기
	 * 			- 게시판 목록 화면 서비스 인터페이스 메소드 만들기
	 * 			- 게시판 목록 화면 서비스 클래스 메소드 만들기
	 * 			- 게시판 목록 화면 Mapper 인터페이스 메소드 만들기
	 * 			- 게시판 목록 화면 Mapper xml 쿼리 만들기 
	 * 			- 게시판 목록 화면 만들기(crud/list.jsp)
	 * 				확인하기
	 * 
	 * 			- 게시판 수정 화면 컨트롤러 메소드 만들기(crudRead:get)
	 * 			- 게시판 수정 화면 서비스 인터페이스 메소드 만들기
	 * 			- 게시판 수정 화면 서비스 클래스 메소드 만들기
	 * 			- 게시판 수정 화면 Mapper 인터페이스 메소드 만들기
	 * 			- 게시판 수정 화면 Mapper xml 쿼리 만들기 
	 * 			- 게시판 수정 화면 만들기(crud/register.jsp)
	 * 			- 게시판 수정 기능 컨트롤러 메소드 만들기(crudModify:post)
	 * 			- 게시판 수정 기능 서비스 인터페이스 메소드 만들기(crudModify:post)
	 * 			- 게시판 수정 기능 서비스 클래스 메소드 만들기(crudModify:post)
	 * 			- 게시판 수정 기능 Mapper 인터페이스 메소드 만들기
	 * 			- 게시판 수정 기능 Mapper xml 쿼리 만들기 
	 * 				확인하기
	 * 		
	 */	
}
