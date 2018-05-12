/*
* Package com.rust.asm 
* FileName: AsmGenerator
* Author:   Rust
* Date:     2018/4/28 18:10
* Description: 
* History: 
*===============================================================================================
*   author：          time：                             version：           desc：
*   Rust                 2018/4/28  18:10             1.0                  
*===============================================================================================
*/
package com.rust.asm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import static org.objectweb.asm.Opcodes.V1_7;

/**
 * FileName:    AsmGenerator
 * Author:      Rust
 * Date:        2018/4/28
 * Description: 使用asm创建字节码
 */
public class AsmGenerator {
    public static void main(String[] args) {

        ClassWriter classWriter = new ClassWriter(0);
        classWriter.visit(V1_7,//java版本
                Opcodes.ACC_PUBLIC,//访问修饰符
                "Programmer",//类的全限定名
                null, "java/lang/Object", null
        );
        //    创建构造函数
        MethodVisitor mv = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V");
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(1, 1);
        mv.visitEnd();
        //    定义code方法
        MethodVisitor methodVisitor = classWriter.visitMethod(Opcodes.ACC_PUBLIC, "code", "()V", null, null);
        methodVisitor.visitCode();
        methodVisitor.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        methodVisitor.visitLdcInsn("I'm a programmer");
        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V");
        methodVisitor.visitInsn(Opcodes.RETURN);
        methodVisitor.visitMaxs(2, 2);
        methodVisitor.visitEnd();
    //    使classWrite类已经完成
    //    将classWrite转换成字节数组写到文件里面去
        byte[] data = classWriter.toByteArray();
        try {
            Path paths = Paths.get("D://Programmer.class");
            if (Files.exists(paths)) {
                Files.delete(paths);
            }
            Path path = Files.createFile(paths);

            Files.write(path, data, StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println("write fail");
            e.printStackTrace();
        }
    }
}
