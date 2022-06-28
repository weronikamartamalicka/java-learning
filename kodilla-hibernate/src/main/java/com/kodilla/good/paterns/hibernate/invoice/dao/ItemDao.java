package com.kodilla.good.paterns.hibernate.invoice.dao;

import com.kodilla.good.paterns.hibernate.invoice.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ItemDao extends CrudRepository<Item, Integer> {
}
