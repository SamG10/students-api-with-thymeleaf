package com.example.studentapiwiththymeleaf.Students;

import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service()
public class StudentsService {
    private final StudentsRepository studentsRepository;
    private final MongoTemplate mongoTemplate;

    public StudentsService(StudentsRepository studentsRepository, MongoTemplate mongoTemplate) {
        this.studentsRepository = studentsRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Student create(Student student) {
        return studentsRepository.save(student);
    }

    public List<Student> findAll() {
        /* Query query = new Query();
        System.out.println("query" + query);
        query.addCriteria(Criteria.where("firstname").is(firstname));
        System.out.println(query);

        if(firstname != null) {
            return mongoTemplate.find(query, Student.class);
        }*/
        return mongoTemplate.findAll(Student.class);
    }

    public Student findOne(String id) {
        return studentsRepository.findById(id).orElse(null);
    }

    public void delete(String id) {
        studentsRepository.deleteById(id);
    }

    public Student update(String id, Student studentDto) throws Exception {
        Student student = studentsRepository.findById(id).orElse(null);

        if(student != null) {
            BeanUtils.copyProperties(studentDto, student, "id");
            return studentsRepository.save(student);
        }

        // A voir comment throw les erreurs quand le student n'est pas trouvé et gérer les types de la focntion
        return student;
    }
}
