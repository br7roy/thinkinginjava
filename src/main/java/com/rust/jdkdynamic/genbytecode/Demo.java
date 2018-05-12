/*
 * Package com.rust.jdkdynamic
 * FileName: Demo
 * Author:   Rust
 * Date:     2018/5/10 14:35
 * Description:
 * History:
 *===============================================================================================
 *   author：          time：                             version：           desc：
 *   Rust                 2018/5/10  14:35                      1.0
 *===============================================================================================
 */
package com.rust.jdkdynamic.genbytecode;

import java.io.IOException;
import java.lang.reflect.Proxy;

import com.rust.jdkdynamic.ProxyUtil;

/**
 * FileName:    Demo
 * Author:      Rust
 * Date:        2018/5/10
 * Description:
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        ElectricCar car = new ElectricCar();
        // 1.获取对应的ClassLoader
        ClassLoader classLoader = car.getClass().getClassLoader();
        // 2.获取ElectricCar 所实现的所有接口
        Class[] clazzes = car.getClass().getInterfaces();
        // 3.设置一个来自代理传过来的方法调用请求处理器，处理所有的代理对象上的方法调用
        ElectricCarHandler carHandler = new ElectricCarHandler(car);
        /*
          4.根据上面提供的信息，创建代理对象 在这个过程中，
                         a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
                 b.然后根据相应的字节码转换成对应的class，
                         c.然后调用newInstance()创建实例
         */
        // 创建代理对象
        Object o = Proxy.newProxyInstance(classLoader, clazzes, carHandler);


        Vehicle vehicle = Vehicle.class.cast(o);
        //一旦调用代理对象的方法，就会触发InvocationHandler中的invoke()方法
        vehicle.drive();
        Rechargable rechargable = Rechargable.class.cast(o);
        rechargable.charge();

        ProxyUtil.generateClassFile(car.getClass(), "ElectricCarProxy");

    }
}
