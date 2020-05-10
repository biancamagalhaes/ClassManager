package com.my.spring.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.my.spring.pojo.ClassStudent;
import com.my.spring.pojo.Discipline;
import com.my.spring.pojo.Teacher;


/**
 * The persistent class for the "Class" database table.
 * 
 */
@Entity
@Table(name="class")
@NamedQuery(name="Class.findAll", query="SELECT c FROM Class c")
public class Class implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer classid;

	@Column(nullable=false, length=50)
	private String place;

	//bi-directional many-to-one association to Discipline
	@ManyToOne
	@JoinColumn(name="discipline_disciplineid", nullable=false)
	private Discipline discipline;

	//bi-directional many-to-one association to Teacher
	@ManyToOne
	@JoinColumn(name="teacher_teacherid", nullable=false)
	private Teacher teacher;

	//bi-directional many-to-one association to ClassStudent
	@OneToMany(mappedBy="clazz")
	private List<ClassStudent> classStudents;

	public Class() {
	}

	public Class(String place) {
		super ();
		this.place = place;
		//this.discipline = discipline;
		//this.teacher = teacher;
		// TODO Auto-generated constructor stub
	}

	public Integer getClassid() {
		return this.classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Discipline getDiscipline() {
		return this.discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<ClassStudent> getClassStudents() {
		return this.classStudents;
	}

	public void setClassStudents(List<ClassStudent> classStudents) {
		this.classStudents = classStudents;
	}

	public ClassStudent addClassStudent(ClassStudent classStudent) {
		getClassStudents().add(classStudent);
		classStudent.setClazz(this);

		return classStudent;
	}

	public ClassStudent removeClassStudent(ClassStudent classStudent) {
		getClassStudents().remove(classStudent);
		classStudent.setClazz(null);

		return classStudent;
	}

}