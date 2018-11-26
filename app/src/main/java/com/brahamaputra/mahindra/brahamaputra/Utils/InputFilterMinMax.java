package com.brahamaputra.mahindra.brahamaputra.Utils;

import android.text.InputFilter;
import android.text.Spanned;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputFilterMinMax implements InputFilter {
    private Double minimumValue;
    private Double maximumValue;
    Pattern mPattern;

    public InputFilterMinMax(Double minimumValue, Double maximumValue, int digitsBeforeZero, int digitsAfterZero) {
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        mPattern = Pattern.compile("[0-9]{0," + (digitsBeforeZero - 1) + "}+((\\.[0-9]{0," + (digitsAfterZero - 1) + "})?)||(\\.)?");
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            Matcher matcher = mPattern.matcher(dest);
            Double input = Double.parseDouble(dest.subSequence(0, dstart).toString() + source + dest.subSequence(dend, dest.length()));
            if (isInRange(minimumValue, maximumValue, input) && matcher.matches())
                return null;
        } catch (NumberFormatException nfe) {
        }
        return "";
    }

    private boolean isInRange(Double a, Double b, Double c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}
