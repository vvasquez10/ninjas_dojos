package com.daxos.ninjas_dojos.models;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table( name= "dojos" )
public class Dojo {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long dojo_id;
	
	@NotNull
	@NotEmpty
	private String name;	
	
	@Column(updatable=false)
	@DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date createdAt;
    private Date updatedAt;
	
	@OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;

	public Dojo() {
	}		

	public Dojo(Long dojo_id, String name, Date createdAt, Date updatedAt) {
		this.dojo_id = dojo_id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}	

	public Long getDojo_id() {
		return dojo_id;
	}

	public void setDojo_id(Long dojo_id) {
		this.dojo_id = dojo_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	
	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}			
	

}
