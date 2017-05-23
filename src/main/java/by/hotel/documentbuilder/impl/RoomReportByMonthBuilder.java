package by.hotel.documentbuilder.impl;

import by.hotel.bean.Report;
import by.hotel.bean.RoomReport;
import by.hotel.documentbuilder.ExcelDocumentBuilder;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

public class RoomReportByMonthBuilder extends ExcelDocumentBuilder<Report> {
    private static final int HEADER_ROWS_COUNT = 2;

    public RoomReportByMonthBuilder() {
        super("Room report by month.xls");
    }

    private static class Holder{
        private final static RoomReportByMonthBuilder INSTANCE = new RoomReportByMonthBuilder();
    }

    public static RoomReportByMonthBuilder getInstance(){
        return RoomReportByMonthBuilder.Holder.INSTANCE;
    }

    @Override
    protected void fillDoc(HSSFWorkbook workbook, Report documentData) {
        int currentColumn = 0;
        List<RoomReport> reports = documentData.getData();
        HSSFSheet sheet = workbook.createSheet("Report " + documentData.getYear());
        while(reports.size() > 1){
            Row row = createOrGetRowWithCells(sheet, "Название комнаты:", 0,currentColumn);
            row.getCell(currentColumn + 1).setCellValue(reports.get(0).getRoomName());
            addHeader(sheet, currentColumn);
            addMonth(sheet, currentColumn);
            fillSheet(sheet, reports, currentColumn);
            sheet.autoSizeColumn(currentColumn);
            sheet.autoSizeColumn(currentColumn + 1);
            currentColumn += 7;
        }
        sheet.createRow(sheet.getLastRowNum() + 1);
        sheet.createRow(sheet.getLastRowNum() + 1);
        setRowForTotal(sheet, reports.get(0).getTotal(), 0);
    }

    private void fillSheet(HSSFSheet sheet, List<RoomReport> reports, int column) {
        while(reports.get(0).getPeriodNumber() != 0){
            Row row  = sheet.getRow(HEADER_ROWS_COUNT - 1 + reports.get(0).getPeriodNumber());
            row.getCell(column + 1).setCellValue(reports.get(0).getTotal());
            reports.remove(0);
        }
        setRowForTotal(sheet, reports.get(0).getTotal(),column);
        reports.remove(0);
    }

    private void addHeader(HSSFSheet sheet, int column){
        Row columnTitles = createOrGetRowWithCells(sheet, "Месяц", 1, column);
        columnTitles.getCell(column + 1).setCellValue("Выручка, руб.");
    }

    private void addMonth(HSSFSheet sheet, int column){
        Locale locale = Locale.forLanguageTag("ru");
        for (Month month: Month.values()){
            Row row = createOrGetRowWithCells(sheet, month.getDisplayName(TextStyle.FULL_STANDALONE, locale),
                    HEADER_ROWS_COUNT + month.ordinal(),column);
            row.getCell(column + 1).setCellValue(0);
        }
        createOrGetRowWithCells(sheet, null,HEADER_ROWS_COUNT + Month.values().length, column);
        createOrGetRowWithCells(sheet, null,HEADER_ROWS_COUNT + 1 + Month.values().length, column);
    }

    private Row createOrGetRowWithCells(HSSFSheet sheet, String cellValue, int rowIndex, int column){
        Row row = sheet.getRow(rowIndex);
        if(row == null) {
            row = sheet.createRow(sheet.getRow(0) == null ? sheet.getLastRowNum() : sheet.getLastRowNum() + 1);
        }
        Cell cell = row.createCell(column);
        cell.setCellValue(cellValue);
        setCellStyle(cell);
        setCellStyle(row.createCell(column + 1));
        return row;
    }

    private Cell setCellStyle(Cell cell){
        CellStyle cellStyle = cell.getCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(CellStyle.ALIGN_CENTER);
        return cell;
    }

    private void setRowForTotal(HSSFSheet sheet, int value, int column){
        Row row = createOrGetRowWithCells(sheet, "Всего:", sheet.getLastRowNum(),column);
        row.getCell(column + 1).setCellValue(value);
    }
}
