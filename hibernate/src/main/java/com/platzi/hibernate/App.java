package com.platzi.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.platzi.hibernate.dao.TeacherDaoImpl;
import com.platzi.hibernate.model.Course;
import com.platzi.hibernate.model.Teacher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        /*
        SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        Teacher teacher = new Teacher("max Zeballos","Avatar");
        session.beginTransaction();
        session.save(teacher);
        session.getTransaction().commit();
        
        Course course = new Course("Java avanzado","Tema1","Rest API");
        session.beginTransaction();
        session.save(course);
        session.getTransaction().commit();
        */
        
        Teacher teacher = new Teacher("max Zeballos","Avatar");
        TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
        teacherDaoImpl.saveTeacher(teacher);
        
        List<Teacher> teachers = teacherDaoImpl.findAllTeachers();
        
        for(Teacher t: teachers) {
        	System.out.println("Name:" + t.getName());
        }
        
        teacher = teacherDaoImpl.findById((long) 3);
        teacher.setName("Jose Manuel Castellanos");
        teacherDaoImpl.updateTeacher(teacher);
    }
}
