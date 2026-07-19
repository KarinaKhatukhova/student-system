package ru.system.student.database;

import ru.system.student.model.Faculty;
import ru.system.student.model.Passport;
import ru.system.student.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    public final static  Map<Passport, Student> STUDENTS = new HashMap<>();

    public final static List<Faculty> FACULTIES =
            List.of(new Faculty("Math", "+74733334546", "math@mail.ru"),
                    new Faculty("Physical", "+74733331111", "phys@mail.ru"),
                    new Faculty("Economic", "+74733330000", "econom@mail.ru"));
}
