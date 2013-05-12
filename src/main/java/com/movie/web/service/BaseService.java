package com.movie.web.service;

import java.util.List;

/**
 *
 * @author Aloren
 */
public interface BaseService<T> {
    
    void add(T t);
    
    void delete(T t);
    
    T findById(int key);
    
    List<T> findAll();
    
}
