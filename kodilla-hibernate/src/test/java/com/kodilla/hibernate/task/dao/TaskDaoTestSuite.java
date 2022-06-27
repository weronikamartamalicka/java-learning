package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskDaoTestSuite {

    @Autowired
    private TaskDao taskDao;
    @Autowired
    TaskListDao taskListDao;
    public static final String DESCRIPTION = "TEST: Learn Hibernate";

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

    @Test
    void testTaskDaoSaveWithFinancialDetails() {

        Task task = new Task(DESCRIPTION, 30);
        task.setTaskFinancialDetails(new TaskFinancialDetails(new BigDecimal(120), false));

        taskDao.save(task);
        int id = task.getId();

        assertNotEquals(0, id);

        taskDao.deleteById(id);
    }

    @Test
    void testTaskListDaoSaveWithTasks() {

        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);

        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);

        TaskList taskList = new TaskList("ToDo tasks", "TODO_LIST");
        taskList.getTaskList().add(task);
        taskList.getTaskList().add(task2);

        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        taskListDao.save(taskList);
        int id = taskList.getId();

        assertNotEquals(0, id);

        taskListDao.deleteById(id);
    }

}
