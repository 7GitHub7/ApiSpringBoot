package com.medium.demo.entities;

import javax.persistence.*;

@Entity
@Table
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Integer id;
    private String shortLogin;
    private String location;
    private String email;

    public Employee() {
    }

    public Employee(String shortLogin, String location, String email) {
        this.shortLogin = shortLogin;
        this.location = location;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortLogin() {
        return shortLogin;
    }

    public void setShortLogin(String shortLogin) {
        this.shortLogin = shortLogin;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", shortLogin='" + shortLogin + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
