package com.abhinav.simplerest.entities;

import lombok.Value;

@Value
public class Person {
    private String name;
    private int age;
    private String designation;
}
