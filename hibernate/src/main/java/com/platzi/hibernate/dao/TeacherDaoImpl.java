package com.platzi.hibernate.dao;

import java.util.List;

import com.platzi.hibernate.model.Teacher;

public class TeacherDaoImpl extends PlatziSession implements TeacherDao{

	private PlatziSession platziSession;
	
	public TeacherDaoImpl() {
		platziSession = new PlatziSession();
	}
	
	public void saveTeacher(Teacher teacher) {
		platziSession.getSession().persist(teacher);
		platziSession.getSession().getTransaction().commit();
	}

	public void deleteTeacherById(Long idTeacher) {
		
	}

	public void updateTeacher(Teacher teacher) {
		platziSession.getSession().update(teacher);
		platziSession.getSession().getTransaction().commit();
	}

	public List<Teacher> findAllTeachers() {
		return platziSession.getSession().createQuery("from Teacher").list();
	}

	public Teacher findById(Long idTeacher) {
		return platziSession.getSession().load(Teacher.class, idTeacher);
	}

	public Teacher findByName(String name) {

		return null;
	}

}
