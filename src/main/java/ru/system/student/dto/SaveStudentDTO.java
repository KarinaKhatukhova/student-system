package ru.system.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class SaveStudentDTO {
    @NonNull
    private String name;
    @NonNull
    private String lastName;
    @NonNull
    private String seria;
    @NonNull
    private String number;
    @NonNull
    private LocalDate birthDate;
    @NonNull
    private String birthPlace;
    @NonNull
    private String facultyName;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String eMail;
    @NonNull
    private String address;
}
