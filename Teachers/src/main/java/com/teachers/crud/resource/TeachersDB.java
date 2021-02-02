package com.teachers.crud.resource;


import com.teachers.crud.model.Teachers;
import com.teachers.crud.repository.TeacherRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("teacher/db")
public class TeachersDB {

    private TeacherRepository teacherRepository;

    public TeachersDB(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/Teachers")
    public List<Teachers> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teachers> getteacherById(@PathVariable(value = "id")
                                                           Integer id) throws ResourceNotFoundException {
        Teachers teacher = teacherRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No teacher found!" + id));
        return ResponseEntity.ok().body(teacher);
    }


    @GetMapping("/{matiere}")
    public List<Teachers> GetTeachersByLevel(@PathVariable("matiere") String matiere) {
        List<Teachers> All;
        List<Teachers> Some = new ArrayList<>();
        All = getAllTeachers();
        for (Teachers Teachers : All) {
            if (Teachers.getMatiere() == matiere)
                Some.add(Teachers);
        }
        return(Some);
    }

    @PostMapping("/Teachers")
    public Teachers createTeacher(@Valid @RequestBody Teachers teacher) {
        return teacherRepository.save(teacher);
    }

    @PutMapping("/Teachers/{id}")
    public ResponseEntity<Teachers> updateTeacher(@PathVariable(value = "id") Integer id ,
                                                  @Valid @RequestBody Teachers teacherInfo) throws ResourceNotFoundException {
        Teachers teacher = teacherRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No teacher for this id" + id));

        teacher.setPrenom(teacherInfo.getPrenom());
        teacher.setNom(teacherInfo.getNom());
        teacher.setMatiere(teacherInfo.getMatiere());
        teacher.setSalair(teacherInfo.getSalair());

        final Teachers updatedTeacher = teacherRepository.save(teacher);
        return ResponseEntity.ok(updatedTeacher);
    }

    @DeleteMapping("/Teachers/{id}")
    public Map<String, Boolean> deleteTeacher(@PathVariable Integer id) throws ResourceNotFoundException {
        Teachers teacher = teacherRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No teacher found for " + id));
        teacherRepository.delete(teacher);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
