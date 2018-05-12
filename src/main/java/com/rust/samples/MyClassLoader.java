/*
* Package com.rust.samples 
* FileName: MyClassLoader
* Author:   Rust
* Date:     2018/4/28 16:55
* Description: 
* History: 
*===============================================================================================
*   author：          time：                             version：           desc：
*   Rust                 2018/4/28  16:55             1.0                  
*===============================================================================================
*/
package com.rust.samples;

/**
 * FileName:    MyClassLoader
 * Author:      Rust
 * Date:        2018/4/28
 * Description:
 */
public class MyClassLoader extends ClassLoader {

    public Class<?> defineMyClass(byte[] b, int off, int len) {
        return super.defineClass(b, off, len);
    }
}