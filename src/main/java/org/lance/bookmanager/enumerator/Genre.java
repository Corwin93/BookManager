package org.lance.bookmanager.enumerator;

/**
 * Created by Corwin on 24.11.2015.
 */
public enum Genre {
    FANTASY("�������"), SCIFI("������� ����������"), FICTION("�������������� ����������"),
        PERSONAL_GROWTH("������������"), CHILDREN("������� ����������"), HISTORY("�������"),
        BIOGRAPHY("���������"), FITNESS("�������� � ������"), ART("��������� � ��������"), COMIC("�������");
    private String value;

    Genre(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
