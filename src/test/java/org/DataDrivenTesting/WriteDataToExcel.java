package org.DataDrivenTesting;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WriteDataToExcel {
    public static void main(String[] args) throws IOException {

        Map<String, Object> data = new TreeMap<>();
        data.put("1",new Object[]{"id","firstname","lastname"});
        data.put("2",new Object[]{"1","hari","sankar"});
        data.put("3",new Object[]{"2","akshay","reji"});
        data.put("4",new Object[]{"3","arya","reji"});

        Set<String>key = data.keySet();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("practice");
        int rowNum = 0;

        for(String k:key){
            Row row = sheet.createRow(rowNum++);
            Object[] objA = (Object[]) data.get(k);
            int cellNum = 0;
            for(Object o:objA){
                Cell cell = row.createCell(cellNum++);
                cell.setCellValue((String) o);
            }
        }
        FileOutputStream outputStream = new FileOutputStream(new File("PracticeExcel.xlsx"));
        workbook.write(outputStream);
        outputStream.close();

    }
}
