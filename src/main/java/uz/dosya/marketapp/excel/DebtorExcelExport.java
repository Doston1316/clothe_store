package uz.dosya.marketapp.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import uz.dosya.marketapp.entity.Debtor;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DebtorExcelExport {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    List<Debtor> debtors;

    public DebtorExcelExport(List<Debtor> debtors) {
        this.debtors = debtors;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("debtor");
    }

    public void writeHeaderRow() {
        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("FirstName");

        cell = row.createCell(1);
        cell.setCellValue("LastName");

        cell = row.createCell(2);
        cell.setCellValue("ProductName");

        cell = row.createCell(3);
        cell.setCellValue("PhoneNumber");

        cell = row.createCell(4);
        cell.setCellValue("Date");

        cell = row.createCell(5);
        cell.setCellValue("Description");

    }

    public void writeDateRow() {
        int rowCount = 1;
        for (Debtor debtor : debtors) {
            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(debtor.getFirstName());

            cell=row.createCell(1);
            cell.setCellValue(debtor.getLastName());

            cell=row.createCell(2);
            cell.setCellValue(debtor.getProductName());

            cell=row.createCell(3);
            cell.setCellValue(debtor.getPhone());

            cell=row.createCell(4);
            cell.setCellValue(debtor.getDate());

            cell=row.createCell(5);
            cell.setCellValue(debtor.getDescription());
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDateRow();
        ServletOutputStream outputStream=response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
    }
}
