/*
* Package com.rust.cglib 
* FileName: Demo
* Author:   Rust
* Date:     2018/5/11 7:40
* Description: 
* History: 
*===============================================================================================
*   author：          time：                             version：           desc：
*   Rust                 2018/5/11  7:40             1.0                  
*===============================================================================================
*/
package com.rust.cglib;

import java.io.IOException;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * FileName:    Demo
 * Author:      Rust
 * Date:        2018/5/11
 * Description:
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        //    保存一下大变样的class
        //    cglib字节码生成
        //    Enhancer是CGLib的字节码增强器，可以方便的对类进行扩展，内部调用GeneratorStrategy.generate方法生成代理类的字节码，通过以下方式可以生成class文件。
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\cglib");


        CglibProgrammer cp = new CglibProgrammer();
        Hacker hacker = new Hacker();

        //cglib 加强器，创建动态代理
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cp.getClass());
        // 设置回调，这里相当于是对于代理类上所有方法的调用，
        // 都会调用CallBack，而Callback则需要实行intercept()方法进行拦截
        enhancer.setCallback(hacker);
        CglibProgrammer proxyCp = (CglibProgrammer) enhancer.create(CglibProgrammer.class, hacker);
        proxyCp.dowork();





    }



}
