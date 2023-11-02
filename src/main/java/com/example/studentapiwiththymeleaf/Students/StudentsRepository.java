package com.example.studentapiwiththymeleaf.Students;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentsRepository extends MongoRepository<Student, String> {
}
