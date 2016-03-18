package com.myCompany.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;


@Repository
public class MyCassandraTemplate {

	@Autowired
	private CassandraOperations cassandraTemplate;
	
	
	/**
	* Creating the entity.
	* @param entity
	* @return {@link Object}
	*/
	public <T> T create(T entity) {
		return cassandraTemplate.insert(entity);
	}
	
	/**
	* Creating the list of entities.
	* @param entity
	*/
	public <T> void createList(List<T> entities) {
		cassandraTemplate.insert(entities); 
	}
	
	/**
	* Updating the entity.
	* @param entity
	* @param c
	* @return T
	*/
	public <T> T update(T entity) { 
		return (T) cassandraTemplate.update(entity);
	}
	
	/**
	* Updating the list of entities.
	* @param entity
	* @param c
	* @return T
	*/
	public <T> void updateList(List<T> entities) { 
		cassandraTemplate.update(entities);
	}
	
	/**
	* Updating the entity.
	* @param entity
	* @param c
	* @return T
	*/
	public <T> T update(T entity, Class<T> c) { 
		return (T) cassandraTemplate.update(entity);
	}
	
	/**
	* Get the Entity using Id.
	* @param id
	* @param c
	* @return T
	*/
	public <T> T findById(Object id, Class<T> c) {
		return cassandraTemplate.selectOneById(c, id);
	}
	
	/**
	* Delete the Entity using Id.
	* @param id
	* @param c
	*/
	public <T> void deleteById(Object id, Class<T> c) {
		cassandraTemplate.deleteById(c, id);
	}
	
	/**
	* Delete the Entity using object.
	* @param entity 
	*/
	public void delete(Object entity) {
		cassandraTemplate.delete(entity);
	}
	
	/**
	* Deleting the list of entities 
	* @param entities
	*/
	public <T> void delete(List<T> entities) {
		cassandraTemplate.delete(entities);
	}
	
	/**
	* Deleting the all entities. 
	* @param c
	*/
	public <T> void deleteAll(Class<T> c) {
		cassandraTemplate.deleteAll(c);
	}
	
	/**
	* Getting the all entities.
	* @param c
	* @return List of entities
	*/
	public <T> List<T> findAll(Class<T> c) {
		return (List<T>) cassandraTemplate.selectAll(c);
	}
	
	/**
	* Getting the all entity values using specific id's data.
	* @param ids
	* @param c
	* @return
	*/
	public <T> List<T> findAll(List<Object> ids, Class<T> c) {
		return cassandraTemplate.selectBySimpleIds(c, ids);
	}
	
	/**
	* Getting the count of records.
	* @param c
	* @return the count value.
	*/
	public <T> void truncate(Class<T> c) {
		cassandraTemplate.truncate(c.getName());
	}
	
	/**
	* Getting the count of records.
	* @param c
	* @return the count value.
	*/
	public <T> long getCount(Class<T> c) {
		return cassandraTemplate.count(c);
	} 
	
	
	/**
	* Checking the object exists or not.
	* @param id
	* @param c
	* @return true if the object exists in the database otherwise it will return false.
	*/
	public <T> boolean exists(Object id, Class<T> c) {
		return cassandraTemplate.exists(c, id);
	}

}