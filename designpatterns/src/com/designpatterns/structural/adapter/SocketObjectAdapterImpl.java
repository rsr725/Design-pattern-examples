package com.designpatterns.structural.adapter;

public class SocketObjectAdapterImpl implements SocketAdapter{
	private Socket socket = new Socket();
	@Override
	public Volt get120Volt() {
		return socket.getVolt();
	}

	@Override
	public Volt get12Volt() {
		Volt volt = socket.getVolt();
		return currentVolt(volt, 10);
	}

	@Override
	public Volt get3Volt() {
		Volt volt = socket.getVolt();
		return currentVolt(volt, 40);
	}
	private Volt currentVolt(Volt volt, int i){
		return new Volt(volt.getVolts()/i);
	}
}
