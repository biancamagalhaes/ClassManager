package com.my.spring.pojo;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the "Event" database table.
 * 
 */
@Entity
@Table(name="event")
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer eventid;

	@Column(nullable=false)
	private Timestamp begintime;

	@Column(nullable=false)
	private Timestamp endtime;

	@Column(nullable=false, length=200)
	private String eventdescription;

	@Column(nullable=false, length=100)
	private String eventname;

	@Column(nullable=false, length=15)
	private String type;

	public Event() {
	}

	public Event(Timestamp timestampStart, Timestamp timestampEnd, String description, String name,
			String type) {
		super();
		this.begintime = timestampStart;
		this.endtime = timestampEnd;
		this.eventdescription = description;
		this.eventname = name;
	}

	public Integer getEventid() {
		return this.eventid;
	}

	public void setEventid(Integer eventid) {
		this.eventid = eventid;
	}

	public Timestamp getBegintime() {
		return this.begintime;
	}

	public void setBegintime(Timestamp begintime) {
		this.begintime = begintime;
	}

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getEventdescription() {
		return this.eventdescription;
	}

	public void setEventdescription(String eventdescription) {
		this.eventdescription = eventdescription;
	}

	public String getEventname() {
		return this.eventname;
	}

	public void setEventname(String eventname) {
		this.eventname = eventname;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}