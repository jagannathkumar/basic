/**
 * 
 */
package com.myproject.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author JK
 *
 */
public class StreamExample {

	public static void main(String[] args) {
		Predicate<Integer> morethan = i -> (i > 1);
		Predicate<Integer> lessthan = i -> (i < 10);
		List<Integer> list = Arrays.asList(2, 3, 1, 12, 12, 42, 223, 32, 23, 53);

		Integer max = list.stream().max(Integer::compare).get();
		System.out.println("Max: "+max);

		list.stream().forEach(System.out::println);
		list.stream().forEach(x -> {
			System.out.println(x);
		});

		System.out.println("Square using map and getting max value from that");
		System.out.println(list.stream().map(x -> x * x)
				.collect(Collectors.toList())
				.stream().max(Integer::compare).get());
		
		List<String> str = Arrays.asList("A","abc","xyz","lbj","zzz");
		System.out.println(str.stream().max(Comparator.comparing(String::valueOf)).get());
		
		System.out.println("Less than 10 and more than 1 using stream and predicate chaining");
		List<Integer> li = list.stream()
				.filter(lessthan.and(morethan))
				.collect(Collectors.toList());
		
		li.stream().forEach(System.out::println);

		List<Student> st = new ArrayList<Student>();
		for (int i = 0; i < 5; i++) {
			Student std = new Student(i + 1, "St" + i);
			st.add(std);
		}
		System.out.println("All student list:");
		st.stream().forEach(x -> {
			System.out.println(x.getName() + " " + x.getRollNo());
		});

		System.out.println("Student above roll no 2");
		List<Student> lis = process(st, (x) -> (x.getRollNo() > 2));
		lis.stream().forEach(x -> {
			System.out.println(x.getName() + " " + x.getRollNo());
		});
	}

	public static List<Student> process(List<Student> li, Predicate<Student> pred) {
		// return li.stream().filter(pred).collect(Collectors.toList());
		// Instead of above commented line we can write below one
		List<Student> result = new ArrayList<Student>();
		for (Student st : li) {
			if (pred.test(st))
				result.add(st);
		}
		return result;
	}
}

class Student {
	private int rollNo;
	private String name;

	Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
