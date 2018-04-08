/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author USER
 */
public class Student {
    private String id;
    private String name;
    private int yob;
    private int phone;
    private int course;

    public Student(String id, String name, int yob, int phone, int course) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.phone = phone;
        this.course = course;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return String.format("Id: %8s | Name: %15s | YOB: %5d | Phone: %12d | Course: %5d |", id,name,yob,phone,course);
    }
    
}
