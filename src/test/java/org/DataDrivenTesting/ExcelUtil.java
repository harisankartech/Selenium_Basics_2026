package org.DataDrivenTesting;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {
    static Workbook book;
   static Sheet sheet;
   static String path = System.getProperty("user.dir")+"\\Resources\\credentials.xlsx";

   public  Object[][] getExcelData(String sheetName) throws IOException {
       FileInputStream fileInputStream = null;

       try {
           fileInputStream = new FileInputStream(path);
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       }
       book = WorkbookFactory.create(fileInputStream);
       sheet = book.getSheet(sheetName);
       Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

       for(int i=0;i<sheet.getLastRowNum();i++){
           for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
               data[i][j]=sheet.getRow(i+1).getCell(j).toString();
           }
       }

       return data;
   }

   @DataProvider
   public  Object[][] getData() throws IOException {
       return getExcelData("Sheet1");
   }
}
