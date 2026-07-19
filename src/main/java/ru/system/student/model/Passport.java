package ru.system.student.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Passport {
    @NonNull
    private final String name;
    @NonNull
    private final String lastName;
    @NonNull
    private final LocalDate birthDate;
    @NonNull
    private final String birthPlace;
    @NonNull
    private final String seria;
    @NonNull
    private final String number;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(name, passport.name) &&
                Objects.equals(lastName, passport.lastName) &&
                Objects.equals(birthDate, passport.birthDate) &&
                Objects.equals(birthPlace, passport.birthPlace) &&
                Objects.equals(seria, passport.seria) &&
                Objects.equals(number, passport.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, birthDate, birthPlace, seria, number);
    }
}
