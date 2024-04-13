package bai2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentListToXML {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Alice", 20, 3.8));
        studentList.add(new Student("Bob", 21, 3.6));
        studentList.add(new Student("Charlie", 19, 3.9));
        String xml = generateXML(studentList);
        try {
            FileWriter writer = new FileWriter("student_list.xml");
            writer.write(xml);
            writer.close();
            System.out.println("Danh sách sinh viên đã được lưu vào file student_list.xml");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file XML: " + e.getMessage());
        }
    }
    private static String generateXML(List<Student> studentList) {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        xmlBuilder.append("<students>\n");
        for (Student student : studentList) {
            xmlBuilder.append("  <student>\n");
            xmlBuilder.append("    <name>").append(student.getName()).append("</name>\n");
            xmlBuilder.append("    <age>").append(student.getAge()).append("</age>\n");
            xmlBuilder.append("    <gpa>").append(student.getGpa()).append("</gpa>\n");
            xmlBuilder.append("  </student>\n");
        }
        xmlBuilder.append("</students>");
        return xmlBuilder.toString();
    }
}
class Student {
    private String name;
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }
}
