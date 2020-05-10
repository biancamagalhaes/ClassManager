package com.my.spring.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.my.spring.pojo.Class;
import com.my.spring.pojo.Discipline;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the "Teacher" database table.
 * 
 */
@Entity
@Table(name="teacher")
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer teacherid;

	@Column(nullable=false)
	private Timestamp begincontract;

	@Column(nullable=false, length=40)
	private String teachername;

	//bi-directional many-to-one association to Class
	@OneToMany(mappedBy="teacher")
	private List<Class> clazzs;

	//bi-directional many-to-one association to Discipline
	@OneToMany(mappedBy="teacher")
	private List<Discipline> disciplines;

	public Teacher() {
	}

	public Teacher(Timestamp timestamp, String name) {
		super();
		this.begincontract = timestamp;
		this.teachername = name;
	}

	public Integer getTeacherid() {
		return this.teacherid;
	}

	public void setTeacherid(Integer teacherid) {
		this.teacherid = teacherid;
	}

	public Timestamp getBegincontract() {
		return this.begincontract;
	}

	public void setBegincontract(Timestamp begincontract) {
		this.begincontract = begincontract;
	}

	public String getTeachername() {
		return this.teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public List<Class> getClazzs() {
		return this.clazzs;
	}

	public void setClazzs(List<Class> clazzs) {
		this.clazzs = clazzs;
	}

	public Class addClazz(Class clazz) {
		getClazzs().add(clazz);
		clazz.setTeacher(this);

		return clazz;
	}

	public Class removeClazz(Class clazz) {
		getClazzs().remove(clazz);
		clazz.setTeacher(null);

		return clazz;
	}

	public List<Discipline> getDisciplines() {
		return this.disciplines;
	}

	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	public Discipline addDiscipline(Discipline discipline) {
		getDisciplines().add(discipline);
		discipline.setTeacher(this);

		return discipline;
	}

	public Discipline removeDiscipline(Discipline discipline) {
		getDisciplines().remove(discipline);
		discipline.setTeacher(null);

		return discipline;
	}

}