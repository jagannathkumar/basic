/**
 * 
 */
package com.myproject.singletonbreakexample;

import java.io.Serializable;

/**
 * @author JK
 *
 */
public class Singleton extends MyClone implements Serializable {
	private static final long serialVersionUID = -8470990457707050086L;
	public static Singleton instance = null;

	private Singleton() {
		// to prevent new singleton instance from reflection api, uncomment below line
		// throw new IllegalStateException("Preventing new instance from reflection");
	}

	public static Singleton getInstance() {
		if (instance == null)
			instance = new Singleton();
		return instance;
	}

	// to prevent breaking of singleton from cloning
	// we can either throw some exception or return same instance
	protected Object clone() throws CloneNotSupportedException {
		// throw new CloneNotSupportedException();
		return instance;
	}
	// to prevent to break from serialization and deserialization

	protected Object readResolve() {
		return instance;
	}

}
