package ru.system.student.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Faculty {
    @NonNull
    private String name;
    @NonNull
    private String phoneNumber;
    @NonNull
    private String eMail;

}
