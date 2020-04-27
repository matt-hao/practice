package com.shiro.source.study;

import com.shiro.source.study.domain.*;
import com.shiro.source.study.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Mario on 2016/7/6.
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:shiro-context.xml"})
public class AppTest extends AbstractTestNGSpringContextTests {

    @Autowired
    IStudentService studentService;

    @Autowired
    ITeacherService teacherService;

    @Autowired
    IAdminService adminService;

    @Autowired
    IUserRoleService userRoleService;

    @Autowired
    IRoleService roleService;

    @Test
    public void addStudent() {
        //学生构造数据
        Student student = new Student();
        student.setName("mario");
        student.setAccount("student@gmail.com");
        student.setPassword("1234");

        assert studentService.add(student) != null;

        //将学生和相关角色权限信息进行关联
        Role role = roleService.findByName("student");
        Objects.requireNonNull(role);

        assert userRoleService.add(new UserRole(student, role.getId())) != null;
    }

    @Test
    public void addTeacher() {
        addStudent();

        //构造老师数据
        Teacher teacher = new Teacher();
        teacher.setName("Professor M");
        teacher.setAccount("teacher@gmail.com");
        teacher.setPassword("1234");

        //获取学生
        teacher.setStudents(new ArrayList<Student>() {{
            add(studentService.findByAccount("student@gmail.com"));
        }});

        //存入老师,并将学生和老师关联到一起
        assert teacherService.add(teacher) != null;

        //将老师和相关角色信息进行关联
        Role role = roleService.findByName("teacher");
        Objects.requireNonNull(role);

        assert userRoleService.add(new UserRole(teacher.getEntityKey(), role.getId())) != null;
    }

    @Test
    public void addAdmin() {
        addTeacher();

        //构造admin数据
        Admin admin = new Admin();
        admin.setName("Admin");
        admin.setAccount("admin@gmail.com");
        admin.setPassword("1234");

        assert adminService.add(admin) != null;

        //将admin和相关角色信息进行关联
        Role role = roleService.findByName("admin");
        Objects.requireNonNull(role);

        assert userRoleService.add(new UserRole(admin.getEntityKey(), role.getId())) != null;
    }

    @Test
    public void findWithPermission() {
        Teacher teacher = teacherService.findWithPermission(1L);
        System.out.println(teacher.getName());
        System.out.println(teacher.getRoles().get(0).getPermissions().size());
    }

}
