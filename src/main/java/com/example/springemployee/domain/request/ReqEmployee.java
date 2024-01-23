package com.example.springemployee.domain.request;

public class ReqEmployee {
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private String workSchedule;
    private String yearOfBirth;
    private String graduatedUniversity;

    public ReqEmployee(Long id, String firstName, String lastName, String position, String workSchedule, String yearOfBirth, String graduatedUniversity) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.workSchedule = workSchedule;
        this.yearOfBirth = yearOfBirth;
        this.graduatedUniversity = graduatedUniversity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGraduatedUniversity() {
        return graduatedUniversity;
    }

    public void setGraduatedUniversity(String graduatedUniversity) {
        this.graduatedUniversity = graduatedUniversity;
    }
}
