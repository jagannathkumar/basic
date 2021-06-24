/**
 * 
 */
package com.myproject.college;

import java.util.HashMap;

/**
 * @author JK
 *
 */
public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		
		//1st approach
		String s="dcouytggghcuyto";
    	String st="";
    	//First non repeating characters
    	char ch = 	'\u0000';
    	for(int i=0;i<s.length();i++){
    		st=(i==0?"":s.substring(0,i))+s.substring(i+1,s.length());
    		if(!st.contains(String.valueOf(s.charAt(i)))){
    		//System.out.println("First non repeating characters in \""+s+"\": "+s.charAt(i));
    		//break;
    			ch = s.charAt(i);
    		}
    	}
    	System.out.println("Last non repeating character: "+ch);
    	
    	//2nd approach
    	int arr[] = new int[256];
    	for(int i=0;i<256;i++)
    		arr[i] = -1;
    	
    	for(int i=0;i<s.length();i++) {
    		if(arr[s.charAt(i)] == -1) {
    			arr[s.charAt(i)] = i;
    		}
    		else {
    			arr[s.charAt(i)] = -2;
    		}
    	}
    	
    	int res = Integer.MAX_VALUE;
    	for(int i=0;i<256;i++) {
    		if(arr[i]!=-2 && arr[i]!=-1 && res>i) {
    			res = i;
    		}
    	}
    	if(res!= Integer.MAX_VALUE) {
    		System.out.println("first non repeating character: "+(char)res);
    	}
    	else {
    		System.out.println("no repeating character");
    	}
    	
    	//3rd approach
    	HashMap<Character,Character> hm = new HashMap<>();
	}

}
