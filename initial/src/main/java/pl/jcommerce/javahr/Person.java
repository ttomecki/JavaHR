package pl.jcommerce.javahr;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Person implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String firstName;

	public Person() {
		super();
	}

	public Person(String name, String firstName) {
		super();
		this.name = name;
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
