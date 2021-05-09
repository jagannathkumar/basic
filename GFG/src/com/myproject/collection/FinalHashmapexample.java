/**
 * 
 */
package com.myproject.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author JK
 *
 */
public class FinalHashmapexample {
	private final Map<Integer,String> mp = new HashMap<Integer,String>();
	public static void main(String[] args) {
		FinalHashmapexample fm = new FinalHashmapexample();
		fm.mp.put(1,"abc");
		fm.mp.put(2, "bcd");
		for(Map.Entry<Integer, String> mp1:fm.mp.entrySet()) {
			System.out.println(mp1.getValue());
		}
		
		Map<String,Integer> map = new HashMap<>();
		map.put("ab", 1);
		map.put("bc", 1);
		//map.put(null, 34);
		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
		while(it.hasNext())
		{
			String s= it.next().getKey();
			System.out.println(s);
			//if(s.equals("ab"))
				//map.put("as", 2);
		}
		
		
		System.out.println(map.size()+" "+map);
		
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(100);
		list.remove((Integer)100);
		System.out.println(list);
		
	}

}
