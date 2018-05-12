package com.rust.jdkdynamic.genbytecode;

/**
 * FileName: ElectricCar
 * Author:   FUTANGHANG004
 * Date:     2018/5/10
 * Description:
 * History:
 */
public class ElectricCar implements Vehicle,Rechargable {
	@Override
	public void charge() {
		System.out.println("ElectricCar.charge" + "car charging");
	}

	@Override
	public void drive() {
		System.out.println("ElectricCar.drive" + "car driving");
	}
}
