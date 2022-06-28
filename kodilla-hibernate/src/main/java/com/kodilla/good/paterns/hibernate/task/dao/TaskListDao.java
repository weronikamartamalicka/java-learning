package com.kodilla.good.paterns.hibernate.task.dao;

import com.kodilla.good.paterns.hibernate.task.TaskList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TaskListDao extends CrudRepository<TaskList, Integer> {

    List<TaskList> findByListName(String name);
}
