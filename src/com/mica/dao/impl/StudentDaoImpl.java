package com.mica.dao.impl;

import com.mica.dao.StudentDao;
import com.mica.domain.Student;
import com.mica.page.PagerHibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 18/1/25.
 */

@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {

    @Resource
    private HibernateTemplate hibernateTemplate;
    @Override
    public int getTotalRecord() {
        String sql = "select count(sid) from Student";
        List<Long> list = (List<Long>) hibernateTemplate.find(sql);
        if (list !=null && list.size() >0){
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Student> selectAll(String sql, Object[] param, int pageNum, int pageSize) {
        return hibernateTemplate.execute(new PagerHibernateCallback<Student>(sql,param,pageNum,pageSize));
    }
}
