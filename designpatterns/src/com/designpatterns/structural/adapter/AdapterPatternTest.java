package com.designpatterns.structural.adapter;

public class AdapterPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testClassAdapter();
		testObjectAdapter();
	}
	private static void testClassAdapter(){
		SocketAdapter adapter = new SocketClassAdapterImpl();
		Volt volt120 = getVolt(adapter, 120);
		Volt volt12 = getVolt(adapter, 12);
		Volt volt3 = getVolt(adapter, 3);
		
		System.out.println("Volt 120 Using Class Adapter : "+volt120.getVolts());
		System.out.println("Volt 12  Using Class Adapter : "+volt12.getVolts());
		System.out.println("Volt 3  Using Class Adapter : "+volt3.getVolts());
	}
	
	private static void testObjectAdapter(){
		SocketAdapter adapter = new SocketObjectAdapterImpl();
		Volt volt120 = getVolt(adapter, 120);
		Volt volt12 = getVolt(adapter, 12);
		Volt volt3 = getVolt(adapter, 3);
		System.out.println("Volt 120 Using Object Adapter : "+volt120.getVolts());
		System.out.println("Volt 12  Using Object Adapter : "+volt12.getVolts());
		System.out.println("Volt 3  Using Object Adapter : "+volt3.getVolts());
	}
	private static Volt getVolt(SocketAdapter adapter, int i){
		switch(i){
		case 3 : return adapter.get3Volt();
		case 12 : return adapter.get12Volt();
		case 120 : return adapter.get120Volt();
		default: return adapter.get120Volt();
		}
	}
}
