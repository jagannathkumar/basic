/**
 * 
 */
package com.myproject.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author JK
 *
 */
public class TreemapExample {

	public static void main(String[] args) {
		Map<Integer,String> mp = new TreeMap<Integer,String>();
		mp.put(20, "test");
		mp.put(10, "zzz");
		mp.put(30, "aaa");
		
		Iterator<Map.Entry<Integer, String>> it= mp.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, String> entry=it.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
			if(entry.getKey()==10) {
				//it.remove();
				mp.put(10, "lklkl");
			}
		}
		for(Map.Entry<Integer, String> mp1:mp.entrySet()) {
			System.out.println(mp1.getKey()+" "+mp1.getValue());
		}
		
		List<String> list= new ArrayList<>();
		list.add("a");
		list.add("b");
		List<String> list1= new ArrayList<>();
		list1.add("c");
		list1.add("d");
		System.out.println(list+" "+list1);
		List<List<String>> list3 = new ArrayList<List<String>>();
		list3.add(list);
		list3.add(list1);
		System.out.println(list3);
		List<String> list4 = new ArrayList<>();
		for(List<String> li:list3) {
			for(String str: li) {
				list4.add(str);
			}
		}
		System.out.println(list4);
		
	}

}
