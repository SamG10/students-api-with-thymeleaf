package com.example.studentapiwiththymeleaf.Students;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data()
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private int age;
}
