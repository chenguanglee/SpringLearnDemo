package com.chenguangli.stream;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * @author chenguangli
 * @date 2019/4/24 23:27
 */
public class TextFileTest {

    private static final String FILE_PATH = ".\\src\\main\\java\\com\\chenguangli\\stream\\employee.dat";
    private static final String FILE_PATH_0 = ".\\src\\main\\java\\com\\chenguangli\\stream\\employeeBinary.dat";


    public static void main(String[] args) {
        Employee[] staff = buildEmployeeArray();
        File file = new File(FILE_PATH);
        try (PrintWriter out = new PrintWriter(file, "UTF-8")) {
            writeData(staff, out);
        } catch (IOException e) {

        }

        //Scanner in0 = new Scanner(new FileInputStream(file));
        try (Scanner in = new Scanner(file, "utf-8")) {
            Employee[] newStaff = readData(in);
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        } catch (IOException e) {

        }

    }

    private static Employee[] buildEmployeeArray() {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("lee", 123123.1, 1995, 10, 9);
        staff[1] = new Employee("sun", 12312313.2, 1990, 2, 3);
        staff[2] = new Employee("shine", 111222.3, 1991, 3, 5);
        return staff;
    }

    private static void writeData(Employee[] employees, PrintWriter out) throws IOException {
        out.println(employees.length);
        for (Employee e : employees) {
            writeEmployee(out, e);
        }
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    public static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getMoney() + "|" + e.getYear() + "|" + e.getMonth() + "|" + e.getDay());
    }

    public static Employee readEmployee(Scanner in) {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        String name = tokens[0];
        double money = Double.parseDouble(tokens[1]);
        int year = Integer.parseInt(tokens[2]);
        int month = Integer.parseInt(tokens[3]);
        int day = Integer.parseInt(tokens[4]);
        return new Employee(name, money, year, month, day);
    }


    public static void writeData(DataOutput out, Employee e) throws IOException {
        writeFixedString(e.getName(), out);
        out.writeInt(e.getDay());
    }

    public static void writeFixedString(String s, DataOutput out) throws IOException {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            out.writeChar(ch);
        }
    }

    @Test
    public void testDataOutput() throws IOException {
        Employee[] employees = buildEmployeeArray();

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE_PATH_0))) {
            for (Employee employee : employees) {
                writeData(out, employee);
            }
        }
        try(DataInputStream in = new DataInputStream(new FileInputStream(FILE_PATH_0))){
            
        }
    }
}
