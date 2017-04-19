package by.hotel.util;

import java.util.HashMap;
import java.util.Map;

public class ParametersParser {
    private ParametersParser(){}

    public static Map<String, String[]> parseParameters(String params){
        String[] arrayParams = params.split("&");
        Map<String,String[]> paramsMap = new HashMap<String, String[]>();
        for (String parameter: arrayParams) {
            String[] currentKeyValue = parameter.split(":");
            paramsMap.put(currentKeyValue[0],new String[] { (currentKeyValue.length > 1) ? currentKeyValue[1] : "null"});
        }
        return paramsMap;
    }
}
