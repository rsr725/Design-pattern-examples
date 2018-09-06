/**
 * 
 */
package com.designpatterns.builder;

/**
 * @author rajs1
 *
 */
public class Computer {
	//required parameter
	private String ram;
	private String hdd;
	
	//optional parameter
	private boolean isGrapicsCardEnabled;
	private boolean isBuletoothEnabled;
	public String getRam() {
		return ram;
	}
	public String getHdd() {
		return hdd;
	}
	public boolean isGrapicsCardEnabled() {
		return isGrapicsCardEnabled;
	}
	public boolean isBuletoothEnabled() {
		return isBuletoothEnabled;
	}
	
	private Computer(ComputerBuilder builder){
		this.ram = builder.ram;
		this.hdd = builder.hdd;
		this.isBuletoothEnabled = builder.isBuletoothEnabled;
		this.isGrapicsCardEnabled = builder.isGrapicsCardEnabled;
	}
	
	//Builder class
	public static class ComputerBuilder{
		//required parameter
		private String ram;
		private String hdd;
		
		//optional parameter
		private boolean isGrapicsCardEnabled;
		private boolean isBuletoothEnabled;
		
		
		public ComputerBuilder(String ram, String hdd) {
			super();
			this.ram = ram;
			this.hdd = hdd;
		}
		public ComputerBuilder setGrapicsCardEnabled(boolean isGrapicsCardEnabled) {
			this.isGrapicsCardEnabled = isGrapicsCardEnabled;
			return this;
		}
		public ComputerBuilder setBuletoothEnabled(boolean isBuletoothEnabled) {
			this.isBuletoothEnabled = isBuletoothEnabled;
			return this;
		}
		
		public Computer build(){
			return new Computer(this);
		}
	}

	@Override
	public String toString() {
		return "Computer [ram=" + ram + ", hdd=" + hdd + ", isGrapicsCardEnabled=" + isGrapicsCardEnabled
				+ ", isBuletoothEnabled=" + isBuletoothEnabled + "]";
	}
	
}
