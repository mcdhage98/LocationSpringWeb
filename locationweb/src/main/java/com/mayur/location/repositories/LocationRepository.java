package com.mayur.location.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mayur.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {
	
	@Query("select type,count(type) from Location group by(type)")
	public List<Object[]> findTypeAndTypeCount();

}
