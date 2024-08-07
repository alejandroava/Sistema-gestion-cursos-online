package org.example.model;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private String lastname;
    private String email;
    private boolean active;
    private List<Course> courses;

    public Student() {}

    public Student(int id, String name, String lastname, String email, boolean active, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.active = active;
        this.courses = courses;
    }
    public Student(int id, String name, String lastname, String email, boolean active) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.active = true;
    }

    public Student(String name, String lastname, String email) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.active = true;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", courses=" + courses +
                '}';
    }
}
