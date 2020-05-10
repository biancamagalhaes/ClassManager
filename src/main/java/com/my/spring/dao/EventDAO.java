package com.my.spring.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.my.spring.exception.CartException;
import com.my.spring.exception.CategoryException;
import com.my.spring.exception.UserException;
import com.my.spring.pojo.Event;

public class EventDAO extends DAO {
	
	public EventDAO(){
	
	}

	public Event insert(Event event) throws CartException {
		try{
			begin();            
			getSession().save(event);     
            commit();
            return event;
		} catch (HibernateException e){
			rollback();
            throw new CartException("Could not save the event", e);
		}
	}
	
	public void update(Event event) throws CategoryException {
        try {
            begin();
            getSession().update(event);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new CategoryException("Could not save the event", e);
        }
    }
	
	
	@SuppressWarnings("unchecked")
	public List<Event> list(){
		begin();
		Query q = getSession().createQuery("select * from Event");
		List<Event> event = q.list();
		commit();
		return event;
	}
	
	
	public Event get(Timestamp begin) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("select * from Event e where e.begin = :begin");
			q.setTimestamp("begin", begin);
			Event event = (Event) q.uniqueResult();
			commit();
			return event;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get Event " + begin, e);
		}
	}

	

}
