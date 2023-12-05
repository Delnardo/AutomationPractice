package org.example;

public class EmployeePojo {

    public String name;
    public String lastname;
    private int age;
    private int id;

    public EmployeePojo() {
    }

    public EmployeePojo(String firstName, String lastName, int age, int id) {
        this.name = firstName;
        this.lastname = lastName;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = age;
    }

}
