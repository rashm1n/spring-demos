package org.rashm1n.springdemo1.service;

import org.rashm1n.springdemo1.model.Demo;
import org.rashm1n.springdemo1.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    private final DemoRepository demoRepository;

    @Autowired
    public DemoService(DemoRepository demoRepository) {
        this.demoRepository = demoRepository;
    }

    public List<Demo> getAllDemos() {
        return demoRepository.getAllDemos();
    }

    public Demo getDemoById(Long id) {
        return demoRepository.getDemo(id);
    }

    public Demo saveDemo(Demo demo) {
        demoRepository.addDemo(demo);
        return demo;
    }

    public Demo updateDemo(Demo demo) {
        demoRepository.updateDemo(demo);
        return demo;
    }

    public void deleteDemo(Long id) {
        demoRepository.deleteDemo(id);
    }

}
