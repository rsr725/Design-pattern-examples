package com.designpatterns.abstractfactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer computer = ComputerFactory.getComputer(new PCFactory("4GB", "500GB", "2.7"));
		System.out.println(computer);
		Computer computer2 = ComputerFactory.getComputer(new ServerFactory("16GB", "1TB", "2.7"));
		System.out.println(computer2);
		
	}

}
