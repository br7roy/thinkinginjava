 /*
  * Package com.rust.dynamic
  * FileName: Demo
  * Author:   Rust
  * Date:     2018/5/10 10:45
  * Description:
  * History:
  *===============================================================================================
  *   author：          time：                             version：           desc：
  *   Rust                 2018/5/10  10:45                      1.0
  *===============================================================================================
  */
 package com.rust.javassist;

 import java.lang.reflect.Constructor;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewConstructor;

 /**
  * FileName:    Demo
  * Author:      Rust
  * Date:        2018/5/10
  * Description:	使用javassist动态创建字节码
  */
 public class Demo {
	 public static void main(String[] args) throws Throwable {
		 // 动态的创建字节码
		 ClassPool classPool = ClassPool.getDefault();

		 CtClass poxyStationClazz = classPool.makeClass("com.rust.javassist.StationProxy");

		 //设置接口
		 CtClass interface1 = classPool.get("com.rust.javassist.TicketService");

		 poxyStationClazz.setInterfaces(new CtClass[]{interface1});

		 // 设置field
		 CtField field = CtField.make("private com.rust.javassist.Station station;", poxyStationClazz);
		 poxyStationClazz.addField(field);

		 CtClass stationClazz = classPool.get("com.rust.javassist.Station");
		 CtClass[] ctClasses = new CtClass[]{stationClazz};
		 CtConstructor ctConstructor = CtNewConstructor.make(ctClasses, null, CtNewConstructor.PASS_NONE, null, null, poxyStationClazz);

		 // 设置构造函数内置信息
		 ctConstructor.setBody("{this.station=$1;}");
		 poxyStationClazz.addConstructor(ctConstructor);

		 //创建收取手续 takeHandlingFee方法
		 CtMethod takeHandlingFee = CtMethod.make("private void takeHandlingFee() {}", poxyStationClazz);
		 takeHandlingFee.setBody("System.out.println(\"收取手续费，打印发票。。。。。\");");
		 poxyStationClazz.addMethod(takeHandlingFee);

		 //创建showAlertInfo 方法
		 CtMethod showInfo = CtMethod.make("private void showAlertInfo(String info) {}", poxyStationClazz);
		 showInfo.setBody("System.out.println($1);");
		 poxyStationClazz.addMethod(showInfo);

		 //sellTicket
		 CtMethod sellTicket = CtMethod.make("public void sellTicket(){}", poxyStationClazz);
		 sellTicket.setBody("{this.showAlertInfo(\"××××您正在使用车票代售点进行购票，每张票将会收取5元手续费！××××\");"
				 + "station.sellTicket();"
				 + "this.takeHandlingFee();"
				 + "this.showAlertInfo(\"××××欢迎您的光临，再见！××××\");}");
		 poxyStationClazz.addMethod(sellTicket);

		 //添加inquire方法
		 CtMethod inquire = CtMethod.make("public void inquire() {}", poxyStationClazz);
		 inquire.setBody("{this.showAlertInfo(\"××××欢迎光临本代售点，问询服务不会收取任何费用，本问询信息仅供参考，具体信息以车站真实数据为准！××××\");"
				 + "station.inquire();"
				 + "this.showAlertInfo(\"××××欢迎您的光临，再见！××××\");}"
		 );
		 poxyStationClazz.addMethod(inquire);

		 //添加widthraw方法
		 CtMethod withdraw = CtMethod.make("public void withDraw() {}", poxyStationClazz);
		 withdraw.setBody("{this.showAlertInfo(\"××××欢迎光临本代售点，退票除了扣除票额的20%外，本代理处额外加收2元手续费！××××\");"
				 + "station.withDraw();"
				 + "this.takeHandlingFee();}"
		 );
		 poxyStationClazz.addMethod(withdraw);

		 //获取动态生成的class
		 Class c = poxyStationClazz.toClass();
		 //获取构造器
		 @SuppressWarnings("unchecked")
		 Constructor constructor = c.getConstructor(Station.class);
		 //通过构造器实例化
		 TicketService o = (TicketService) constructor.newInstance(new Station());
		 o.inquire();
		 poxyStationClazz.writeFile("D://test");

	 }
 }
