package org.lance.bookmanager.enumerator;

/**
 * Created by Corwin on 24.11.2015.
 */
public enum Genre {
    FANTASY("Фэнтези"), SCIFI("Научная фантастика"), FICTION("Художественная литература"),
        PERSONAL_GROWTH("Саморазвитие"), CHILDREN("Детская литература"), HISTORY("История"),
        BIOGRAPHY("Биография"), FITNESS("Здоровье и фитнес"), ART("Искусство и культура"), COMIC("Комиксы");
    private String value;

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
