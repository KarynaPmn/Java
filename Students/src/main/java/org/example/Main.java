package org.example;

import org.example.models.StudentManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Add new student.");
            System.out.println("2. Remove student.");
            System.out.println("3. Show all students.");
            System.out.println("4. Sort all students by average (descent).");
            System.out.println("5. Show average of all students.");
            System.out.println("6. Search student.");
            System.out.println("7. Close.\n");

            System.out.print("--- Select one option: \n>>> ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentManager.addStudent();
                    break;
                case 2:

                    studentManager.removeStudent();
                    break;
                case 3:
                    studentManager.showAllStudents();
                    break;
                case 4:
                    studentManager.sortByAverage();
                    break;
                case 5:
                    studentManager.averageOfAllStudents();
                    break;
                case 6:
                    studentManager.findStudent();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Unknown option.");
            }

            // Read key
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.print("\n\n\n\n\n");
        }
    }
}