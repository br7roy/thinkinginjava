 /*
  * Package com.rust.dynamic
  * FileName: Station
  * Author:   Rust
  * Date:     2018/5/10 10:38
  * Description:
  * History:
  *===============================================================================================
  *   author：          time：                             version：           desc：
  *   Rust           2018/5/10  10:38                      1.0
  *===============================================================================================
  */
 package com.rust.javassist;

 /**
  * FileName:    Station
  * Author:      Rust
  * Date:        2018/5/10
  * Description:
  */
 public class Station implements TicketService {
	 @Override
	 public void inquire() {
		 System.out.println("Station.inquire");
	 }

	 @Override
	 public void sellTicket() {
		 System.out.println("Station.sellTicket");
	 }

	 @Override
	 public void withDraw() {
		 System.out.println("Station.withDraw");
	 }
 }
