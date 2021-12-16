package uz.dosya.marketapp.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import uz.dosya.marketapp.entity.SaleProduct;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SaleProductExcelExport {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    List<SaleProduct> saleProducts;

    public SaleProductExcelExport(List<SaleProduct> saleProducts) {
        this.saleProducts = saleProducts;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("saleProduct");
    }

    private void writeHeaderRow() {
        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("Brand");

        cell = row.createCell(1);
        cell.setCellValue("Date");

        cell = row.createCell(2);
        cell.setCellValue("Name");

        cell = row.createCell(3);
        cell.setCellValue("Profit");

        cell = row.createCell(4);
        cell.setCellValue("Quantity");

        cell = row.createCell(5);
        cell.setCellValue("SalePrice");

        cell = row.createCell(6);
        cell.setCellValue("Size");

        cell = row.createCell(7);
        cell.setCellValue("Type");

    }

    private void writeDataRow() {
        int rowCount = 1;
        for (SaleProduct saleProduct : saleProducts) {
            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(saleProduct.getBrand());

            cell = row.createCell(1);
            cell.setCellValue(saleProduct.getDate());

            cell = row.createCell(2);
            cell.setCellValue(saleProduct.getName());

            cell = row.createCell(3);
            cell.setCellValue(saleProduct.getProfit());

            cell = row.createCell(4);
            cell.setCellValue(saleProduct.getQuantity());

            cell = row.createCell(5);
            cell.setCellValue(saleProduct.getSalePrice());

            cell = row.createCell(6);
            cell.setCellValue(saleProduct.getSize());

            cell = row.createCell(7);
            cell.setCellValue(saleProduct.getStatus().toString());

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
