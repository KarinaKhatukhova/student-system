package ru.system.student.validation;

public class StudentValidation {
    public static String validateSeriaAndNumber(String number, String seria) {
        if (seria == null || !seria.matches("\\d{4}")) {
            return "Enter correct seria!";
        }
        if (number == null || !number.matches("\\d{6}")) {
            return "Enter correct number!";
        }

        return null;
    }
}
