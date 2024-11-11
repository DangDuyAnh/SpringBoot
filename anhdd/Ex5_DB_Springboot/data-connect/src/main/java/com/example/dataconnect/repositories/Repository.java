package com.example.dataconnect.repositories;

import java.util.List;

public interface Repository<T>{
    public T insert(T model);
    public T update(T model);
    public T findById(int id);
    public List<T> findAll();
    int deleteById(int id);
}
