package com.designpatterns.singleton.enum_;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JDBCSingletonDemo {

	public static void main(String[] args) {
		int updatedCount = EnumSingleton.INSTANCE.insert("emp100", "Raj Rusia", "Ahmedabad", 5000);
		if(updatedCount > 0){
			System.out.println("Record inserted successfully");
		}else{
			System.out.println("Data has not been inserted");
		}
		
		List<Map<String, Object>> list = null;
		try {
			list = EnumSingleton.INSTANCE.view("emp106");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
