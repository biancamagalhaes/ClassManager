package com.my.spring.dao;

import java.sql.Timestamp;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.my.spring.exception.UserException;
import com.my.spring.pojo.Student;
import com.my.spring.pojo.Teacher;
import com.my.spring.pojo.Teacher;

public class TeacherDAO extends DAO {

	public TeacherDAO() {
	}

	public Teacher getById(Integer teacherId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("select * from Teacher t where t.TeacherID = :teacherId");
			q.setInteger("teacherId", teacherId);
			Teacher teacher = (Teacher) q.uniqueResult();
			commit();
			return teacher;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get Teacher " + teacherId, e);
		}
	}
	
	public Teacher getDisciplinasMinistradas(Integer teacherId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("select * from Discipline d where d.TeacherID = :teacherId");
			q.setLong("teacherId", teacherId);		
			Teacher teacher = (Teacher) q.uniqueResult();
			commit();
			return teacher;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get discipline from teacher " + teacherId, e);
		}
	}

	public Teacher register(String name) throws UserException {
		try {
			begin();
			Teacher teacher = new Teacher(new Timestamp(System.currentTimeMillis()),name);
			getSession().save(teacher);
			commit();
			return teacher;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating teacher: " + e.getMessage());
		}
	}

	public void delete(Teacher teacher) throws UserException {
		try {
			begin();
			getSession().delete(teacher);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + teacher.getTeachername(), e);
		}
	}
}