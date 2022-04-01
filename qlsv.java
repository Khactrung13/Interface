/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTapVeInterface;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class qlsv {
    static Scanner sc = new Scanner(System.in);
    static List<Student> std = new ArrayList<>();
    
    public static void main(String[] args) {
        qlsv ql = new qlsv();
        Student[] students = null;
        int choose;
        int n =0;
        students = new Student[n];
        do {            
            ql.showMenu();
            choose = Integer.parseInt(sc.nextLine());
            switch(choose){
                case 1:
                    System.out.println("Nhap so luong sinh vien:");
                    n = Integer.parseInt(sc.nextLine());
                    students = new Student[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhap thong tin sinh vien thu " +i);
                        students[i] = new Student();
                        ql.nhapThongTin(students[i]);
                    }

                    break;
                case 2:
                    Arrays.sort(students);
                    break;
                case 3:
                    for (int i = 0; i < students.length; i++) {
                        System.out.println(students[i].toString());
                    }
                    
                    break;
                case 4:
                    Student[] temp = students.clone();
                    temp[0].setFullname("nguyen khac trung");
                    temp[0].setBirthdate(25);
                    temp[0].setGender("nam");
                    temp[0].setGpa(45);
                    temp[0].setSocial_activities(4);                   
                    System.out.println(Arrays.deepToString(temp)+"\n");                    
                    break;
                case 5:
                    System.out.println("Bat dau luu");
                    FileOutputStream fos = null;
                    try {          
                        fos = new FileOutputStream("student.txt");
                        for (Student student : students) {
                            String line = student.getFileLine();
                
                            byte[] b = line.getBytes("utf8");
                
                            fos.write(b);
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(qlsv.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(qlsv.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(qlsv.class.getName()).log(Level.SEVERE, null, ex);
                    }finally{
                        if( fos != null){
                    try {
                        fos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(qlsv.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
                    break;
                case 6:
                    FileInputStream fis = null;
                    InputStreamReader reader = null;
                    BufferedReader bf = null;

                    try {
                        fis = new  FileInputStream("student.txt");

                        reader = new InputStreamReader(fis, StandardCharsets.UTF_8);

                        bf = new  BufferedReader(reader);

                        String line = null;
                        while((line=bf.readLine()) !=null){
                            if(line.isEmpty()){
                                continue;
                            }
                            Student student = new Student();
                            student.parse(line);
                            std.add(student);
                    }

                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(qlsv.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(qlsv.class.getName()).log(Level.SEVERE, null, ex);
                    }finally{
                        if(fis !=null){
                            try {
                                fis.close();
                            } catch (IOException ex) {
                                Logger.getLogger(qlsv.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if(reader!=null){
                            try {
                                reader.close();
                            } catch (IOException ex) {
                                Logger.getLogger(qlsv.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        if(bf!=null){
                            try {
                                bf.close();
                            } catch (IOException ex) {
                                Logger.getLogger(qlsv.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }      
                    System.out.println(std.toString());

                    break;
                case 7:
                    System.out.println("Bye!!!");
                    return;
                default:
                    System.out.println("Nhap sai!!");
                    break;
            }
        } while (choose!=7);
        
    }
    public void showMenu(){
        System.out.println("1.Nhap thong tin sinh vien");
        System.out.println("2.Sap xep sinh vien");
        System.out.println("3.Hien thi danh sach sinh vien");
        System.out.println("4.Sao chep danh sach sinh vien");
        System.out.println("5.Ghi File");
        System.out.println("6.Doc File");
        System.out.println("7.Thoat khoi chuong trinh");
        System.out.print("NHap lua chon:");
    }
    public void nhapThongTin(Student st){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap fullname:");
        st.setFullname(sc.nextLine());
        System.out.println("Nhap birthdate:");
        st.setBirthdate(Integer.parseInt(sc.nextLine()));
        System.out.println("Nhap gender:");
        st.setGender(sc.nextLine());
        System.out.println("Nhap gpa:");
        st.setGpa(Double.parseDouble(sc.nextLine()));
        System.out.println("Nhap social_activities:");
        while(true){
            double inputSocial_activities = Double.parseDouble(sc.nextLine());
            boolean check = st.setSocial_activities(inputSocial_activities);
            if(check){
                break;
            }
        }
        
    }
    
}
