package com.kodilla.hibernate.taskList;

import com.kodilla.hibernate.task.TaskList;
import com.kodilla.hibernate.task.dao.TaskListDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private final static String LISTNAME = "LIST IN PROGRESS";

    @Test
    void testFindByListName() {

        TaskList taskList = new TaskList(LISTNAME, "List of task that are not completed yet");
        taskListDao.save(taskList);

        List<TaskList> retrievedTaskList = taskListDao.findByListName(LISTNAME);

        assertEquals(1, retrievedTaskList.size());

        int id = taskList.getId();
        taskListDao.deleteById(id);
    }
}
