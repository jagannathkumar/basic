package com.myproject.java1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors; 
/**
 * @author JK
 *
 */
public class Testjvm {

	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		System.out.println(s1.equals(s2) + " " + (s1 == s2));

		Class c1 = s1.getClass();
		Class c2 = s2.getClass();
		System.out.println((c1 == c2) + " "+c1.equals(c2)+" "+c1.getName());
		
		Field f[] = c1.getDeclaredFields(); 
        for (Field field : f) 
            System.out.println(field.getName());
        
        
        String s="ananya";
    	String st="";
    	//First non repeating characters
    	for(int i=0;i<s.length();i++){
    		st=(i==0?"":s.substring(0,i))+s.substring(i+1,s.length());
    		//System.out.println(i+" "+st);
    		if(!st.contains(String.valueOf(s.charAt(i)))){
    		System.out.println("First non repeating characters in \""+s+"\": "+s.charAt(i));
    		break;
    		}
    	}
    	List<String> l1 = new ArrayList<>();
    	List<String> l2 = new ArrayList<>();
    	l1.add("a");
    	l1.add("b");
    	l2.add("c");
    	l2.add("d");
    	
    	List<List<String>> list = new ArrayList<>();
    	list.add(l1);
    	list.add(l2);
    	System.out.println(list);
    	List<String> l3 = new ArrayList<>();
		/*
		 * for(List<String> li:list) { for(String str: li) { l3.add(str); } }
		 */
    	//Instead of above for loop and iteration we can use below flatmap from stream
    	l3 = list.stream().flatMap(list1->list1.stream()).collect(Collectors.toList());
    	System.out.println(l3);
	}

}