package com.icoder.auth.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.icoder.auth.model.AirData;

public interface AirDataService {
    AirData save(AirData airData);
    List<AirData> findByDate(String date);
    List<AirData> findAll();
    Page<AirData> findAll(Pageable pageable);
    AirData findByDatePollutant(String date,String pollutant);
    List<AirData> findByDateStationPollutant(String date, String station_id, String pollutant);
}
