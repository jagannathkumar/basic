/**
 * 
 */
package com.myproject.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author JK
 *
 */
public class SumofList {

	public static void main(String[] args) {
		List<Integer> list1= new ArrayList<>();
		List<Integer> list2= new ArrayList<>();
		List<Integer> list3= new ArrayList<>();
		int a[]= {3,4,2};
		int b[]= {4,4,6,5};
		list1=Arrays.stream(a).boxed().collect(Collectors.toList());
		list2=Arrays.stream(b).boxed().collect(Collectors.toList());
		int carry=0;
        for(int i=(list1.size()-1),j=list2.size()-1;i>=0 || j>=0;i--,j--){
            int result=0;
            if(i>=0 && j>=0){
            	result = list1.get(i)+list2.get(j)+carry;
                if((carry = result/10)!=0) {
                	result=result%10;
                }
            }
            else if(i>=0 && j<0){
                result=list1.get(i)+carry;
                if((carry = result/10)!=0) {
                	result=result%10;
                }
            }
            else if(i<0 && j>=0){
                result=list2.get(j)+carry;
                if((carry = result/10)!=0) {
                	result=result%10;
                }
            }
            list3.add(result);
        }
        if(carry!=0)
        	list3.add(carry);
        Collections.reverse(list3);
        System.out.println(list3);
	}

}
