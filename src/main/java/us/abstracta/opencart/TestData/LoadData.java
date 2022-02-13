package us.abstracta.opencart.TestData;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoadData {

    public static HSSFWorkbook hssfWorkbook;
    public static HSSFSheet sheet;
    public HSSFRow row;
    public HSSFCell cell;

    public HSSFSheet loadExcelFile() throws FileNotFoundException {
        File file = new File("src/main/java/us/abstracta/opencart/TestData/TestData.xls");
        FileInputStream inputStream = new FileInputStream(file);
        try {
            hssfWorkbook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = hssfWorkbook.getSheet("USER_DATA");
        return sheet;
    }

    public String getEmail() {
        try {
            row = loadExcelFile().getRow(1);
            cell = row.getCell(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cell.getStringCellValue();
    }

    public String getPassword() {
        try {
            row = loadExcelFile().getRow(1);
            cell = row.getCell(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cell.getStringCellValue();
    }
}
