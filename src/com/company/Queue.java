package com.company;

public interface Queue<T>{
    int size();
    void add(T t);
    T peek();// возвращает
    T poll();// возвращает и удаляет
}
