package com.example.ORMONE.Service;

import com.example.ORMONE.Entity.Instructor;
import com.example.ORMONE.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    private InstructorRepository instructorRepository;
    @Override
    public void Add(Instructor instructor) {
        //Field Check Add
        if(Objects.nonNull(instructor.getFirstName())||Objects.nonNull(instructor.getLastName())
        ||Objects.nonNull(instructor.getInstructorDetail())){
            throw new RuntimeException("Alanlar Boş Olamaz");
        }
        instructorRepository.save(instructor);
    }

    @Override
    public Optional<Instructor> getById(Long id) {
        return instructorRepository.findById(id);
    }

    @Override
    public List<Instructor> getAll() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor update(Instructor instructor, Long id) {
        Instructor getUser=instructorRepository.findById(id).get();
          if(getUser==null){
              throw  new RuntimeException("null");
          }else {
              getUser.setEmail(instructor.getEmail());
              //getUser.setFirstName(instructor.getFirstName());
              //getUser.getInstructorDetail().setYoutubeChannel(instructor.getInstructorDetail().getYoutubeChannel());
              //getUser.getInstructorDetail().setHobby(instructor.getInstructorDetail().getHobby());
              instructorRepository.save(getUser);
          }
        return getUser;
    }
}
