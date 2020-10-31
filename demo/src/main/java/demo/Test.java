package demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		/*
		 * try{ Class.forName("com.mysql.cj.jdbc.Driver"); Connection
		 * con=DriverManager.getConnection(
		 * "jdbc:mysql://localhost:3306/test","root","Welcome@123"); //here sonoo is
		 * database name, root is username and password Statement
		 * stmt=con.createStatement(); ResultSet
		 * rs=stmt.executeQuery("select * from emp"); while(rs.next())
		 * System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		 * con.close(); }catch(Exception e){ System.out.println(e);}
		 */
		Set<String> hset = new HashSet<String>();
		/*
		 * hset.add(9); hset.add(2); hset.add(10);
		 */
		// set.add(null);
		// hset.add(0);
		/*
		 * hset.add("geeks"); hset.add("for"); hset.add("practice");
		 * hset.add("contribute");
		 * 
		 * Iterator itr =hset.iterator(); while(itr.hasNext())
		 * System.out.println(itr.next());
		 */
/*
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		// Adding mappings to HashMap
		hm.put("GeeksforGeeks", 54);
		hm.put("A computer portal", 80);
		hm.put("For geeks", 82);

		// Printing the HashMap
		System.out.println("Created hashmap is" + hm);
		System.out.println("set "+hm.entrySet());
		// Getting an iterator
		Iterator hmIterator = hm.entrySet().iterator();

		// Iterate through the hashmap
		// and add some bonus marks for every student
		System.out.println("HashMap after adding bonus marks:");

		while (hmIterator.hasNext()) {
			Map.Entry mapElement = (Map.Entry) hmIterator.next();
			int marks = (Integer) (mapElement.getValue())+10;
			System.out.println(mapElement.getKey() + " : " + marks);

		}*/
		String str = new String("GeeksForGeeks"); 
        
        // making str eligible for gc 
        str = null;  
              
        // calling garbage collector 
        System.gc();  
              
        // waiting for gc to complete 
        Thread.sleep(1000);  
      
        System.out.println("end of main");
	}
}
