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
	 * 			- 게시판 삭제 기능 컨트롤러 메소드 만들기(crudRemove:post)
	 * 			- 게시판 삭제 기능 서비스 인터페이스 메소드 만들기 
	 * 			- 게시판 삭제 기능 서비스 클래스 메소드 만들기
	 * 			- 게시판 삭제 기능 Mapper 인터페이스 메소드 만들기 
	 * 			- 게시판 삭제 기능 Mapper xml 쿼리 만들기 
	 * 				확인하기
	 * 
	 * 3. 별칭 적용
	 * 	- TypeAlias로 맵핑 파일에서 반복적으로 사용될 패키지의 이름을 적용한다.
	 * 	
	 * 	1) 마이바티스 설정
	 * 
	 * 		1-1) mybatisAlias.xml 설정
	 * 		- typeAlias 설정을 한다.
	 * 
	 * 		1-2) boardMapper_SQL.xml 수정
	 * 		- 기존에 설정해놓은 패키지 명을 포함한 클래스 위치였다면 쿼리 태그에 각각 세팅한 패키지 명 대신  alias로 설정한 별칭으로 대체한다.
	 * 
	 * 4. _로 구분된 컬럼명 자동 매핑
	 * 	- 마이바티스 설정의 mapUnderscoreToCamelCase 프로퍼티값을 true로 지정하면 _로 구분된 컬럼명을 
	 * 	소문자 낙타표기법의 프로퍼티명으로 자동 매핑할 수 있다.
	 * 
	 * 	'_' 가 포함되어 있는 데이터베이스 컬럼명 카멜 기법 세팅으로 인해서 bo_no이  boNo으로 처리된다.
	 * 
	 * 		1) 마이바티스 설정
	 * 		
	 * 			1-1) mybatisAlias.xml 설정
	 * 			- <settings>
	 * 				<settiong name = "mapUnderscoreToCamelCase" value = "true"/> 설정 추가  
	 * 			  </settings>
	 * 			
	 * 			1-2) 매핑 파일 수정(boardMapper_SQL.xml)
	 * 			-_가 붙어 있는 컬럼명을 as로 설정한 컬럼 속성 부분을 삭제한다(as boardNo or as regDate로 설정해둔 부분이 있다면)	
	 * 					
	 * 5. 기본키 취득
	 * 	- 마이바티스는 useGeneratedKeys 속성을 이용하여 insert할 떄 데이터베이스 측에서 채번된 기본 키를 취득할 수 있다.
	 * 		
	 * 		1) 데이터베이스 테스트 준비
	 * 			
	 * 			1-1) 회원 테이블 사용
	 * 		
	 * 		2) 마이바티스 설정
	 * 			
	 * 			2-1) 매핑 파일 수정(boardMapper_SQL.xml)
	 * 			-create 부분에서 속성을 추가합니다.
	 * 			useGeneratedKeys = "true" keyProperty = "boardNo"
	 * 			[사용 예]
	 * 			<selectKey order = "BEFORE" resultType="int" keyProperty="boardNo">
	 * 				select seq_board.nextval from dual
	 * 			</selectKey>
	 * 
	 * 			insert into board(
	 * 				board_no, title, content, writer, reg_date
	 * 			) values (
	 * 				#{boardNo}, #{title}, #{content}, #{wirter}, sysdate
	 * 			)
	 * 
	 * 			selectKey에서 order 속성의 순서에 따라 설정된 쿼리 결과를 keyProperty에 설정된 필드 부분으로 값이 매핑된다.
	 * 			매핑된 값(boardNo)는 아래 insert 쿼리 문에서 사용할 수 있는 변수로 취득된 것으로 아래 insert를 진행할 때
	 * 			번호값으로 사용할 수 있게 된다.
	 * 
	 * 			*** curval 사용시 주의사항
	 * 			-select seq_board.curval from dual
	 * 			위 select 쿼리를 사용 시, curval를 사용하는데 있어서 사용 불가에 대한 에러가 발생할 수  있다.
	 * 			curval을 사용할 때는 select seq_board.xml from dual 로 먼저 최초 한번 실행 후
	 * 			select seq_board.curval from dual 를 사용하면 에러가 없다.
	 * 
	 *		    select last_number from user_sequences where sequence_name = 'seq_board';		
	 * 			select last_number from user_sequences where sequence_name = '시퀀스 명';		
	 * 		
	 * 6. 일대다 관계 테이블 매핑
	 * 	- 마이바티스 기능을 활용하여 매핑 파일을 적절하게 정의하면 일대다 관계 테이블 매핑을 쉽게 처리할 수 있다.
	 * 
	 * 		1) 게시판 구현 설명
	 * 		
	 * 		- 회원 등록 화면 컨트롤러 만들기(member/CrudMemberController)
	 * 		- 회원 등록 화면 컨트롤러 메소드 만들기(crudMemberRegisterForm:get)
	 * 		- 회원 등록 화면 만들기(crud/member/register.jsp)
	 * 			확인하기
	 * 
	 *  	- 회원 등록 기능 컨트롤러 메소드 만들기(crudMemberRegister:post)
	 *  	- 회원 등록 기능 인터페이스 메소드 만들기
	 *  	- 회원 등록 기능 클래스 메소드 만들기
	 *  	- 회원 등록 기능 Mapeer 인터페이스 메소드 만들기
	 *  	- 회원 등록 기능 Mapper xml 쿼리 만들기
	 *  	- 회원 등록 완료 페이지 만들기(crud/member/success.jsp)
	 *  		확인하기	
	 *  	
	 *  	- 회원 목록 화면  컨트롤러 메소드 만들기(crudMemberList:get)
	 *  	- 회원 목록 화면  인터페이스 메소드 만들기
	 *  	- 회원 목록 화면  클래스 메소드 만들기
	 *  	- 회원 목록 화면  Mapeer 인터페이스 메소드 만들기
	 *  	- 회원 목록 화면  Mapper xml 쿼리 만들기
	 *  	- 회원 목록 화면  페이지 만들기(crud/member/list.jsp)
	 *  		확인하기	
	 *  
	 *  	- 회원 상세 화면 컨트롤러 메소드 만들기(crudMemberRead:get)
	 *  	- 회원 상세 화면 서비스 인터페이스 만들기
	 *  	- 회원 상세 화면 서비스 클래스 메소드 만들기
	 *  	- 회원 상세 화면 Mapper 인터페이스 메소드 만들기
	 *  	- 회원 상세 화면 Mapper xml 쿼리 만들기
	 *  	- 회원 상세 화면 (crud/member/read)
	 *  		확인하기
	 *  
	 *  	- 회원 수정 화면 컨트롤러 메소드 만들기(crudMemberModifyForm:get)
	 *  	- 회원 수정 화면 서비스 인터페이스 만들기
	 *  	- 회원 수정 화면 서비스 클래스 메소드 만들기
	 *  	- 회원 수정 화면 Mapper 인터페이스 메소드 만들기
	 *  	- 회원 수정 화면 Mapper xml 쿼리 만들기
	 *  	- 회원 수정 화면 (crud/member/modify)
	 *  		확인하기
	 *  
	 *  	- 회원 수정 기능 컨트롤러 메소드 만들기(crudMemberModify:post)
	 *  	- 회원 수정 기능 서비스 인터페이스 메소드 만들기
	 *  	- 회원 수정 기능 서비스 클래스 메소드 만들기
	 *  	- 회원 수정 기능 Mapper 인터페이스 메소드 만들기
	 *  	- 회원 수정 기능 Mapper xml 쿼리 만들기
	 *  	- 회원 수정 완료 페이지 만들기(완성됨)
	 *  		확인하기
	 *  
	 *  	- 회원 삭제 기능 컨트롤러 메소드 만들기(crudMemberDelete:post)
	 *  	- 회원 삭제 기능 서비스 인터페이스 메소드 만들기
	 *  	- 회원 삭제 기능 서비스 클래스 메소드 만들기
	 *  	- 회원 삭제 기능 Mapper 인터페이스 메소드 만들기
	 *  	- 회원 삭제 기능 Mapper xml 쿼리 만들기
	 *  		확인하기
	 * 
	 * 7. 동적 SQL  
	 * - 마이바티스는 동적 SQL을 조립하는 구조를 지원하고 있으며, SQL 조립 규칙을 매핑 파일에 정의할 수 있다.
	 * 	
	 * 	1) 동적으로 SQL을 조립하기 위한 SQL 요소
	 * 	- <where>
	 * 		> where 절 앞 뒤에 내용을 더 추가하거나 삭제할 때 사용하는 요소
	 * 	- <if>
	 * 		> 조건을 만족할 때만 SQL을 조립할 수 있게 만드는 요소
	 * 	- <choose>
	 *  	> 여러 선택 항목에서 조건에 만족할 때만 SQL을 조립하게 만드는 요소
	 * 	- <foreach> 
	 *  	> 컬렉션이나 배열에 대해 반복 처리를 하기 위한 요소
	 * 	- <set>
	 *  	> set 절 앞 뒤에 내용을 더 추가하거나 삭제할 때 사용하는 요소
	 *  
	 *  2) 게시판 구현
	 *  	- 게시판 목록 화면 검색 페이지 추가(crud/board/list.jsp)
	 *  	- 게시판 검색 기능 컨트롤러 메소드 추가(crudSearch:post)
	 *  	- 게시판 검색 기능 서비스 인터페이스 메소드 추가
	 *  	- 게시판 검색 기능 서비스 클래스 메소드 추가
	 *  	- 게시판 검색 기능 Mapper 메소드 추가
	 *  	- 게시판 검색 기능 Mapper xml 추가
	 *  		확인하기
	 *  
	 *  
	 */			
}
