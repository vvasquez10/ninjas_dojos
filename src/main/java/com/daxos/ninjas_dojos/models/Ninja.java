package com.daxos.ninjas_dojos.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="ninjas")
public class Ninja {
	
	@Id	
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long ninja_id;
	
	@NotNull
	@NotEmpty
	private String first_name;	

	@NotNull
	@NotEmpty
	private String last_name;	
	
	@NotNull	
	private int age;
	
	@Column(updatable=false)
	@DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date createdAt;
	
    private Date updatedAt;
	
    @NotNull (message = "Escoga un dojo")
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")	
	private Dojo dojo;
	
	public Ninja() {
	}

	public Ninja(long ninja_id, String first_name, String last_name, int age, Date createdAt, Date updatedAt) {
		this.ninja_id = ninja_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public long getId() {
		return ninja_id;
	}

	public void setId(long id) {
		this.ninja_id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	

	
	
}
