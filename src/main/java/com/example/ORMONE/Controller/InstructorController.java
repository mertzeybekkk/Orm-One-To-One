package com.example.ORMONE.Controller;

import com.example.ORMONE.Entity.Instructor;
import com.example.ORMONE.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class InstructorController {
    @Autowired
    private InstructorService instructorService;

    @PostMapping("/add")
    public void Add( @RequestBody Instructor instructor){
        instructorService.Add(instructor);
    }
    @GetMapping("/GetId/{id}")
    public Optional<Instructor> getById(@PathVariable Long id){
        return instructorService.getById(id);
    }
    @GetMapping("/All")
    public List<Instructor>getAll(){
        return instructorService.getAll();
    }
    @PutMapping("/updatate/{id}")
    public Instructor updateInstructor(@RequestBody Instructor instructor, @PathVariable Long id){
        return instructorService.update(instructor,id);
    }
}
