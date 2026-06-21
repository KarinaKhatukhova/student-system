package ru.system.student.view;

import ru.system.student.controller.StudentController;
import ru.system.student.dto.DeleteStudentDTO;
import ru.system.student.dto.GetStudentDTO;
import ru.system.student.dto.SaveStudentDTO;

import java.time.LocalDate;
import java.util.Scanner;

import static ru.system.student.utill.DateUtils.formatStringToDate;

public class StudentView {
    public final static StudentController studentController = new StudentController();

    public static void runInterface() {
        System.out.println("-----------------------------");
        System.out.println("1. Find student");
        System.out.println("2. Delete student");
        System.out.println("3. Add student");
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (NumberFormatException ex) {
            System.out.println( "Enter correct data!");
        runInterface();
        }
        if (choice == 1) {
            String value = getStudent();
            System.out.println(value);
            runInterface();
        } else if (choice == 2) {
            boolean isDeleted = deleteStudent();
            if(isDeleted) {
                System.out.println("Student successfully deleted!");
                runInterface();
            } else {
                System.out.println("Error deleting student!");
                System.out.println("Check the data!");
                runInterface();
            }
        } else if (choice == 3) {
            boolean isSaved = saveStudent();
            if(isSaved) {
                System.out.println("Student successfully saved!");
                runInterface();
            } else {
                System.out.println("Error saving student!");
                System.out.println("Check the data!");
                runInterface();
            }
        } else {
            System.out.println("Enter correct data!");
            runInterface();
        }
    }

    private static boolean saveStudent() {
        System.out.println("Enter passport series: ");
        Scanner scanner = new Scanner(System.in);
        String seria = scanner.nextLine();
        System.out.println("Enter passport number: ");
        scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        System.out.println("Enter address: ");
        scanner = new Scanner(System.in);
        String address = scanner.nextLine();
        System.out.println("Enter name: ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter lastname: ");
        scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();
        System.out.println("Enter birth date in yyyy-MM-dd format: ");
        scanner = new Scanner(System.in);
        String birthDate = scanner.nextLine();
        LocalDate birthDateFormated = formatStringToDate(birthDate);
        System.out.println("Enter birth place: ");
        scanner = new Scanner(System.in);
        String birthPlace = scanner.nextLine();
        System.out.println("Enter faculty: ");
        scanner = new Scanner(System.in);
        String faculty = scanner.nextLine();
        System.out.println("Enter phone number: ");
        scanner = new Scanner(System.in);
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter e-mail: ");
        scanner = new Scanner(System.in);
        String eMail = scanner.nextLine();

        SaveStudentDTO saveStudentDTO =
                new SaveStudentDTO(name, lastName, seria, number,
                        birthDateFormated, birthPlace, faculty, phoneNumber, eMail, address);
        return studentController.saveStudent(saveStudentDTO);
    }

    private static boolean deleteStudent() {
        System.out.println("Enter passport series: ");
        Scanner scanner = new Scanner(System.in);
        String seria = scanner.nextLine();
        System.out.println("Enter passport number: ");
        scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        DeleteStudentDTO deleteStudentDTO = new DeleteStudentDTO(seria, number);
        return studentController.deleteStudent(deleteStudentDTO);

    }

    private static String getStudent() {
        System.out.println("Enter passport series: ");
        Scanner scanner = new Scanner(System.in);
        String seria = scanner.nextLine();
        System.out.println("Enter passport number: ");
        scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        GetStudentDTO getStudentDTO = new GetStudentDTO(seria, number);
        return studentController.getStudent(getStudentDTO);

    }
}
