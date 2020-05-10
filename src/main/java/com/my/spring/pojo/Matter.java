package com.my.spring.pojo;

import java.io.Serializable;
import javax.persistence.*;

import com.my.spring.pojo.Discipline;


/**
 * The persistent class for the "Matter" database table.
 * 
 */
@Entity
@Table(name="matter")
@NamedQuery(name="Matter.findAll", query="SELECT m FROM Matter m")
public class Matter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer matterid;

	@Column(nullable=false, length=100)
	private String subtitle;

	@Column(nullable=false, length=40)
	private String title;

	//bi-directional many-to-one association to Discipline
	@ManyToOne
	@JoinColumn(name="discipline_disciplineid", nullable=false)
	private Discipline discipline;

	public Matter() {
	}

	public Matter(String subtitle, String title) {
		super();
		this.subtitle = subtitle;
		this.title = title;
	}

	public Integer getMatterid() {
		return this.matterid;
	}

	public void setMatterid(Integer matterid) {
		this.matterid = matterid;
	}

	public String getSubtitle() {
		return this.subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Discipline getDiscipline() {
		return this.discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

}