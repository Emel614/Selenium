package com.techproed;

import com.github.javafaker.Faker;
import org.junit.Test;

public class Day05_JavaFaker {
    @Test
    public void fakerTest(){
        //Create Faker object
        Faker faker = new Faker();

        //Generate fake data: firstname,lastname,address,city,state,title...
        String fname = faker.name().firstName();
        String lname = faker.name().lastName();
        String fullname = faker.name().fullName();
        System.out.println("First name = "+fname);
        System.out.println("Last name = "+lname);
        System.out.println("Full name = "+fullname);

        //Generate title
        System.out.println(faker.name().title());

        //Generate city
        System.out.println(faker.address().city());

        //Generate random 5 digit number
        System.out.println(faker.number().digits(5));

        //phone number
        System.out.println(faker.phoneNumber().cellPhone());

        //e mail
        System.out.println(faker.internet().emailAddress());
    }
}
