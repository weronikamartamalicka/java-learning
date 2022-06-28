package com.kodilla.good.paterns.hibernate.task.dao;

import com.kodilla.good.paterns.hibernate.task.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface TaskDao extends CrudRepository<Task,Integer> {

    List<Task> findByDuration(int duration);
}
