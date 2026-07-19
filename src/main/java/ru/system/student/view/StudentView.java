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

    public final static String passportSeriesRegex = "\\d{4}";
    public final static String passportNumberRegex = "\\d{6}";
    public final static String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    public final static String phoneNumberRegex = "^(?:\\+7|8)?9\\d{9}$";
    public final static String enteredTextRegex = "[A-Za-zА-Яа-яЁё\\s-]{2,30}";
    public final static String birthDateRegex = "\\d{4}-\\d{2}-\\d{2}";

    public final static String passportSeriesMsgError = "Error! The series must consist of exactly 4 digits.";
    public final static String passportNumberMsgError = "Error! The number must be exactly 6 digits long.";
    public final static String emailMsgError = "Error! Invalid email format (example: student@faculty.com).";
    public final static String phoneNumberMsgError = "Error! Please enter a valid Russian mobile phone number (e.g. +79123456789).";
    public final static String enteredTextMsgError = "Error! The name must contain only letters and be between 2 and 30 characters long.";
    public final static String birthDateMsgError = "Error! Invalid date format. Use YYYY-MM-DD.";

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
            System.out.println("Enter correct data!");
            runInterface();
        }

        switch (choice) {
            case 0:
                return;

            case 1:
                String value = getStudent();
                System.out.println(value);
                runInterface();
                break;

            case 2:
                if (deleteStudent()) {
                    System.out.println("Student successfully deleted!");
                } else {
                    System.out.println("Error deleting student!");
                    System.out.println("Check the data!");
                }
                runInterface();
                break;

            case 3:
                if (saveStudent()) {
                    System.out.println("Student successfully saved!");
                } else {
                    System.out.println("Error saving student!");
                    System.out.println("Check the data!");
                }
                runInterface();
                break;

            default:
                System.out.println("Enter correct data!");
                runInterface();
                break;
        }
    }

    private static boolean saveStudent() {
        System.out.println("Enter passport series: ");
        String seria = dataScanner(passportSeriesRegex, passportSeriesMsgError);
        System.out.println("Enter passport number: ");
        String number = dataScanner(passportNumberRegex, passportNumberMsgError);
        System.out.println("Enter address: ");
        String address = dataScanner(enteredTextRegex , enteredTextMsgError);
        System.out.println("Enter name: ");
        String name = dataScanner(enteredTextRegex, enteredTextMsgError);
        System.out.println("Enter lastname: ");
        String lastName = dataScanner(enteredTextRegex, enteredTextMsgError);
        System.out.println("Enter birth date in yyyy-MM-dd format: ");
        String birthDate = dataScanner(birthDateRegex , birthDateMsgError);
        LocalDate birthDateFormated = formatStringToDate(birthDate);
        System.out.println("Enter birth place: ");
        String birthPlace = dataScanner(enteredTextRegex, enteredTextMsgError);
        System.out.println("Enter faculty: ");
        String faculty = dataScanner(enteredTextRegex, enteredTextMsgError);
        System.out.println("Enter phone number: ");
        String phoneNumber = dataScanner(phoneNumberRegex, phoneNumberMsgError);
        System.out.println("Enter e-mail: ");
        String eMail = dataScanner(emailRegex, emailMsgError);

        SaveStudentDTO saveStudentDTO =
                new SaveStudentDTO(name, lastName, seria, number,
                        birthDateFormated, birthPlace, faculty, phoneNumber, eMail, address);
        return studentController.saveStudent(saveStudentDTO);
    }

    private static boolean deleteStudent() {
        System.out.println("Enter passport series: ");
        String seria = dataScanner(passportSeriesRegex , passportSeriesMsgError);
        System.out.println("Enter passport number: ");
        String number = dataScanner(passportNumberRegex, passportNumberMsgError);
        DeleteStudentDTO deleteStudentDTO = new DeleteStudentDTO(seria, number);
        return studentController.deleteStudent(deleteStudentDTO);
    }

    private static String getStudent() {
        System.out.println("Enter passport series: ");
        String seria = dataScanner(passportSeriesRegex, passportSeriesMsgError);
        System.out.println("Enter passport number: ");
        String number = dataScanner(passportNumberRegex, passportNumberMsgError);
        GetStudentDTO getStudentDTO = new GetStudentDTO(seria, number);
        return studentController.getStudent(getStudentDTO);
    }

    private static String dataScanner(String regex, String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim();

            if (input.matches(regex)) {
                return input;
            }

            System.out.println(errorMessage);
            System.out.print("Попробуйте еще раз: ");
        }
    }
}
