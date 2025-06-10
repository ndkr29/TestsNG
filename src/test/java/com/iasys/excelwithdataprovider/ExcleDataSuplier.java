package com.iasys.excelwithdataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcleDataSuplier {

	public static void main(String[] args) throws Exception {
		File excelFile = new File("./src/test/resources/Test.xlsx");
		System.out.println(excelFile.exists());
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		System.out.println(sheet.getPhysicalNumberOfRows());
		int noofRow = sheet.getPhysicalNumberOfRows();
		int noofClomns= sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[noofRow-1][noofClomns];
		for(int i=0;i< noofRow-1; i++){
			for(int j=0;j< noofClomns; j++) {
				DataFormatter df = new DataFormatter();
				//System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
				//System.out.println(sheet.getRow(i).getCell(j).getStringCellValue()); 
			}
			System.out.println();
			
		}
		System.out.println(sheet.getLastRowNum());
		
		workbook.close();
		fis.close();
		
		for(String[] dataArr: data) {
			System.out.println(Arrays.toString(dataArr));
		}
		
		

	}

}
