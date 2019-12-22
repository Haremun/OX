package com.bieganski.ox;

import java.util.regex.Pattern;

class PositionValidator implements Validator {

    @Override
    public boolean checkString(String textToValidate) {
        return Pattern
                .compile("^[0-9]+ [0-9]+$")
                .matcher(textToValidate)
                .find();
    }
}
