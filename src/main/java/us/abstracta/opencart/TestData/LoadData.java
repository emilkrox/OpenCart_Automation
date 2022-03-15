package us.abstracta.opencart.TestData;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LoadData {

    private HSSFWorkbook hssfWorkbook;
    private HSSFRow row;
    private HSSFCell cell;

    private HSSFSheet loadExcelFile() {
        File file = new File("src/main/java/us/abstracta/opencart/TestData/TestData.xls");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            hssfWorkbook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hssfWorkbook.getSheet("USER_DATA");
    }

    public String getEmail() {
        row = loadExcelFile().getRow(1);
        cell = row.getCell(0);
        return cell.getStringCellValue();
    }

    public String getPassword() {
        row = loadExcelFile().getRow(1);
        cell = row.getCell(1);
        return cell.getStringCellValue();
    }
}
