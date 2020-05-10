package com.my.spring.pojo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the class_student database table.
 * 
 */
@Entity
@Table(name="class_student")
@NamedQuery(name="ClassStudent.findAll", query="SELECT c FROM ClassStudent c")
public class ClassStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;

	//bi-directional many-to-one association to Class
	@ManyToOne
	@JoinColumn(name="class_classid", nullable=false)
	private Class clazz;

	//bi-directional many-to-one association to Student
	@ManyToOne
	@JoinColumn(name="student_registration", nullable=false)
	private Student student;

	public ClassStudent() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Class getClazz() {
		return this.clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}