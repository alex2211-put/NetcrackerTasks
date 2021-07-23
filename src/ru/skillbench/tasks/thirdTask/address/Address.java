package ru.skillbench.tasks.thirdTask.address;

import java.util.Objects;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private String house;
    private String building;
    private String flat;

    /**
     * Принимает все строковые параметры и записывает их в свои поля
     *
     * @param country  страна
     * @param region   регион
     * @param city     город
     * @param street   улица
     * @param house    дом
     * @param building корпус
     * @param flat     квартира
     */
    public Address(String country, String region, String city, String street, String house, String building, String flat) {
        this.country = country.strip();
        this.region = region.strip();
        this.city = city.strip();
        this.street = street.strip();
        this.house = house.strip();
        this.building = building.strip();
        this.flat = flat.strip();
    }

    /**
     * Принимает массив строк с строковыми параметрами, которые записывает в свои поля
     *
     * @param address массив параметров
     */
    public Address(String[] address) {
        this(address[0], address[1], address[2], address[3], address[4], address[5], address[6]);
    }

    /**
     * Возвращает новый объект, в полях которого записаны значения, разделенные запятой в data
     *
     * @param data строка параметров, разделенных запятыми
     * @return объект Address с переданными параметрами
     */
    public Address getFromStringOnlyComma(String data) {
        return new Address(data.split(","));
    }

    /**
     * Аналогичен предыдущему, но теперь разделителями служат: ,.;
     *
     * @param data строка параметров, разделенных запятыми, точками или точками с запятой
     * @return объект Address с переданными параметрами
     */
    public Address getFromStringAll(String data) {
        return new Address(data.split("[,.;]"));
    }

    /**
     * Конструктор по умолчанию. Инициализирует все поля пустыми строками.
     */
    public Address() {
        this.country = "";
        this.region = "";
        this.city = "";
        this.street = "";
        this.house = "";
        this.building = "";
        this.flat = "";
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", building='" + building + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return country.equals(address.country) && region.equals(address.region) && city.equals(address.city) && street.equals(address.street) && house.equals(address.house) && building.equals(address.building) && flat.equals(address.flat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, region, city, street, house, building, flat);
    }
}
