package org.acme.entity;

import lombok.Getter;
import lombok.Setter;

public class Phone {

    @Getter
    @Setter
    private String number;

    // Getters and setters....

    public static Phone fromString(String number) {
        Phone phone = new Phone();
        phone.setNumber(number);
        return phone;
    }
}
