package com.example.dataconnect.reposities;

import java.util.List;

public interface Reposity<T>{
    public int insert(T model);
    public int update(T model);
    public T findById(int id);
    public List<T> findAll();
    int deleteById(int id);
}
