package com.mica.dao;

import com.mica.domain.Student;

import java.util.List;

/**
 * Created by dllo on 18/1/25.
 */
public interface StudentDao {

    int getTotalRecord();
    List<Student> selectAll(String sql, Object[] param, int pageNum, int PageSize);

}
