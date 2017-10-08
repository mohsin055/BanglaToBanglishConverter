

package com.ipv.nlp.bangla.phonetic.utils;

public class NoPhoneticLoaderException extends Exception {
    private static final long serialVersionUID = 4198233633824036014L;
    private String message;

    public NoPhoneticLoaderException() {
        super();
        this.message = "No PhoneticLoader available, set a PhoneticLoader using the setLoader method of a PhoneticParser object.";
    }

    public NoPhoneticLoaderException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}