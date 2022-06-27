package com.kodilla.hibernate.task.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TaskFinancialDetailsDaoTestSuite {

    @Autowired
    private TaskFinancialDetailsDao taskFinancialDetailsDao;

    @Test
    void testFindByPaid() {

        TaskFinancialDetails task =
                new TaskFinancialDetails(new BigDecimal(115), false);
        taskFinancialDetailsDao.save(task);
        int id = task.getId();

        List<TaskFinancialDetails> retrievedTask = taskFinancialDetailsDao.findByPaid(false);

        assertEquals(1, retrievedTask.size());

        taskFinancialDetailsDao.deleteById(id);
    }

}
