package com.designpatterns.singleton.lazy;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.designpatterns.singleton.billpugh.JDBCSingleton;

import java.util.Set;

public class JDBCSingletonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JDBCSingleton singleton = JDBCSingleton.getInstance();
		
		int updatedCount = singleton.insert("emp102", "Raj Rusia", "Ahmedabad", 5000);
		if(updatedCount > 0){
			System.out.println("Record inserted successfully");
		}else{
			System.out.println("Data has not been inserted");
		}
		
		JDBCSingleton singleton2 = JDBCSingleton.getInstance();
		List<Map<String, Object>> list = null;
		try {
			list = singleton.view("emp106");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!list.isEmpty()){
			System.out.println("Emp City\tEmp Name\tEmp Id\tEmp Salary");
			for(Map<String, Object> map : list){
				for(Map.Entry m : map.entrySet()){
					if("id".equalsIgnoreCase(m.getKey().toString()))
						System.out.print(m.getValue()+"\t");
					if("name".equalsIgnoreCase(m.getKey().toString()))
						System.out.print(m.getValue()+"\t");
					if("city".equalsIgnoreCase(m.getKey().toString()))
						System.out.print(m.getValue()+"\t");
					if("salary".equalsIgnoreCase(m.getKey().toString()))
						System.out.print(m.getValue()+"\t");
				}
				System.out.println();
			}
		}
	}
}
