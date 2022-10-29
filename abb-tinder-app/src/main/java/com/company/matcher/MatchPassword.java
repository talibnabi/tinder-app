package com.company.matcher;

import static com.company.constants.matcher.MatcherLayerConstants.decoder;
import static com.company.constants.matcher.MatcherLayerConstants.encoder;

public class MatchPassword {

    public static String passwordEncoder(String password) {
        return encoder.encodeToString(password.getBytes());
    }

    public static String passwordDecoder(String password) {
        return new String(decoder.decode(password));
    }
}
