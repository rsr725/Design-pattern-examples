/**
 * 
 */
package com.designpatterns.prototype;

import java.util.List;

/**
 * @author rajs1
 *
 */
public class TestPrototypePattern {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		Employees employees = new Employees();
		employees.loadData();
		
		Employees employees2 = (Employees) employees.clone();
		Employees employees3 = (Employees) employees.clone();
		
		List<String> list = employees2.getList();
		list.add("Sukh");
		
		List<String> list2 = employees3.getList();
		list2.remove("Rajesh");
		
		System.out.println("Employees : "+employees.getList());
		System.out.println("Employees2 : "+employees2.getList());
		System.out.println("Employees2 : "+employees3.getList());
	}

}
