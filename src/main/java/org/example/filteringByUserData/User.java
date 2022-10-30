package org.example.filteringByUserData;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class User implements Comparable<User> {
    private String name;
    private int age;
    private String email;
    private String gender;


    public User() {
        Faker faker = new Faker();
        this.name = faker.name().firstName();
        this.age = faker.random().nextInt(10, 30);
        this.email = faker.internet().emailAddress();
        this.gender = String.valueOf(Gender.getRandomGender());
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static void main(String[] args) {

        Map<Object, List<User>> users = Stream.generate(User::new)
                .limit(20)
                .filter(user -> user.age > 18)
                .sorted()
                .filter(user -> !(user.email == null))
                .collect(Collectors.groupingBy(User::getGender));
        users.forEach((Object key, List<User> user) -> System.out.println(key + " = " + user));

    }

    @Override
    public int compareTo(User o) {
        return 0;
    }
}
