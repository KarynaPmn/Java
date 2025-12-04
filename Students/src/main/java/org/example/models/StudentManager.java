package org.example.models;

import org.example.Logger;
import org.example.Validator;

import java.util.*;
import java.util.stream.Collectors;

public class StudentManager {
    private List<Student> StudentsList;
    private Scanner scanner = new Scanner(System.in);

    public StudentManager() {
        StudentsList = new ArrayList<>();
        StudentsList.add(new Student(1111111111, "Caleb", "Summers", 5.0));
        StudentsList.add(new Student(2, "Malt", "Bont", 3.5));
    }

    public void addStudent() {
        int id;
        String name;
        String surname;
        double average;

        while (true) {
            System.out.print("Input id: \n>>> ");

            try {
                id = Integer.parseInt(scanner.next());
                int finalId = id;

                boolean exists = StudentsList.stream()
                        .anyMatch(s -> s.getId() == finalId);

                if (!Validator.isValidId(String.valueOf(id))) {
                    Logger.getInstance().DisplayLogError("Incorrect id.");
                }
                else if (exists) {
                    Logger.getInstance().DisplayLogError("Student with this id already exist.");
                }
                else {
                    break;
                }

            } catch (NumberFormatException e) {
                Logger.getInstance().DisplayLogError("Id must be a number.");
            }
        }

        while (true) {
            System.out.print("Input name: \n>>> ");
            name = scanner.next();

            if (!Validator.isValidName(name))
                Logger.getInstance().DisplayLogError("Incorrect name.");
            else break;
        }

        while (true) {
            System.out.print("Input surname: \n>>> ");
            surname = scanner.next();

            if (!Validator.isValidName(surname))
                Logger.getInstance().DisplayLogError("Incorrect surname.");
            else break;
        }

        while (true) {
            System.out.print("Input average: \n>>> ");

            try {
                average = Double.parseDouble(scanner.next());

                if (!Validator.isValidAverage(String.valueOf(average)))
                    Logger.getInstance().DisplayLogError("Incorrect average.");
                else break;

            } catch (NumberFormatException e) {
                Logger.getInstance().DisplayLogError("Average must be a number.");
            }
        }

        StudentsList.add(new Student(id, name, surname, average));
        Logger.getInstance().DisplayLog("Add new student.");
    }

    public void removeStudent() {
        int id;

        while (true) {
            System.out.print("Input id: \n>>> ");

            try {
                id = Integer.parseInt(scanner.next());
                int finalId = id;
                boolean ifStudentExist = StudentsList.stream().anyMatch(s -> s.getId() == finalId);

                if (!Validator.isValidId(String.valueOf(id)))
                    Logger.getInstance().DisplayLogError("Incorrect id.");
                else if (ifStudentExist) {
                    Student toRemove = StudentsList.stream()
                            .filter(s -> s.getId() == finalId)
                            .findFirst()
                            .orElse(null);

                    if (toRemove != null) {
                        StudentsList.remove(toRemove);
                        Logger.getInstance().DisplayLog("Student id:" + id + " removed.");
                    }
                    break;
                }
                else
                    Logger.getInstance().DisplayLogError("This student doesn't exist.");

            } catch (NumberFormatException e) {
                Logger.getInstance().DisplayLogError("Id must be a number.");
            }
        }
    }

    private void showStudents(List<Student> studentsListSort) {
        if (studentsListSort.isEmpty()) {
            System.out.println("List is empty. Add students.");
            return;
        }

//        % — znacznik pola
//        - — wyrównanie do lewej
//        10 — szerokość kolumny
//        s — typ String
        String line = "+------------+----------------------+----------------------+------------+";
        String format = "| %-10s | %-20s | %-20s | %-10s |%n";

        System.out.println(line);
        System.out.printf(format, "ID", "NAME", "SURNAME", "AVERAGE");
        System.out.println(line);

        for (Student student : studentsListSort) {
            System.out.printf(format,
                    student.getId(),
                    student.getName(),
                    student.getSurname(),
                    String.format("%.1f", student.getAverage())
            );
        }

        System.out.println(line);
    }

    public void showAllStudents() {
        showStudents(StudentsList);
    }

    public void sortByAverage() {
        List<Student> studentsListSortByAVGDesc = StudentsList.stream()
                .sorted(Comparator.comparingDouble(Student::getAverage).reversed())
                .collect(Collectors.toList());

        showStudents(studentsListSortByAVGDesc);
    }

    public void averageOfAllStudents() {
        if (StudentsList == null || StudentsList.isEmpty())
            System.out.println(0);
        else {
//            double sum = 0.0;
//            for (Student student : StudentsList)
//                sum += student.getAverage();
//
//            double avg = sum / StudentsList.size();
//
//            System.out.println(Math.round(avg * 100.0) / 100.0);

            double avg = StudentsList.stream()
                    .mapToDouble(Student::getAverage)
                    .average()
                    .orElse(0);

            System.out.printf("%.2f%n", avg);
        }
    }

    public void findStudent() {
        while (true) {
            String surname;
            System.out.print("Input surname: \n>>> ");
            surname = scanner.next();

            if (!Validator.isValidName(surname)){
                Logger.getInstance().DisplayLogError("Incorrect surname.");
                continue;
            }

            try {
                List<Student> students = StudentsList.stream()
                        .filter(s -> s.getSurname().equalsIgnoreCase(surname))
                        .toList();

                if (students.isEmpty()) {
                    Logger.getInstance().DisplayLogError("This student doesn't exist.");
                    return;
                }

                for (Student student : students) {
                    System.out.println("FIND STUDENT: " +
                            student.getId() + " | " +
                            student.getName() + " | " +
                            student.getSurname() + " | " +
                            student.getAverage());
                }

            } catch (Exception ex) {
                Logger.getInstance().DisplayLogError(ex.getMessage());
            }
            break;
        }
    }
}
