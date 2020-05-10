package com.my.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.my.spring.exception.AdvertException;
import com.my.spring.exception.UserException;
import com.my.spring.pojo.Matter;

public class MatterDAO extends DAO {

    public Matter create(Matter matter)
            throws AdvertException {
        try {
            begin();            
            getSession().save(matter);     
            commit();
            return matter;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create matter", e);
            throw new AdvertException("Exception while creating matter: " + e.getMessage());
        }
    }

    public void delete(Matter matter)
            throws AdvertException {
        try {
            begin();
            getSession().delete(matter);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdvertException("Could not delete matter", e);
        }
    }
    
    public Matter get(Integer disciplineId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("select * from Matter m where m.disciplineID = :disciplineId");
			q.setInteger("disciplineId", disciplineId);
			Matter matter = (Matter) q.uniqueResult();
			commit();
			return matter;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get Matter with disciplineID " +  disciplineId, e);
		}
	}
}