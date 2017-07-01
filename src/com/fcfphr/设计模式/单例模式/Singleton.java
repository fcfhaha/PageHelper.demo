package com.fcfphr.设计模式.单例模式;


/**
 * 说明：懒汉模式
 *
 * @author 范范
 *
 * 2017年3月1日
 */
public class Singleton {
	private static final Singleton singleton = new Singleton();
	private Singleton(){}
	public static Singleton getInstance(){
		return singleton;
	}
}
/**
 * 说明：饿汉模式
 *
 * @author 范范
 *
 * 2017年3月1日
 */
 class Singleton2{
	 private static Singleton2 singleton;
	 private Singleton2(){}
	 public static synchronized Singleton2 getInstance(){
		 if(singleton==null){
			 singleton = new Singleton2();
		 }
		 return singleton;
	 }
	 
 }
 /**
  * 说明：内部类方式
  *
  * @author 范范
  *
  * 2017年3月1日
  */

 class Singleton3{
	 private Singleton3(){}
	public static class inClass{
		 static Singleton3 singleton = new Singleton3();
	 }
	 public static Singleton3 getInstance(){
		 return inClass.singleton;
	 }
 }
 /**
  * 说明：双层检查方式
  *
  * @author 范范
  *
  * 2017年3月1日
  */
 class Singleton4{
	 private static volatile Singleton4 sington;
	 private Singleton4(){}
	 public static Singleton4 getInstance(){
		 if (sington==null) {
			 synchronized(Singleton4.class){
				 if (sington==null) {
					 sington = new Singleton4();
					
				}
			 }
			
		}
		 return sington;
	 }
 }