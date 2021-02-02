package com.teachers.crud.repository;

import com.teachers.crud.model.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teachers, Integer> {
}
