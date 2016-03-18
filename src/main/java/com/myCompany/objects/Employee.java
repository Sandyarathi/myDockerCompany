package com.myCompany.objects;
import javax.validation.constraints.NotNull;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
@Table("employee")
public class Employee {
	
	@PrimaryKey("id")
	public Integer id;
	
	

	@NotNull
	@Column("lastname")
	public String lastName;
	
	@NotNull
	@Column("firstname")
	public String firstName;
	
	/**
	* Default Constructor
	*/
	public Employee() {
		super(); 
	}
	
	/**
	* Parameterized Constructor
	* @param id
	* @param firstname
	* @param  lastname
	*/
	public Employee(Integer id, String firstname, String lastname ) {
		super();
		this.id = id;
		this.firstName = firstname;
		this.lastName = lastname;
	}
	

}
