 /*
  * Package com.rust.jdkdynamic
  * FileName: ProxyUtil
  * Author:   Rust
  * Date:     2018/5/10 15:13
  * Description:
  * History:
  *===============================================================================================
  *   author：          time：                             version：           desc：
  *   Rust                 2018/5/10  15:13                      1.0
  *===============================================================================================
  */
 package com.rust.jdkdynamic;

 import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

 /**
  * FileName:    ProxyUtil
  * Author:      Rust
  * Date:        2018/5/10
  * Description: 下面定义了一个工具类，用来将生成的动态代理类保存到硬盘中：
  */
 public class ProxyUtil {

	 public static void generateClassFile(Class clazz, String proxyName) throws IOException {
		 //根据类信息和提供的代理类名称，生成字节码
		 byte[] bytes = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());

		 String path = clazz.getResource(".").getPath();
		 System.out.println(path);

		 FileOutputStream fos = null;

		 fos = new FileOutputStream(path + proxyName + ".class");
//保留到硬盘中
		 fos.write(bytes);
		 fos.flush();






/*
		 Path path1 = Paths.get(path + proxyName + ".class");

		 if (Files.notExists(path1)) {
			 Files.createFile(path1);
		 }

		 try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path1, StandardCharsets.UTF_8, StandardOpenOption
				 .WRITE)) {

			 bufferedWriter.write(new String(bytes, "UTF-8"));
		 } catch (IOException e) {
			 e.printStackTrace();
		 }*/


	 }


 }
