package com.my.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.my.spring.exception.UserException;
import com.my.spring.pojo.Class;

public class ClassDAO extends DAO {

	public ClassDAO() {
	}

	public Class getById(Integer classId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("select * from Class c where c.ClassID = :classId");
			q.setInteger("classId", classId);
			Class classroom = (Class) q.uniqueResult();
			commit();
			return classroom;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get Student " + classId, e);
		}
	}
	
	public Class get(Integer disciplineId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("select * from Class c where c.disciplineID = :disciplineId");
			q.setLong("disciplineId", disciplineId);		
			Class classroom = (Class) q.uniqueResult();
			commit();
			return classroom;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get Class with discipline id = " + disciplineId, e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Class> list(){
		begin();
		Query q = getSession().createQuery("select * from Class");
		List<Class> classroom = q.list();
		commit();
		return classroom;
	}
	


	public Class register(Class classroom) throws UserException {
		try {
			begin();
			getSession().save(classroom);
			commit();
			return classroom;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(Class classroom) throws UserException {
		try {
			begin();
			getSession().delete(classroom);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete class " + classroom.getClassid(), e);
		}
	}
}