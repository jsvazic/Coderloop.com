/**
 *  Copyright 2010 Coderloop.com.
 *  Author: Diego, the architect
 **/
package com.coderloop.puzzles;

public class Singleton {

	private static Singleton _instance;
	
	//! This is private, so no one can instantiate this from outside the class
	private Singleton() {
		HarryPotter hp = new HarryPotter();
		hp.doSomeMagic();	//it should defeat Lord Voldemort
	}

	//! Implement a singleton (design pattern)
	public static synchronized Singleton getInstance() {
		if (null == _instance){
			_instance = new Singleton();
		}
		return _instance;
	}
	
}