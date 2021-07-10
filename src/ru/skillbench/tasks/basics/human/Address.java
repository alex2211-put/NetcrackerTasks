package ru.skillbench.tasks.basics.human;

public class Address {
    private final String country;
    private final String city;
    private final String street;
    private final String house;

    public Address(String country, String city, String street, String house) {
        this.city = city;
        this.country = country;
        this.street = street;
        this.house = house;
    }

    public String getAddress() {
        return country + city + street + house;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    /**
     *
     * @param attribute атрибут адреса (страна, город, улица или дом)
     * @return true если есть такой атрибут в адресе, false иначе
     */
    public boolean hasAttribute(String attribute) {
        return (city.equals(attribute) || country.equals(attribute) || street.equals(attribute) || house.equals(attribute));
    }

    @Override
    public String toString() {
        return this.country + " " + this.city + " " + this.street + " " + this.house;
    }
}
