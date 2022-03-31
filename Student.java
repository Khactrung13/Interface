/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapVeInterface;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Student implements Cloneable, Comparable<Student>,Serializable {
    private String fullname;
    private int birthdate;
    private String gender;
    private double gpa;
    private double social_activities;

    public Student() {
    }

    public Student(String fullname, int birthdate, String gender, double gpa, double social_activities) {
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.gender = gender;
        this.gpa = gpa;
        this.social_activities = social_activities;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(int birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getSocial_activities() {
        return social_activities;
    }

    public boolean setSocial_activities(double social_activities) {
        if(social_activities>=0 && social_activities<=5){
              this.social_activities = social_activities;
              return true;
        }
        else{
            System.out.print("Moi nhap lai Social_activities(0-5):");
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Student{" + "fullname=" + fullname + ", birthdate=" + birthdate + ", gender=" + gender + ", gpa=" + gpa + ", social_activities=" + social_activities + '}';
    }
    public String getFileLine(){
        return  fullname + "," + birthdate + "," + gender + "," + gpa + "," + social_activities+"\n" ;
    }
    
    @Override
    public int compareTo(Student o) {
        if(this.getGpa()==o.getGpa() && this.getSocial_activities()==o.getSocial_activities()){
            return 0;
        }
        if(this.getGpa()>o.getGpa() || (this.getGpa()==o.getGpa()&&this.getSocial_activities()>o.getSocial_activities())){
            return 1;
        }
        else{
            return -1;
        }  
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Student temp = (Student)super.clone();
        temp.setFullname(this.fullname);
        temp.setBirthdate(this.birthdate);
        temp.setGender(gender);
        temp.setGpa(gpa);
        temp.setSocial_activities(social_activities);
        
        return temp;
    }
     public void parse(String line){
        String params[] = line.split(",");
        Scanner sc = new Scanner(System.in);
        try {
            fullname=params[0];
            birthdate =Integer.parseInt(params[1]);
            gender= params[2];
            gpa =Double.parseDouble(params[3]);
            social_activities = Double.parseDouble(params[4]);
        } catch (ArrayIndexOutOfBoundsException ex){             
        }finally{            
        }
        
    }
 
    
    
}
