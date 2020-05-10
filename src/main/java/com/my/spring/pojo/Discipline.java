package com.my.spring.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.*;
import javax.persistence.Table;

import com.my.spring.pojo.Class;
import com.my.spring.pojo.Matter;
import com.my.spring.pojo.Teacher;


/**
 * The persistent class for the "Discipline" database table.
 * 
 */
@Entity
@Table(name="discipline")
@NamedQuery(name="Discipline.findAll", query="SELECT d FROM Discipline d")
public class Discipline implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer disciplineid;

	@Column(nullable=false, length=100)
	private String disciplinename;

	//bi-directional many-to-one association to Class
	@OneToMany(mappedBy="discipline")
	private List<Class> clazzs;

	//bi-directional many-to-one association to Teacher
	@ManyToOne
	@JoinColumn(name="teacher_teacherid", nullable=false)
	private Teacher teacher;

	//bi-directional many-to-one association to Matter
	@OneToMany(mappedBy="discipline")
	private List<Matter> matters;

	public Discipline() {
	}

	public Integer getDisciplineid() {
		return this.disciplineid;
	}

	public void setDisciplineid(Integer disciplineid) {
		this.disciplineid = disciplineid;
	}

	public String getDisciplinename() {
		return this.disciplinename;
	}

	public void setDisciplinename(String disciplinename) {
		this.disciplinename = disciplinename;
	}

	public List<Class> getClazzs() {
		return this.clazzs;
	}

	public void setClazzs(List<Class> clazzs) {
		this.clazzs = clazzs;
	}

	public Class addClazz(Class clazz) {
		getClazzs().add(clazz);
		clazz.setDiscipline(this);

		return clazz;
	}

	public Class removeClazz(Class clazz) {
		getClazzs().remove(clazz);
		clazz.setDiscipline(null);

		return clazz;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Matter> getMatters() {
		return this.matters;
	}

	public void setMatters(List<Matter> matters) {
		this.matters = matters;
	}

	public Matter addMatter(Matter matter) {
		getMatters().add(matter);
		matter.setDiscipline(this);

		return matter;
	}

	public Matter removeMatter(Matter matter) {
		getMatters().remove(matter);
		matter.setDiscipline(null);

		return matter;
	}

}