package com.designpatterns.singleton.usingreflectiontodestroy;

import java.lang.reflect.Constructor;

import com.designpatterns.singleton.billpugh.JDBCSingleton;

public class JDBCSingletonDemo {

	public static void main(String[] args) {
		JDBCSingleton jdbcSingleton = JDBCSingleton.getInstance();
		JDBCSingleton jdbcSingleton2 = null;
		
		try {
			Constructor[] constructors = JDBCSingleton.class.getDeclaredConstructors();
			for(Constructor<?> constructor : constructors){
				//Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				jdbcSingleton2 = (JDBCSingleton) constructor.newInstance();
				break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(jdbcSingleton.hashCode());
		System.out.println(jdbcSingleton2.hashCode());
	}
}
