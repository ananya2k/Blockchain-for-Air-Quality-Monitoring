package com.icoder.auth.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.icoder.auth.model.AirData;
import com.icoder.auth.service.AirDataService;

@Component
public class AirDataValidator implements Validator {
    @Autowired
    private AirDataService airDataService;

    @Override
    public boolean supports(Class<?> aClass) {
        return AirDataService.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    	AirData airData = (AirData) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "station_id", "NotEmpty");
        if (airData.getStation_id().length() < 5 ||airData.getStation_id().length() > 32) {
            errors.rejectValue("station_id", "Size.airDataForm.station_id");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "NotEmpty");
        if (airData.getDate().length() < 5 ||airData.getDate().length() > 32) {
            errors.rejectValue("date", "Size.airDataForm.date");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pollutant", "NotEmpty");
        if (airData.getPollutant()!=null){
        	
        	if(airData.getPollutant().length() < 5 ||airData.getPollutant().length() > 32){
                errors.rejectValue("pollutant", "Size.airDataForm.pollutant");
            }else if (airDataService.findByDateStationPollutant(airData.getDate(),airData.getStation_id(),airData.getPollutant()).size()>0) {
                errors.rejectValue("pollutant", "Duplicate.airDataForm.pollutantsamedate");
            }
        }else{
        	errors.rejectValue("pollutant", "NotEmpty");
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h01", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h02", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h03", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h04", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h05", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h06", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h07", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h08", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h09", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h10", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h11", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h12", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h13", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h14", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h15", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h16", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h17", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h18", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h19", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h20", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h21", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h22", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h23", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "h24", "NotEmpty");
      }
}
