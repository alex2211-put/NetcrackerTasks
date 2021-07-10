package ru.skillbench.tasks.basics.human;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Human[] humans = new Human[5];
        humans[0] = new Human("Alexandr", "Petrov",
                new GregorianCalendar(2001, Calendar.FEBRUARY, 12),
                new Address("Russia", "Moscow", "Pervom", "3"));
        humans[1] = new Human("Lena", "Voronova",
                new GregorianCalendar(2000, Calendar.MARCH, 1),
                new Address("Russia", "Moscow", "lenin", "1"));
        humans[2] = new Human("Julia", "Umnova",
                new GregorianCalendar(2002, Calendar.OCTOBER, 17),
                new Address("Russia", "Moscow", "lenin", "9"));
        humans[3] = new Human("Kate", "Smith",
                new GregorianCalendar(2003, Calendar.AUGUST, 20),
                new Address("Russia", "Moscow", "Pervom", "12/3"));
        humans[4] = new Human("Olga", "Retuna",
                new GregorianCalendar(2000, Calendar.JANUARY, 11),
                new Address("Russia", "Moscow", "Tverskaya", "111"));
        System.out.println(findLastName(humans, "Umnova"));
        System.out.println(findYoung(humans));
        System.out.println(findOld(humans));
        System.out.println(Arrays.toString(findAddress(humans, "12/3")));
        System.out.println(Arrays.deepToString(oneStreet(humans)));
    }

    public static Human findLastName(Human[] humans, String lastName) {
        for (Human human : humans) {
            if (human.getLastName().equals(lastName)) {
                return human;
            }
        }
        return null;
    }

    public static Human findYoung(Human[] humans) {
        Calendar min = humans[0].getBirthDate();
        int index = 0;
        for (int i = 1; i < humans.length; i++) {
            if (humans[i].getBirthDate().compareTo(min) < 0) {
                min = humans[i].getBirthDate();
                index = i;
            }
        }
        return humans[index];
    }

    public static Human findOld(Human[] humans) {
        Calendar max = humans[0].getBirthDate();
        int index = 0;
        for (int i = 1; i < humans.length; i++) {
            if (humans[i].getBirthDate().compareTo(max) > 0) {
                max = humans[i].getBirthDate();
                index = i;
            }
        }
        return humans[index];
    }

    public static Human[] findBetween(Human[] humans, Calendar start, Calendar end) {
        int count = 0;
        for (Human element : humans) {
            if (element.getBirthDate().compareTo(start) > 0 & element.getBirthDate().compareTo(end) < 0) {
                count++;
            }
        }
        int i = 0;
        Human[] ans = new Human[count];
        for (Human element : humans) {
            if (element.getBirthDate().compareTo(start) > 0 & element.getBirthDate().compareTo(end) < 0) {
                ans[i] = element;
                i++;
            }
        }
        return ans;
    }

    public static Human[] findAddress(Human[] humans, String address) {
        int count = 0;
        for (Human element : humans) {
            if (element.getAddress().hasAttribute(address)) {
                count++;
            }
        }
        Human[] ans = new Human[count];
        int i = 0;
        for (Human element : humans) {
            if (element.getAddress().hasAttribute(address)) {
                ans[i] = element;
                i++;
            }
        }
        return ans;
    }

    public static Human[][] oneStreet(Human[] humans) {
        int count = 0;
        int diffStreets = 0;
        int[] index = new int[humans.length];
        int[] diffPeople = new int[humans.length];
        for (int i = 0; i < humans.length; i++) {
            for (int j = i + 1; j < humans.length; j++) {
                if (humans[i].getAddress().getStreet().equals(
                        humans[j].getAddress().getStreet()
                ) & index[j] == 0) {
                    count++;
                    index[j] = 1;
                }
            }
            if (count > 0) {
                diffPeople[diffStreets] = count + 1;
                diffStreets++;
                count = 0;
            }
        }
        index = new int[humans.length];
        Human[][] ans = new Human[diffStreets][];
        for (int i = 0; i < diffStreets; i++) {
            ans[i] = new Human[diffPeople[i]];
        }
        diffStreets = 0;
        count = 0;
        for (int i = 0; i < humans.length; i++) {
            for (int j = i + 1; j < humans.length; j++) {
                if (humans[i].getAddress().getStreet().equals(
                        humans[j].getAddress().getStreet()
                ) & index[j] == 0) {
                    if (index[i] == 0) {
                        index[i] = 1;
                        ans[diffStreets][count] = humans[i];
                        count++;
                    }
                    ans[diffStreets][count] = humans[j];
                    index[j] = 1;
                    count++;
                }
            }
            if (count > 0) {
                diffStreets++;
                count = 0;
            }
        }
        return ans;
    }
}
