package com.movie.pers.dao;

import java.util.List;

/**
 *
 * @author Aloren
 */
public interface BaseDao<T> {

    boolean save(T t);

    void delete(T t);

    List<T> getAll();
}
