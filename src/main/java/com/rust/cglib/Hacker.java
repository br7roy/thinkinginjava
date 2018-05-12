/*
* Package com.rust.cglib 
* FileName: Hacker
* Author:   Rust
* Date:     2018/5/11 7:34
* Description: 
* History: 
*===============================================================================================
*   author：          time：                             version：           desc：
*   Rust                 2018/5/11  7:34             1.0                  
*===============================================================================================
*/
package com.rust.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * FileName:    Hacker
 * Author:      Rust
 * Date:        2018/5/11
 * Description:
 */
public class Hacker implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Hacker.intercept,I'm hacker,see what programmer doing");
        methodProxy.invokeSuper(o, objects);
        System.out.println("****  Oh,what a poor programmer.....");
        return null;
    }
}
