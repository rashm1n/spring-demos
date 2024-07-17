package org.rashm1n.springdemo1.controller;

import org.rashm1n.springdemo1.model.Demo;
import org.rashm1n.springdemo1.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/demo")
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demo> getDemo(@PathVariable long id) {
        Demo demo = demoService.getDemoById(id);
        if (demo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(demoService.getDemoById(id));
    }

    @PostMapping
    public ResponseEntity<Demo> createDemo(@RequestBody Demo demo) {
        demoService.saveDemo(demo);
        return ResponseEntity.ok(demo);
    }

    @PutMapping
    public ResponseEntity<Demo> updateDemo(@RequestBody Demo demo) {
        demoService.updateDemo(demo);
        return ResponseEntity.ok(demo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDemo(@PathVariable long id) {
        demoService.deleteDemo(id);
        return ResponseEntity.ok().build();
    }
}
