/*
* Package com.rust.samples 
* FileName: MyTest
* Author:   Rust
* Date:     2018/4/28 17:06
* Description: 
* History: 
*===============================================================================================
*   author：          time：                             version：           desc：
*   Rust                 2018/4/28  17:06             1.0                  
*===============================================================================================
*/
package com.rust.samples;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * FileName:    MyTest
 * Author:      Rust
 * Date:        2018/4/28
 * Description:
 */
public class MyTest {
    public static void main(String[] args) {

        try {
            byte[] bytes = Files.readAllBytes(Paths.get("D:\\Programmer.class"));

            MyClassLoader myClassLoader = new MyClassLoader();

            Class clazz = myClassLoader.defineMyClass(bytes, 0, bytes.length);

            System.out.println(clazz.getCanonicalName());

            Object o = clazz.newInstance();

            Method method = clazz.getMethod("code", null);

            method.invoke(o, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
}
