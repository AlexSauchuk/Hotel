package by.hotel.documentbuilder.impl;

import by.hotel.bean.Reservation;
import by.hotel.bean.ReservationRoom;
import by.hotel.documentbuilder.ExcelDocumentBuilder;
import by.hotel.service.exception.ServiceException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import java.lang.reflect.Field;
import java.util.List;

public class ReservationRoomReportBuilder extends ExcelDocumentBuilder<List<ReservationRoom>>{
    public ReservationRoomReportBuilder() {
        super("Reservation report for user.xls");
    }

    private static class Holder{
        private final static ReservationRoomReportBuilder INSTANCE = new ReservationRoomReportBuilder();
    }

    public static ReservationRoomReportBuilder getInstance(){
        return ReservationRoomReportBuilder.Holder.INSTANCE;
    }

    @Override
    protected void fillDoc(HSSFWorkbook workbook,List<ReservationRoom> documentData) throws ServiceException{
        HSSFSheet sheet = workbook.createSheet("Report");
        int columnsCount = addHeader(sheet, documentData.get(0));
        for (ReservationRoom reservationRoom : documentData) {
            fillRow(sheet, reservationRoom.getReservation());
        }
        CellRangeAddress region = new CellRangeAddress(0,0,0,columnsCount);
        sheet.addMergedRegion(region);
        for (int i=0; i< columnsCount; i++){
            sheet.autoSizeColumn(i);
        }
    }

    private void fillRow(HSSFSheet sheet, Reservation reservation) throws ServiceException{
        Row row = sheet.createRow(sheet.getLastRowNum() + 1);
        setCellStyle(row.createCell(0)).setCellValue(reservation.getId());
        setCellStyle(row.createCell(1)).setCellValue(reservation.getDateIn().toString());
        setCellStyle(row.createCell(2)).setCellValue(reservation.getDateOut().toString());
        setCellStyle(row.createCell(3)).setCellValue(reservation.getUser().getSurname() + " " + reservation.getUser().getName());
        setCellStyle(row.createCell(4)).setCellValue(reservation.getCostAdditionalServices());
        setCellStyle(row.createCell(5)).setCellValue(reservation.getDiscount().getId());
    }

    private int addHeader(HSSFSheet sheet, ReservationRoom reservationRoom){
        createRowWithCells(sheet, "Брони пользователя " + reservationRoom.getReservation().getUser().getUserFullname());
        Row row = createRowWithCells(sheet, null);
        Field[] fields = reservationRoom.getReservation().getClass().getDeclaredFields();
        for (int i=0; i< fields.length; i++){
            setCellStyle(row.createCell(i)).setCellValue(fields[i].getName());
        }
        return fields.length - 1;
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
