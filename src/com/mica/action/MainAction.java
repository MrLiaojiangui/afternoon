package com.mica.action;

import com.mica.domain.Student;
import com.mica.page.PageBean;
import com.mica.service.StudentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by dllo on 18/1/25.
 */
@Controller("mainAction")
@Scope("prototype")
public class MainAction extends ActionSupport{

    @Resource
    private StudentService studentService;
    private int pageNum = 1;
    private int pageSize = 3;
    private PageBean<Student> pageBean;


    public String selectAll(){

        pageBean = studentService.selectAll(pageNum,pageSize);
        Map<String,Object> session = ActionContext.getContext().getSession();
        session.put("pageBean",pageBean);
        return SUCCESS;
    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PageBean<Student> getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean<Student> pageBean) {
        this.pageBean = pageBean;
    }
}
