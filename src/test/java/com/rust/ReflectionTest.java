/*
* Package com.rust 
* FileName: ReflectionTest
* Author:   Rust
* Date:     2018/4/28 17:47
* Description: 
* History: 
*===============================================================================================
*   author：          time：                             version：           desc：
*   Rust                 2018/4/28  17:47             1.0                  
*===============================================================================================
*/
package com.rust;

import java.lang.reflect.Field;

import org.junit.Test;

import com.rust.samples.Constant;

/**
 * FileName:    ReflectionTest
 * Author:      Rust
 * Date:        2018/4/28
 * Description:
 */
public class ReflectionTest {
    @Test
    public void test() throws IllegalAccessException {
        Class cls = Constant.class;
        for (Field field : cls.getFields()) {
            field.setAccessible(true);
            Object o = field.get(null);
            System.out.println(o);
        }






    }
}
