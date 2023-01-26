package com.example.ORMONE.Service;

import com.example.ORMONE.Entity.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
     void Add(Instructor instructor);
    Optional< Instructor> getById(Long id);
     List<Instructor> getAll();
     Instructor update(Instructor instructor,Long id);
}
