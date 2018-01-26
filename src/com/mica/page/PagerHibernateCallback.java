package com.mica.page;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class PagerHibernateCallback<T>
        implements HibernateCallback<List<T>> {

    private String hql;// 查询语句
    private Object[] params;// 查询条件集合
    private int startIndex;// 开始查询位置
    private int pageSize;// 每页条数

    // 无参构造方法
    public PagerHibernateCallback() {
    }

    // 有参构造方法
    public PagerHibernateCallback(String hql,
                                  Object[] params,
                                  int startIndex,
                                  int pageSize) {
        this.hql = hql;
        this.params = params;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    // 复写doInHibernate方法
    @Override
    public List<T> doInHibernate(Session session) throws HibernateException {
        Query query = session.createQuery(hql);

        for (int i = 0; params != null && i < params.length; i++) {
            query.setParameter(i, params[i]);
        }

        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);

        return query.list();
    }
}
