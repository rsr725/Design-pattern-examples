/**
 * 
 */
package com.designpatterns.abstractfactory;

/**
 * @author rajs1
 *
 */
public class ComputerFactory {
	public static Computer getComputer(ComputerAbstractFactory factory){
		return factory.getComputer();
	}
}
