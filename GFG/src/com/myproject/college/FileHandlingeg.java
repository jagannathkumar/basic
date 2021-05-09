/**
 * 
 */
package com.myproject.college;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author JK
 *
 */
public class FileHandlingeg {

	public static void main(String[] args) throws IOException {
		String str = "File Handling in Java using Java Java";
		FileWriter fw = new FileWriter("C:\\Users\\JK\\Desktop\\output.txt");
		String[] str1 = str.split("\\s");
		for (String st : str1) {
			fw.write(st + "\n");
		}
		fw.close();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("C:\\Users\\JK\\Desktop\\output.txt");
			br = new BufferedReader(new FileReader("C:\\Users\\JK\\Desktop\\output.txt"));
			String str2 = null;
			int count=0;
			while ((str2 = br.readLine()) != null) {
				System.out.println(str2);
				if(str2.equalsIgnoreCase("Java"))
					count++;
			}
			fr.close();
			br.close();
			System.out.println("Count of Java in file "+count);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found "+e);
		}

	}

}
