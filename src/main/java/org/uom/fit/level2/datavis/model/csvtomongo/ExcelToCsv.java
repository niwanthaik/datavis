package org.uom.fit.level2.datavis.model.csvtomongo;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.Iterator;

/**
 * Created by niwantha on 3/8/17.
 */
public class ExcelToCsv {

    public static void xlsx(File inputFile, File outputFile) {
        // For storing data into CSV files
        StringBuffer data = new StringBuffer();
        try {
            FileOutputStream fos = new FileOutputStream(outputFile);

            // Get the workbook object for XLSX file
            XSSFWorkbook wBook = new XSSFWorkbook(new FileInputStream(inputFile));

            // Get first sheet from the workbook
            XSSFSheet sheet = wBook.getSheetAt(0);
            Row row;
            Cell cell;

            // Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                row = rowIterator.next();

                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {

                    cell = cellIterator.next();

                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            data.append(cell.getBooleanCellValue() + ",");

                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            data.append(cell.getNumericCellValue() + ",");

                            break;
                        case Cell.CELL_TYPE_STRING:
                            data.append(cell.getStringCellValue() + ",");
                            break;

                        case Cell.CELL_TYPE_BLANK:
                            data.append(",");
                            break;
                        default:
                            data.append(cell + ",");

                    }
                }
                data.append("\n");
            }

            fos.write(data.toString().getBytes());
            fos.close();

        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
    }
}
