package com.my.spring.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.my.spring.pojo.ClassStudent;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the "Student" database table.
 * 
 */
@Entity
@Table(name="student")
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer registration;

	@Column(nullable=false)
	private Timestamp begincontract;

	@Column(nullable=false, length=100)
	private String studentname;

	//bi-directional many-to-one association to ClassStudent
	@OneToMany(mappedBy="student")
	private List<ClassStudent> classStudents;

	public Student() {
	}

	public Student(Timestamp beginContract, String name) {
		super();
		this.begincontract = beginContract;
		this.studentname = name;
	}

	public Integer getRegistration() {
		return this.registration;
	}

	public void setRegistration(Integer registration) {
		this.registration = registration;
	}

	public Timestamp getBegincontract() {
		return this.begincontract;
	}

	public void setBegincontract(Timestamp begincontract) {
		this.begincontract = begincontract;
	}

	public String getStudentname() {
		return this.studentname;
	}

	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	public List<ClassStudent> getClassStudents() {
		return this.classStudents;
	}

	public void setClassStudents(List<ClassStudent> classStudents) {
		this.classStudents = classStudents;
	}

	public ClassStudent addClassStudent(ClassStudent classStudent) {
		getClassStudents().add(classStudent);
		classStudent.setStudent(this);

		return classStudent;
	}

	public ClassStudent removeClassStudent(ClassStudent classStudent) {
		getClassStudents().remove(classStudent);
		classStudent.setStudent(null);

		return classStudent;
	}

}