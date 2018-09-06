/**
 * 
 */
package com.designpatterns.abstractfactory;

/**
 * @author rajs1
 *
 */
public class PCFactory implements ComputerAbstractFactory{
	private String ram;
	private String hdd;
	private String cpu;
	
	public PCFactory(String ram, String hdd, String cpu) {
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public Computer getComputer() {
		// TODO Auto-generated method stub
		return new PC(ram, hdd, cpu);
	}
	
}
