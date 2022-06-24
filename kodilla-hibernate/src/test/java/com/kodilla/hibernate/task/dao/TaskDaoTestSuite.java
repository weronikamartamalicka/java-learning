package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskDaoTestSuite {

    @Autowired
    private TaskDao taskDao;
    private static final String DESCRIPTION = "TEST: Learn Hibernate";

    @Test
    void testDaoSave() {

        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        int id = task.getId();

        Optional<Task> readTask = taskDao.findById(id);

        assertTrue(readTask.isPresent());

        taskDao.deleteById(id);
    }

    @Test
    void testFindByDuration() {

        Task task = new Task(DESCRIPTION, 7);
        taskDao.save(task);
        int duration = task.getDuration();

        List<Task> readTasks = taskDao.findByDuration(duration);

        assertEquals(1, readTasks.size());

        int id = readTasks.get(0).getId();
        taskDao.deleteById(id);
    }

}
