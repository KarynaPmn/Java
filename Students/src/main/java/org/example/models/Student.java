package org.example.models;

public class Student {
    private int Id;
    private String Name;
    private String Surname;
    private double Average;

    public Student(int id, String name, String surname, double average) {
        this.Id = id;
        this.Name = name;
        this.Surname = surname;
        this.Average = average;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public double getAverage() {
        return Average;
    }

    public void setAverage(double average) {
        Average = average;
    }
}
