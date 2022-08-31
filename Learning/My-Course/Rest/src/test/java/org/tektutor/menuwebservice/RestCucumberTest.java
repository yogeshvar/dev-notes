package org.tektutor.menuwebservice;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class RestCucumberTest {
	@Test
	public void checkItemsList() {
		MenuController menu = new MenuController();
		Map<Integer,String> items = menu.getMenus();
		for(Entry<Integer, String> item : items.entrySet()) {
			System.out.println(item.getKey() + " : " + item.getValue());
		}
	}
	
}
