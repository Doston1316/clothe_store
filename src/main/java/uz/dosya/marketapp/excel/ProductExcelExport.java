package uz.dosya.marketapp.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import uz.dosya.marketapp.entity.Product;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductExcelExport {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    List<Product> products;

    public ProductExcelExport(List<Product> products) {
        this.products = products;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Product");
    }


    private void writeHeaderRow() {
        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("Brand");

        cell = row.createCell(1);
        cell.setCellValue("Color");

        cell = row.createCell(2);
        cell.setCellValue("Name");

        cell = row.createCell(3);
        cell.setCellValue("Price");

        cell = row.createCell(4);
        cell.setCellValue("Quantity");

        cell = row.createCell(5);
        cell.setCellValue("Size");

    }

    private void writeDataRow() {
        int rowCount = 1;
        for (Product product : products) {
            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(product.getBrand());

            cell = row.createCell(1);
            cell.setCellValue(product.getColor());

            cell = row.createCell(2);
            cell.setCellValue(product.getName());

            cell = row.createCell(3);
            cell.setCellValue(product.getPrice());

            cell = row.createCell(4);
            cell.setCellValue(product.getQuantity());

            cell = row.createCell(5);
            cell.setCellValue(product.getSize());

        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDataRow();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
    }


}
