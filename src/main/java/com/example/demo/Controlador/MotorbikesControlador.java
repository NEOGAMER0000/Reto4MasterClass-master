/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Motorbikes;
import com.example.demo.Servicio.MotorbikesServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */

@RestController
@RequestMapping("/api/Motorbikes")
@CrossOrigin(origins = "*")

public class MotorbikesControlador {
     @Autowired
    private MotorbikesServicio motorbikeService;
    @GetMapping("/all")
    public List<Motorbikes> getmotorbikeses(){
        return motorbikeService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Motorbikes> getMotorbike(@PathVariable("id") int motorbikeId) {
        return motorbikeService.getMotorbikes(motorbikeId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbikes save(@RequestBody Motorbikes motorbikes) {
        return motorbikeService.save(motorbikes);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbikes update(@RequestBody Motorbikes motorbikes) {
        return motorbikeService.update(motorbikes);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return motorbikeService.deleteMotorbikes(id);
    }
    
  
}
