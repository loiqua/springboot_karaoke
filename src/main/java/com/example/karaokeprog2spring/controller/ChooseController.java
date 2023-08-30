package com.example.karaokeprog2spring.controller;

import com.example.karaokeprog2spring.service.ChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/choose")
public class ChooseController {
    private final ChooseService chooseService;

    @Autowired
    public ChooseController(ChooseService chooseService) {
        this.chooseService = chooseService;
    }

    @PostMapping
    public ResponseEntity<String> addChoose(@RequestParam int userId, @RequestParam int songId) {
        chooseService.insertChoose(userId, songId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Choose added successfully");
    }

    // Implémentez d'autres méthodes pour les opérations CRUD sur les liens
}
