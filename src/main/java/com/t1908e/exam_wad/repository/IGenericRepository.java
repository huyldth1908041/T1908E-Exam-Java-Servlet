package com.t1908e.exam_wad.repository;

import java.util.List;

public interface IGenericRepository<T> {
    List<T> toList();
    T find(Object id);
    boolean save(T obj);
    boolean update(T obj);
    boolean delete(Object id);
    /**
     * Custom query use WHERE clause.<br>
     * Created by LuuHuy
     * @param expr1 the column name to query
     * @param operator operator to compare use SQLConstant class to get predefined operator
     * @param expr2 the value to compare
     * @return the list object T after execute query
     */
    List<T> where(Object expr1, String operator, Object expr2);
}
