package main.java.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
When  the data driven test need to be performed this will generate the required test data
 */
public class DataTableGenerator {

    public Object[][] populateDataTable(String methodName) {

        Object[][] dataTable = null;

        try {

            FileInputStream file = new FileInputStream(new File(new File("").getAbsolutePath() + File.separator + "TestData" + File.separator + methodName + "_Data.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Integer rowcount = sheet.getPhysicalNumberOfRows();

            for (int rowi = 0; rowi < rowcount; rowi++) {

                if(rowi!=0) {
                    Row row = sheet.getRow(rowi);
                    if (dataTable == null) {

                        dataTable = new Object[(rowcount-1)][row.getPhysicalNumberOfCells()];
                    }

                    for (int col = 0; col < row.getPhysicalNumberOfCells(); col++) {

                        dataTable[rowi-1][col] = row.getCell(col).getStringCellValue();
                    }
                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTable;
    }
}
