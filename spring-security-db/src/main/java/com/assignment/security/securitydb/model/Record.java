package com.assignment.security.securitydb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Maruthi
 * Following is the Entity Bean for persisting the records in the table
 *
 */


@Entity
@Table(name = "record")
@XmlRootElement
public class Record {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	
	public Record() {
		
	}
	
	public Record(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	@XmlElement
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@XmlElement
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@XmlElement
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}
