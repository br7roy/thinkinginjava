 /*
  * Package com.rust.jdkdynamic
  * FileName: ElectricCarHandler
  * Author:   Rust
  * Date:     2018/5/10 14:28
  * Description:
  * History:
  *===============================================================================================
  *   author：          time：                             version：           desc：
  *   Rust                 2018/5/10  14:28                      1.0
  *===============================================================================================
  */
 package com.rust.jdkdynamic.genbytecode;

 import java.lang.reflect.InvocationHandler;
 import java.lang.reflect.Method;

 /**
  * FileName:    ElectricCarHandler
  * Author:      Rust
  * Date:        2018/5/10
  * Description:
  */
 public class ElectricCarHandler implements InvocationHandler {
	 private ElectricCar electricCar;

	 public ElectricCarHandler(ElectricCar electricCar) {
		 this.electricCar = electricCar;
	 }

	 @Override
	 public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		 System.out.println("ElectricCarHandler" + "method name:" + method.getName() + "invoke start");
		 Object o = method.invoke(electricCar, null);
		 System.out.println("ElectricCarHandler.invoke finish");
		 return o;
	 }


 }
