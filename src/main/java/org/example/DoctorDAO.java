package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DoctorDAO {

    public static Connection conn;

    public static void showDoctors() {


        String query = "select * from doctor;";

        try {
            conn = CreateConnection.getConnection();

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query); //will have results

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String speciality = resultSet.getString("speciality");
                Integer phone = resultSet.getInt("phone");
                System.out.println("Name: " + name + "\n" +
                        "Speciality : " + speciality + "\n" +
                        "phone number: " + phone + "\n");
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void createDoctorEntry() {

        String query = "insert into doctor values(?,?,?);";

        try {
            conn = CreateConnection.getConnection();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter doctor name: ");
            String name = scanner.nextLine();
            System.out.println("Enter doctor speciality: ");
            String speciality = scanner.nextLine();
            System.out.println("Enter doctor phone number: ");
            Integer phone = Integer.parseInt(scanner.nextLine());

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,speciality);
            preparedStatement.setInt(3,phone);

            preparedStatement.executeUpdate();
            System.out.println("New entry for doctor has been successfully sent.");
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateDoctorPhone() {
        try {
            conn = CreateConnection.getConnection();

            System.out.println("Enter the name of doctor you want to update");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.println("Enter the new phone number");
            Integer phone = scanner.nextInt();

            String query = "update doctor set phone = ? where name = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1,phone);
            preparedStatement.setString(2,name);

            preparedStatement.executeUpdate();
            System.out.println("New phone number succesfully updated");
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void deleteDoctor() {
        try {
            conn = CreateConnection.getConnection();

            System.out.println("Enter the name of doctor you want to delete");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();

            String query = "delete from doctor where name = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,name);

            preparedStatement.executeUpdate();
            System.out.println("New phone number succesfully deleted");
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
