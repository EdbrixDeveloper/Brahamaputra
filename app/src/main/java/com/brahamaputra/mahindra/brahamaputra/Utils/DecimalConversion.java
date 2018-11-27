package com.brahamaputra.mahindra.brahamaputra.Utils;

public class DecimalConversion {

    public String convertDecimal(String value) {
        String ret_value = "";
        if (!value.isEmpty() && value != null && !value.equals(".") ) {
            float num = Float.valueOf(value);
            if (num > 0) {
                ret_value=String.format("%.2f", num);
            }
        }
        return ret_value;
    }
}
