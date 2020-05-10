package com.icoder.auth.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.icoder.auth.model.AirData;
import com.icoder.auth.repository.AirDataRepository;
import com.icoder.common.block.BlockChain;

@Service
public class AirDataServiceImpl implements AirDataService {
    @Autowired
    private AirDataRepository airDataRepository;
    
    @Override
    public AirData save(AirData airData) {
    	AirData airDataP=airDataRepository.save(airData);
    	return airDataP;
    }

	@Override
	public List<AirData> findByDate(String date) {
		return airDataRepository.findByDate(date);
	}
	@Override
	public List<AirData> findAll() {
		List<AirData> airDataList=airDataRepository.findAll();
		return airDataList;
	}
	@Override
	public Page<AirData> findAll(Pageable pageable) {
		Page<AirData> airDataList=airDataRepository.findAll(pageable);
		return airDataList;
	}

	@EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up");
        List<AirData> airDataList=airDataRepository.findAll();
        BlockChain blockChain=new BlockChain();
        airDataList.forEach(val->{
        	blockChain.addBlock(val);
        });
        
        System.out.println("Block chain details");
        System.out.println(blockChain.getChain());
        System.out.println(blockChain.getChain().size());
    }

	@Override
	public AirData findByDatePollutant(String date, String pollutant) {
		List<AirData> airDataList=airDataRepository.findByDate(date);
		AirData airData=null;
		if(airDataList.size()>0 && pollutant!=null && pollutant!=""){
		airData=airDataList.stream().filter(val->
			val.getPollutant().equalsIgnoreCase(pollutant)).collect(Collectors.toList()).get(0);
		}
		return airData;
	}
	
	@Override
	public List<AirData> findByDateStationPollutant(String date,String station_id,String pollutant) {
		List<AirData> airDataList=airDataRepository.findByDateStationPollutant(date,station_id,pollutant);
		return airDataList;
	}
}
