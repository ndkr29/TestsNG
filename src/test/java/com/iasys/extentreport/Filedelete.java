package com.iasys.extentreport;

import java.io.File;

public class Filedelete {
	
	public static void filedelete() {
		File folder = new File(".\\Report");
	    
	    // Check if the folder exists
	    if (folder.exists() && folder.isDirectory()) {
	        // List all files in the folder
	        File[] files = folder.listFiles();
	        
	        // If there are any files, delete them
	        if (files != null) {
	            for (File file : files) {
	                if (file.isFile()) {
	                    if (file.delete()) {
	                        System.out.println("Deleted file: " + file.getName());
	                    } else {
	                        System.out.println("Failed to delete file: " + file.getName());
	                    }
	                }
	            }
	        }
	}
	
	
	
	}
}
	
	


