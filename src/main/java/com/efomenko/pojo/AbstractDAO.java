package com.efomenko.pojo;
import com.efomenko.pojo.Equip;

import java.util.List;

public abstract class AbstractDAO <K extends Number, T>{
    public abstract List<T> findAll();
    public abstract  T findEntityById(K id);
    public abstract boolean update(T entity);
    public abstract boolean delete(int entity);
    public abstract T insert(T entity);


}
