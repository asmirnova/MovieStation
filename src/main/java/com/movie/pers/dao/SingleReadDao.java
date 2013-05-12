package com.movie.pers.dao;

/**
 *
 * @author Aloren
 */
public interface SingleReadDao<T> {

    T getById(int id);
}
