package ru.system.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeleteStudentDTO {
    @NonNull
    private String seria;
    @NonNull
    private String number;
}
