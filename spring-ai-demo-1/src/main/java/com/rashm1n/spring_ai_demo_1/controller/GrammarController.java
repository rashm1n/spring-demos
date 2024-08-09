package com.rashm1n.spring_ai_demo_1.controller;

import com.rashm1n.spring_ai_demo_1.model.*;
import com.rashm1n.spring_ai_demo_1.service.OpenAIService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai/grammar")
@AllArgsConstructor
public class GrammarController {
    private final OpenAIService openAIService;

    @PostMapping
    public ResponseEntity<GrammarResponse> grammarCorrector(@RequestBody GrammarRequest message) {
        try {
            if (message == null) {
                return ResponseEntity.badRequest().build();
            }
            GrammarResponse correctedText = openAIService.correctGrammar(message);
            return ResponseEntity.ok(correctedText);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}