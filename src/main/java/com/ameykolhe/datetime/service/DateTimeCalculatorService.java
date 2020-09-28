package com.ameykolhe.datetime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ameykolhe.datetime.calculator.DateTimeCalculator;
import com.ameykolhe.datetime.dao.DateTimeDAO;
import com.ameykolhe.datetime.entities.DateTime;
import com.ameykolhe.datetime.entities.Result;
import com.ameykolhe.datetime.exceptions.InvalidParameterException;
import com.ameykolhe.datetime.utils.DateTimeFormatter;

@Service
public class DateTimeCalculatorService {
	
	DateTimeDAO dateTimeDAO = new DateTimeDAO();
	
	DateTimeCalculator dateTimeCalculator = new DateTimeCalculator();
	
	public List<String> getHistory() {
		List<DateTime> history = dateTimeDAO.getHisotry();
		List<String> processedHistory = new ArrayList<>();
		
		history.forEach( element -> {
			processedHistory.add(DateTimeFormatter.format(element));
		});
		
		
		return processedHistory;
	}
	

	public Result calculate(DateTime dateTime) throws InvalidParameterException {
		String resultStr = null;
		
		switch(dateTime.getOperation()) {
			
			case DIFF_BETWEEN_DATES:
				resultStr = dateTimeCalculator.diff_between_dates(dateTime.getDate1(), dateTime.getDate2(), dateTime.getTimeUnits());
				break;
				
			case ADD_N_UNITS:
				resultStr = dateTimeCalculator.addNUnits(dateTime.getDate1(), dateTime.getValue(), dateTime.getTimeUnits());
				break;
				
			case SUB_N_UNITS:
				resultStr = dateTimeCalculator.subNUnits(dateTime.getDate1(), dateTime.getValue(), dateTime.getTimeUnits());
				break;
				
			case NATURAL_LANGUAGE_PHRASES:
				resultStr = dateTimeCalculator.processNaturalLanguagePhrases(dateTime.getNaturalLanguageOp());
				break;
		
			case GET_DATA_FROM_DATE:
				resultStr = dateTimeCalculator.getDataFromDate(dateTime.getDate1(), dateTime.getDataRetrivalOps());
				break;
				
				
			default:
				break;
		}
		
		dateTime.setResult(resultStr);
		dateTimeDAO.add(dateTime);
		
		Result result = new Result();
		result.setOperation(dateTime.getOperation().name());
		result.setResult(DateTimeFormatter.format(dateTime));
		
		return result;
	}

}
