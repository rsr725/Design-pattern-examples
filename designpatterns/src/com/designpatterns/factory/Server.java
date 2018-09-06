/**
 * 
 */
package com.designpatterns.factory;

/**
 * @author rajs1
 *
 */
public class Server extends Computer{
	private String ram;
	private String hdd;
	private String cpu;
	
	public Server(String ram, String hdd, String cpu) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public String getRam() {
		// TODO Auto-generated method stub
		return this.ram;
	}

	@Override
	public String getHDD() {
		// TODO Auto-generated method stub
		return this.hdd;
	}

	@Override
	public String getCPU() {
		// TODO Auto-generated method stub
		return this.cpu;
	}

}
