/**
 * 
 */
package com.myproject.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JK
 *
 */
public class Generic<S> {

	S obj;
	public Generic(S obj) {
		this.obj=obj;
	}
	
	public S getObj() {
		return this.obj;
	}
	public static void main(String[] args) {
		Generic<Integer> g = new Generic<>(3);
		Generic<String> str = new Generic<>("Test");
		System.out.println(g.getObj()+" "+str.getObj());
		List<String> li = new ArrayList<>();
		li.add("abc");
		li.add("bcd");
		Generic<List<String>> list = new Generic<>(li);
		System.out.println(list.getObj());
	}

}
