package com.my.spring.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.my.spring.exception.UserException;
import com.my.spring.pojo.ClassStudent;
import com.my.spring.pojo.Student;


public class StudentDAO extends DAO {

	public StudentDAO() {
	}

	
	public Student get(Integer classId, HttpServletRequest request) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("select * from Student s inner join Class_Student cls where cls.ClassID = :classId");
			q.setInteger("classId", classId);
			Student student = (Student) q.uniqueResult();
			commit();
			return student;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get Student " + classId, e);
		}
	}
	
	public Student get(Long registration) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("select * from Student s where s.Registration = :registration");
			q.setLong("registration", registration);		
			Student user = (Student) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + registration, e);
		}
	}

	public Student register(String name) throws UserException {
		try {
			begin();

			Student student = new Student(new Timestamp(System.currentTimeMillis()),name);

			getSession().save(student);
			commit();
			return student;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(Student user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getStudentname(), e);
		}
	}
}