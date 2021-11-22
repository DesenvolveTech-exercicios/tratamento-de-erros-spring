package com.DesenvolveTech.ExercicioExceptions.controlles;

import com.DesenvolveTech.ExercicioExceptions.exceptions.DogsNotFoundException;
import com.DesenvolveTech.ExercicioExceptions.exceptions.DogsServiceException;
import com.DesenvolveTech.ExercicioExceptions.models.Dog;
import com.DesenvolveTech.ExercicioExceptions.models.DogDto;
import com.DesenvolveTech.ExercicioExceptions.services.DogsService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dogs")
@RequiredArgsConstructor
@Setter
public class DogsController {
    @Autowired
    private final DogsService service;

    @GetMapping
    public ResponseEntity<List<Dog>> getDogs() {
        return new ResponseEntity<>(service.getDogs(), HttpStatus.OK);
    }

    @PostMapping
    public void postDogs(@RequestBody DogDto dto) {
        service.add(dto);
    }

    @GetMapping("/{id}")
    public Dog getById(@PathVariable(required = true) long id) throws DogsNotFoundException {
        try {
            return service.getDogById(id);
        } catch (Exception e) {
            throw new DogsNotFoundException("No Dog Found Here..");
        }

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
}