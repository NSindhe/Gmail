package com.BaseTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class BaseClass {
	
	@Test
	public void base(){
		try
		{
			//boolean res;
			FileInputStream fis = new FileInputStream("C:\\Users\\nssindhe\\Desktop\\Inputs1.xlsx");
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			
			XSSFSheet st=wb.getSheet("TestCase1");
			
			int lastrow=st.getLastRowNum();
			System.out.println(lastrow);
			
			for(int i=1;i<=lastrow;i++)
			{
				System.out.println("Entered in for loop");
				
				String flag=st.getRow(i).getCell(2).getStringCellValue();
				if((flag).equalsIgnoreCase("yes"))
				{
					String className=st.getRow(i).getCell(0).getStringCellValue();
					String packageName=st.getRow(i).getCell(1).getStringCellValue();
					System.out.println("Class Name : "+className+" Package Name : "+packageName);
					//Reflection is used, because by this we can inspect classes,methods at runtime.
					Class<?> cls = Class.forName(packageName+"."+className);
					Object obj = cls.newInstance();
					
					System.out.println(className);
					
					Method m1 = cls.getMethod("beforeMethod", null);
					m1.invoke(obj, null);
					
					System.out.println("Before Method");
					
					Method m2 = cls.getMethod("verifyValidateNext", null);
					boolean exeresult = true; 
					m2.invoke(obj, null);
					
					System.out.println("Test Method");
					
					if(exeresult==true)
					{
						st.getRow(i).getCell(3).setCellValue("Pass");
						System.out.println("Passed" + className);
						
					}
					else
					{
						st.getRow(i).getCell(3).setCellValue("Fail");
						System.out.println("Passed" + className);
					}
					
					System.out.println("After Method");
					Method m3 = cls.getMethod("afterMethod",null);
					m3.invoke(obj, null);
					
					
				}
				
			}
			FileOutputStream outs = new FileOutputStream("C:\\Users\\nssindhe\\Desktop\\Inputs1.xlsx");
			wb.write(outs);
			wb.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
