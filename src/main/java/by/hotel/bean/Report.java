package by.hotel.bean;

import by.hotel.builder.ReportBuilder;

import java.util.ArrayList;
import java.util.List;

public class Report<T> {
    private String year;
    private List<T> data;

    public Report(){
        super();
    }

    public Report(ReportBuilder reportBuilder){
        this.year = reportBuilder.getYear();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void addItem(T value){
        if(data == null){
            data = new ArrayList<>();
        }
        data.add(value);
    }

    public List<T> getData() {
        return data;
    }
}
