/*
* Package com.rust.javassist 
* FileName: MyGenerator
* Author:   Rust
* Date:     2018/5/2 18:02
* Description: 
* History: 
*===============================================================================================
*   author：          time：                             version：           desc：
*   Rust                 2018/5/2  18:02             1.0                  
*===============================================================================================
*/
package com.rust.javassist;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * FileName:    MyGenerator
 * Author:      Rust
 * Date:        2018/5/2
 * Description:
 */
public class MyGenerator {
    public static void main(String[] args) {
        ClassPool classPool = ClassPool.getDefault();
        //    创建Programmer类
        try {
            CtClass cc = classPool.makeClass("com.rust.javassist.Programmer");
            CtMethod cm = CtMethod.make("public void code(){}", cc);
            cm.insertBefore("System.out.println(\"I'm a Programmer!!\");");
            cc.addMethod(cm);
            cc.writeFile("D://temp");
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
