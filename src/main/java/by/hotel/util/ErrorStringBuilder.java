package by.hotel.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ErrorStringBuilder {
    private ErrorStringBuilder(){}

    public static String buildDeleteErrorString(Map<String, String> rowId, String errorMessage){
        List<String> tableNames = getTableNames(errorMessage);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ошибка. Не удалось удалить строку таблицы "+ tableNames.get(4) +" c ");
        for (String key: rowId.keySet()){
            stringBuilder.append(key + " = " + rowId.get(key) + ", ");
        }
        stringBuilder.append(" т.к. на неё ссылаются записи c " + tableNames.get(3));
        stringBuilder.append(" в таблице "+ tableNames.get(1));
        return stringBuilder.toString();
    }

    private static List<String> getTableNames(String errorMessage){
        List<String> tablesInfo = new ArrayList<String>();
        Pattern pattern = Pattern.compile("`([\\s\\S]+?)`");
        Matcher matcher = pattern.matcher(errorMessage);
        while (matcher.find()){
            tablesInfo.add(matcher.group());
        }
        return tablesInfo;
    }

    public static String buildAddErrorString(Map<String, String> rowId){
        StringBuilder errorStringBuilder = new StringBuilder();
        StringBuilder keysStringBuilder = new StringBuilder();
        errorStringBuilder.append("Ошибка. Невозможно добавить запись");
        for(String key: rowId.keySet()){
            errorStringBuilder.append(" " + key);
            errorStringBuilder.append(" = ");
            errorStringBuilder.append(rowId.get(key));
            keysStringBuilder.append(key + "_");
        }
        errorStringBuilder.append(", т.к. в таблице ");
        errorStringBuilder.append(keysStringBuilder.substring(0,keysStringBuilder.length()-1));
        errorStringBuilder.append(" существует запись с такими значениями ключей");
        return errorStringBuilder.toString();
    }
}
