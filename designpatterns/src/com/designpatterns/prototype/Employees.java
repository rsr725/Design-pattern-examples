/**
 * 
 */
package com.designpatterns.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rajs1
 *
 */
public class Employees implements Cloneable{
	private List<String> list;
	public Employees() {
		list = new ArrayList<>();
	}
	public Employees(List<String> list) {
		super();
		this.list = list;
	}
	
	public void loadData(){
		list.add("Raj");
		list.add("Raman");
		list.add("Jigar");
		list.add("Rajesh");
	}
	public List<String> getList() {
		return list;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		List<String> tempList = new ArrayList<>();
		for(String string : list){
			tempList.add(string);
		}
		return new Employees(tempList);
	}
}
