package org.lance.bookmanager.enumerator;

/**
 * Created by Corwin on 30.11.2015.
 */
public enum Language {
    RUSSIAN("Русский"), ENGLISH("Английский");
    private String value;

    Language(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
