package ru.system.student.validation;

public class StudentValidation {
    public static String validateSeriaAndNumber(String number, String seria) {
        if (seria.length() != 4) {
            return ("Enter correct seria!");
        }
        if (number.length() != 6) {
            return ("Enter correct number!");
        }
        return null;
    }
}
