package org.rashm1n.springdemo1.repository;

import org.rashm1n.springdemo1.model.Demo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DemoRepository {
    private Map<Long, Demo> demos = new HashMap<>();
    public Demo getDemo(long id) {
        return demos.get(id);
    }
    public List<Demo> getAllDemos() {
        return new ArrayList<>(demos.values());
    }
    public void addDemo(Demo demo) {
        demos.put(demo.getId(),demo);
    }
    public void updateDemo(Demo demo) {
        demos.put(demo.getId(),demo);
    }
    public void deleteDemo(long id) {
        demos.remove(id);
    }
}
