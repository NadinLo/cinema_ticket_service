package com.company.modul;

import java.util.List;

public interface IRepository<T> {
        List<T> findAll();
        T findOne(int id);
        public boolean create(T entity);
}
