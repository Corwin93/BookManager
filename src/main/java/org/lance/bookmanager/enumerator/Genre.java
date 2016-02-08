package org.lance.bookmanager.enumerator;

/**
 * Created by Corwin on 24.11.2015.
 */
public enum Genre {
    FANTASY("Фэнтези"), SCIFI("Научная фантастика"), CLASSIC("Классика");
    private String value;

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
