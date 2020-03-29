package com.ebanking.utility;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLUtils {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook workbook;
    public static XSSFSheet wSheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static int getRowCount(String xlFile,String xlSheet) throws IOException {
        fi = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fi);
        wSheet = workbook.getSheet(xlSheet);
        int rowCount = wSheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rowCount;
    }
    public static int getCellCount(String xlFile,String xlSheet,int rowNumber) throws IOException {
        fi = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fi);
        wSheet = workbook.getSheet(xlSheet);
        row = wSheet.getRow(rowNumber);
        int cellCount = wSheet.getLastRowNum();
        workbook.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData(String xlFile,String xlSheet,int rowNumber,int cellNumber) throws IOException {
        fi = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fi);
        wSheet =workbook.getSheet(xlSheet);
        row = wSheet.getRow(rowNumber);
        cell = row.getCell(cellNumber);
        String data;
        try{
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        }catch (Exception e){
            data = "";
        }
        workbook.close();
        fi.close();
        return data;
    }
    public static void setCellData(String xlFile,String xlSheet,int rowNumber,int cellNumber,String data) throws IOException {
        fi = new FileInputStream(xlFile);
        workbook = new XSSFWorkbook(fi);
        wSheet = workbook.getSheet(xlSheet);
        row = wSheet.getRow(rowNumber);
        cell = row.createCell( cellNumber);
        cell.setCellValue(data);
        fo = new FileOutputStream(xlFile);
        workbook.write(fo);
        workbook.close();
        fi.close();
        fo.close();
    }
}
