package com.mica.service.impl;

import com.mica.dao.StudentDao;
import com.mica.domain.Student;
import com.mica.page.PageBean;
import com.mica.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 18/1/25.
 */

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public PageBean<Student> selectAll(int pageNum, int pageSize) {
        int totalRecord = studentDao.getTotalRecord();
        PageBean<Student> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        List<Student> students = studentDao.selectAll("from Student",
                new Object[]{},pageBean.getStartIndex(),pageBean.getPageSize());

        pageBean.setBeanList(students);
        return pageBean;
    }
}
