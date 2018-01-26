package com.mica.service;

import com.mica.domain.Student;
import com.mica.page.PageBean;

/**
 * Created by dllo on 18/1/25.
 */
public interface StudentService {

    PageBean<Student> selectAll(int pageNum,int pageSize);
}
