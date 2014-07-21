package org.aicer.jbehave.automation.models;

public class Person {

    protected static final int ADULT_AGE = 18;

    protected static final int DRINKING_AGE = 21;

    protected static final int TEEN_AGE = 13;

    protected static final int INFANT_MAX_AGE = 2;

    protected int age = 0;

    protected String name = "John Doe";

    public Person() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAllowedToSmoke() {
        return this.age >= ADULT_AGE;
    }

    public boolean isAllowedAllowedToDrinkAlcohol() {
        return this.age >= DRINKING_AGE;
    }

    public boolean isAdult() {
        return this.age >= ADULT_AGE;
    }

    public boolean isChild() {
        return this.age < ADULT_AGE;
    }

    public boolean isInfant() {
        return this.age <= INFANT_MAX_AGE;
    }
}
