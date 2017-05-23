package by.hotel.documentbuilder.impl;

import by.hotel.bean.FinancialReport;
import by.hotel.bean.Report;
import by.hotel.documentbuilder.ExcelDocumentBuilder;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.List;

public class FinancialReportByQuarterBuilder extends ExcelDocumentBuilder<Report>{
    private static final int QUARTER_COUNT = 4;

    public FinancialReportByQuarterBuilder() {
        super("Financial report by quarter.xls");
    }

    private static class Holder{
        private final static FinancialReportByQuarterBuilder INSTANCE = new FinancialReportByQuarterBuilder();
    }

    public static FinancialReportByQuarterBuilder getInstance(){
        return FinancialReportByQuarterBuilder.Holder.INSTANCE;
    }

    @Override
    protected void fillDoc(HSSFWorkbook workbook, Report documentData) {
        HSSFSheet sheet = workbook.createSheet("Report");
        addHeader(sheet, "Год " + documentData.getYear());
        addQuarter(sheet);
        fillSheet(sheet, documentData);
        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
    }

    private void fillSheet(HSSFSheet sheet, Report documentData) {
        List<FinancialReport> reports = documentData.getData();
        for (int i=0; i< reports.size()-1; i++){
            Row row  = sheet.getRow(sheet.getLastRowNum() - QUARTER_COUNT + reports.get(i).getPeriodNumber());
            row.getCell(1).setCellValue(reports.get(i).getTotal());
        }
        createRowWithCells(sheet, null);
        createRowWithCells(sheet, "Всего:");
        sheet.getRow(sheet.getLastRowNum()).getCell(1).setCellValue(reports.get(reports.size() - 1).getTotal());
    }

    private void addHeader(HSSFSheet sheet, String header){
        createRowWithCells(sheet, header);
        CellRangeAddress region = new CellRangeAddress(0,0,0,1);
        sheet.addMergedRegion(region);
        Row columnTitles = createRowWithCells(sheet, "Квартал");
        columnTitles.getCell(1).setCellValue("Выручка, руб.");
    }

    private void addQuarter(HSSFSheet sheet){
        for (int i=0; i< QUARTER_COUNT; i++){
            Row row = createRowWithCells(sheet, (i+1) + "-й квартал");
            row.getCell(1).setCellValue(0);
        }
    }

    private Row createRowWithCells(HSSFSheet sheet, String cellValue){
        Row row = sheet.createRow(sheet.getRow(0) == null ? sheet.getLastRowNum() : sheet.getLastRowNum() + 1);
        Cell cell = row.createCell(0);
        cell.setCellValue(cellValue);
        setCellStyle(cell);
        setCellStyle(row.createCell(1));
        return row;
    }

    private Cell setCellStyle(Cell cell){
        CellStyle cellStyle = cell.getCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);
        return cell;
    }
}
