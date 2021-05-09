/**
 * 
 */
package com.myproject.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author JK
 *
 */
public class ListRemovingIteration {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		list.add(4);
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer i = it.next();
			System.out.println(i);
			if (i == 1) {
				it.remove();// this will work and remove entry from list
				// list.add(5); //this will cause ConcurrentModification
			}
		}

		ListIterator itr = list.listIterator();
		while (itr.hasNext()) {
			Integer i = (Integer) itr.next();
			System.out.println(i);
			if (i == 3)
				itr.add(6);//we can use listiterator to add elements in list while iterating

		}

		Iterator<Integer> it1 = list.iterator();
		System.out.println("after adding elements");

		while (it1.hasNext()) {
			System.out.println((Integer) it1.next());
		}

	}

}
