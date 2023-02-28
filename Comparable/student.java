package Comparable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author kagan
 */
public class student extends Comparable<student> {
    public String name;
    public int id;
    public double gpa;
    public student(int id, double gpa) {
        name = null;
        this.id = id;
        this.gpa = gpa;
    }
    public student(int id, double gpa, String name) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }
    @Override
    public int compareTo(student newStd) {
        if(gpa>newStd.gpa) return 1;
        else if(gpa<newStd.gpa) return -1;
        return 0;
    }
    @Override
    public String toString() {
        return "[ID: "+id+", Name: "+name+", GPA: "+gpa+"]";
    }
}
