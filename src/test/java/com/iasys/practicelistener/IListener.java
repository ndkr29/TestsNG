package com.iasys.practicelistener;

public interface IListener {

	default void duringTest() {
		
	}
	
	default void afterTest() {
		
	}
	
	 void beforeTest() ;
		
	
	
	
	   void generate() ;
}
