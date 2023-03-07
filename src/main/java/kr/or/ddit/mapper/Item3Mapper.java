package kr.or.ddit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.vo.Item3;

public interface Item3Mapper {

	public void register(Item3 item) throws Exception;

	public void addAttach(String fileName) throws Exception;

	public List<Item3> list() throws Exception;

	public Item3 read(int itemId) throws Exception;

	public List<String> getAttach(int itemId) throws Exception;

	public void modify(Item3 item) throws Exception;

	public void deleteAttach(int itemId) throws Exception;

	// mapper랑 sql의 변수가 달ㄹ라서 이름을 설정해주기 위해 param을 쓴다.
	public void replaceAttach(@Param("fullName") String fileName, @Param("itemId") int itemId) throws Exception;

	public void delete(int itemId) throws Exception;


}
