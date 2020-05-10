package com.icoder.auth.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.icoder.auth.model.AirData;

public interface AirDataRepository extends PagingAndSortingRepository<AirData, Integer>{
	List<AirData> findByDate(String date);
	List<AirData> findAll();
	Page<AirData> findAll(Pageable pageable);
	
	@Query(value ="SELECT * FROM air_data WHERE date = ?1 AND station_id = ?2 AND pollutant=?3",nativeQuery = true)
    List<AirData> findByDateStationPollutant(String date, String station_id, String pollutant);
	}
