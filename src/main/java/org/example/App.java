package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello to Hospital Doctor's directory!");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Press 1 to see all doctors details: ");
            System.out.println("Press 2 to create a new entry of doctor: ");
            System.out.println("Press 3 to update entry of doctor: ");
            System.out.println("Press 4 to delete entry of doctor: ");
            System.out.println("Press 5 to exit: ");

            String input = scanner.nextLine();
            if (input.equals("1")) {
                DoctorDAO.showDoctors();
            }
            if (input.equals("2")) {
                DoctorDAO.createDoctorEntry();
            }
            if (input.equals("3")) {
                DoctorDAO.updateDoctorPhone();
            }if (input.equals("4")) {
                DoctorDAO.deleteDoctor();
            }
            if(input.equals("5")){
                break;
            }
        }
        System.out.println("Thanks for using the doctor directory. Have a nice day!");
        scanner.close();

    }
}
