/**
 * 
 */
package com.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author nssindhe
 *
 */
public class ExcellUtils {
	
	public XSSFSheet getExcelValue(String excelName, String sheetName){
		XSSFSheet sht=null;
		
		try{
			FileInputStream fis = new FileInputStream(excelName);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			sht = wb.getSheet(sheetName);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return sht;
	}
	public String getField(XSSFSheet sht, int rowNum,int cellNum){
		
		String str  = null;
		
		try{
			str=sht.getRow(rowNum).getCell(cellNum).getStringCellValue();
			System.out.println(str);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return str;
	}

}
