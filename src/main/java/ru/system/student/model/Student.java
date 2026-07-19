package ru.system.student.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Student {
    @NonNull
    private String phoneNumber;
    @NonNull
    private String eMail;
    @NonNull
    private String address;
    @NonNull
    private Faculty faculty;
}
