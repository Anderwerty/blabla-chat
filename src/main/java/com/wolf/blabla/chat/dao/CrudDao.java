package com.wolf.blabla.chat.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CrudDao<E, ID> {
    //creat
    E save(E entity);

    //read
    Optional<E> findById(ID id);

    List<E> findAll();

    //update

    void update(E entity);

    //delete
    void deleteById(ID id);

    void deleteAllByIds(Set<ID> ids);
}
