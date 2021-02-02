package com.teachers.crud.statics;

import com.teachers.crud.model.Teachers;
import com.teachers.crud.repository.TeacherRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class Statics {

    private TeacherRepository teacherRepository;

    public Statics(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public float tauxAbscence() {
        int sum = 0;
        List<Teachers> teachers =  teacherRepository.findAll();
        for (Teachers All : teachers) { sum += All.getAbscence(); }
        return (sum/teachers.size());
    }

    public float SalairMoyen() {
        int sum = 0;
        List<Teachers> teachers =  teacherRepository.findAll();
        for (Teachers All : teachers) { sum += All.getSalair(); }
        return (sum/teachers.size());
    }

}
