package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.vo.Item;


public interface IItemService {

	public void register(Item item) throws Exception;

	public List<Item> list() throws Exception;
	
	public Item read(int itemId) throws Exception;

	public void modify(Item item) throws Exception;

	public String getPicture(int itemId) throws Exception;

	public void remove(int itemId) throws Exception;

}
