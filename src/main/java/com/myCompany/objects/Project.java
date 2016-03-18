package com.myCompany.objects;
import javax.validation.constraints.NotNull;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;
@Table("project")
public class Project {
	
	@PrimaryKey("id")
	public Integer id;
	
	@NotNull
	@Column("name")
	public String name;
	
	@Column(value = "budget")
	public Float budget;

}
