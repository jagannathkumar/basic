/**
 * 
 */
package com.myproject.singletonbreakexample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author JK
 *
 */
public class MainApp {

	public static void main(String[] args) throws CloneNotSupportedException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			FileNotFoundException, IOException, ClassNotFoundException {
		// breaking using clone
		Singleton s = Singleton.getInstance();
		Singleton s1 = (Singleton) s.clone();
		System.out.println(s.hashCode() + " " + s1.hashCode());

		// breaking using relection
		Singleton instance2 = null;
		Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		instance2 = (Singleton) constructor.newInstance();

		System.out.println(s.hashCode() + " " + instance2.hashCode());

		// Breaking using serialization
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.txt"));
		out.writeObject(s);
		out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
		Singleton ins = (Singleton) in.readObject();
		in.close();
		System.out.println(s.hashCode() + " " + ins.hashCode());
		
	}

}
