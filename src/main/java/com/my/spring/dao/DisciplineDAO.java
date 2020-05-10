package com.my.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.my.spring.exception.CategoryException;
import com.my.spring.pojo.Discipline;

public class DisciplineDAO extends DAO {

	public Discipline getById(Integer disciplineID) throws CategoryException {
		try {
			begin();
			Query q = getSession().createQuery("select * from Discipline where title= :disciplineId");
			q.setInteger("disciplineId", disciplineID);
			Discipline category = (Discipline) q.uniqueResult();
			commit();
			return category;
		} catch (HibernateException e) {
			rollback();
			throw new CategoryException("Could not obtain the named category " + disciplineID + " " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Discipline> list() throws CategoryException {
		try {
			begin();
			Query q = getSession().createQuery("select * from Discipline");
			List<Discipline> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new CategoryException("Could not list the categories", e);
		}
	}

	public Discipline create(String name) throws CategoryException {
		try {
			begin();
			//faltando inserir nas tabelas de relacionamento
			Discipline discipline = new Discipline();
			discipline.setDisciplinename(name);;
			getSession().save(discipline);
			commit();
			return discipline;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create the category", e);
			throw new CategoryException("Exception while creating category: " + e.getMessage());
		}
	}

	public void update(Discipline discipline) throws CategoryException {
		try {
			begin();
			getSession().update(discipline);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new CategoryException("Could not save the category", e);
		}
	}

	public void delete(Discipline discipline) throws CategoryException {
		try {
			begin();
			getSession().delete(discipline);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new CategoryException("Could not delete the category", e);
		}
	}
}