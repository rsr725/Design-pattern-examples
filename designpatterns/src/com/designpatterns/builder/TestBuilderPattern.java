package com.designpatterns.builder;

public class TestBuilderPattern {

	public static void main(String[] args) {
		//Using builder to get the object in a single line of code and 
        //without any inconsistent state or arguments management issues	
		Computer computer = new Computer.ComputerBuilder("4GB","500GB").setGrapicsCardEnabled(true).setBuletoothEnabled(false).build();
		System.out.println(computer);
				
	}

}
