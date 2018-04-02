package com.example.webmagic.util;

import java.util.UUID;

public class Uuid {

	   
	  /**
	   * 随机生成UUID
	   * @return
	   */
	  public static String getUUID(){
	    UUID uuid=UUID.randomUUID();
	    String str = uuid.toString(); 
	    String uuidStr=str.replace("-", "");
	    return uuidStr;
	  }
	  /**
	   * 根据字符串生成固定UUID
	   * @param name
	   * @return
	   */
	  public static String getUUID(String name){
	    UUID uuid=UUID.nameUUIDFromBytes(name.getBytes());
	    String str = uuid.toString(); 
	    String uuidStr=str.replace("-", "");
	    return uuidStr;
	  }
	  
	  public static void main(String[] args) {

		  System.out.println(getUUID().length());
	}
	 
}
