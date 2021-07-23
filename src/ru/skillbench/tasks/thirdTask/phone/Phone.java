package ru.skillbench.tasks.thirdTask.phone;

import java.util.InputMismatchException;

public class Phone {
    private int countryCode;
    private Long phoneNumber;

    /**
     * Конструктор по номеруу телефона получает код страны и номер из 10 цифр
     *
     * @param number строковое представление телефонного номера
     */
    public Phone(String number) {
        number = number.replaceAll("[ \\-()]", "");
        String regex = "[+0-9]+";
        if (!number.matches(regex))
            throw new InputMismatchException();
        if (number.charAt(0) == '+') {
            this.countryCode = Integer.parseInt(number.substring(1, number.length() - 10));
            this.phoneNumber = Long.parseLong(number.substring(number.length() - 10));
        } else {
            this.countryCode = 7;
            this.phoneNumber = Long.parseLong(number.substring(1));
        }
    }

    @Override
    public String toString() {
        return "+" + this.countryCode + this.phoneNumber / 10000000 + "-" + (this.phoneNumber / 10000) % 1000 + "-" +
                (this.phoneNumber % 10000);
    }
}
