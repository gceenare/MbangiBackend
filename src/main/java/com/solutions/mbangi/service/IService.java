package com.solutions.mbangi.service;


import org.springframework.stereotype.Service;

@Service
public interface IService <T, ID> {

    T create(T obj);
    T read(ID id);
    T update(T obj);
    boolean delete(ID id);
}
