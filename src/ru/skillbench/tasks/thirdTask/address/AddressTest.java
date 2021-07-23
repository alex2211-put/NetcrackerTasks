package ru.skillbench.tasks.thirdTask.address;

import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    private List<Address> expected;

    @BeforeEach
    void setUp() {
        Address address1 = new Address("Russia", "Tomskaya obl", "Seversk", "Leningradskaya", "6", "a", "34");
        Address address2 = new Address("Russia", "Moscow obl", "Dolgoprudnuy", "Pervomayskaya", "30", "3", "321");
        expected = new ArrayList<>(Arrays.asList(address1, address2));
    }

    @org.junit.jupiter.api.Test
    void getFromStringOnlyComma() {
        Address check1 = new Address().getFromStringOnlyComma("Russia, Tomskaya obl, Seversk, Leningradskaya, 6, a, 34");
        Address check2 = new Address().getFromStringOnlyComma("Russia, Moscow obl, Dolgoprudnuy, Pervomayskaya, 30, 3, 321");
        List<Address> actual = new ArrayList<>(Arrays.asList(check1, check2));
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void getFromStringAll() {
        Address check1 = new Address().getFromStringAll("Russia, Tomskaya obl; Seversk. Leningradskaya. 6; a, 34");
        Address check2 = new Address().getFromStringAll("Russia, Moscow obl; Dolgoprudnuy; Pervomayskaya. 30. 3. 321");
        List<Address> actual = new ArrayList<>(Arrays.asList(check1, check2));
        assertEquals(expected, actual);
    }
}