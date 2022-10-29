package com.company.validator;

import static com.company.constants.validation.ValidationLayerConstants.decoder;
import static com.company.constants.validation.ValidationLayerConstants.encoder;

public class PasswordValidation {

    public static String passwordEncoder(String password) {
        return encoder.encodeToString(password.getBytes());
    }

    public static String passwordDecoder(String password) {
        return new String(decoder.decode(password));
    }
}
