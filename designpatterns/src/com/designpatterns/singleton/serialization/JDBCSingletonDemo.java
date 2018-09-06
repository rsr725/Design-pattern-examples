package com.designpatterns.singleton.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class JDBCSingletonDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		/*// TODO Auto-generated method stub
		JDBCSingleton singleton = JDBCSingleton.getInstance();
		
		int updatedCount = singleton.insert("emp100", "Raj Rusia", "Ahmedabad", 5000);
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
		}*/
		
		
		JDBCSingleton singleton = JDBCSingleton.getInstance();
		ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream("filename.ser"));
		objectOutput.writeObject(singleton);
		objectOutput.close();
		
		//deserailize from file to object
		ObjectInput objectInput = new ObjectInputStream(new FileInputStream("filename.ser"));
		JDBCSingleton singleton2 = (JDBCSingleton) objectInput.readObject();
		objectInput.close();
				
		System.out.println(singleton.hashCode());
		System.out.println(singleton2.hashCode());
	}
}
