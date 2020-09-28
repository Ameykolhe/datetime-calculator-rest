package com.ameykolhe.datetime.utils;

import org.apache.commons.lang3.EnumUtils;

import com.ameykolhe.datetime.entities.DateTime;
import com.ameykolhe.datetime.exceptions.InvalidParameterException;

public class InputValidator {
	
	public static boolean validate(DateTime dateTime) throws InvalidParameterException {
		
		if (dateTime.getOperation() == null) {
			throw new InvalidParameterException("Required Parameter: operation");
		}
		
		switch(dateTime.getOperation()) {
			
			case DIFF_BETWEEN_DATES:
				if (dateTime.getDate1() == null) {
					throw new InvalidParameterException("Required Parameter: date1");
				}
				if (dateTime.getDate2() == null) {
					throw new InvalidParameterException("Required Parameter: date2");
				}
				if (dateTime.getTimeUnits() != null) {
					if (! EnumUtils.isValidEnum(TimeUnits.class, dateTime.getTimeUnits().name())) {
						throw new InvalidParameterException(dateTime.getTimeUnits());
					}
				}
				else {
					throw new InvalidParameterException("Requird Parameter: timeUnits");
				}
				break;
				
			case ADD_N_UNITS:
				if (dateTime.getDate1() == null) {
					throw new InvalidParameterException("Required Parameter: date1");
				}
				if (dateTime.getValue() == 0) {
					throw new InvalidParameterException("Specify value");
				}
				if (dateTime.getTimeUnits() != null) {
					if (! EnumUtils.isValidEnum(TimeUnits.class, dateTime.getTimeUnits().name())) {
						throw new InvalidParameterException(dateTime.getTimeUnits());
					}
				}
				else {
					throw new InvalidParameterException("Requird Parameter: timeUnits");
				}
				break;
				
			case SUB_N_UNITS:
				if (dateTime.getDate1() == null) {
					throw new InvalidParameterException("Required Parameter: date1");
				}
				if (dateTime.getValue() == 0) {
					throw new InvalidParameterException("Specify value");
				}
				if (dateTime.getTimeUnits() != null) {
					if (! EnumUtils.isValidEnum(TimeUnits.class, dateTime.getTimeUnits().name())) {
						throw new InvalidParameterException(dateTime.getTimeUnits());
					}
				}
				else {
					throw new InvalidParameterException("Requird Parameter: timeUnits");
				}
				break;
				
			case NATURAL_LANGUAGE_PHRASES:
				if (dateTime.getNaturalLanguageOp() != null) {
					if (! EnumUtils.isValidEnum(NaturalLanguageOps.class, dateTime.getNaturalLanguageOp().name())) {
						throw new InvalidParameterException(dateTime.getNaturalLanguageOp());
					}
				}
				else {
					throw new InvalidParameterException("Requird Parameter: naturalLanguageOp");
				}
				break;
		
			case GET_DATA_FROM_DATE:
				if (dateTime.getDate1() == null) {
					throw new InvalidParameterException("Required Parameter: date1");
				}
				if (dateTime.getDataRetrivalOps() != null) {
					if (! EnumUtils.isValidEnum(DataRetrivalOps.class, dateTime.getDataRetrivalOps().name())) {
						throw new InvalidParameterException(dateTime.getDataRetrivalOps());
					}
				}
				else {
					throw new InvalidParameterException("Requird Parameter: dataRetrivalOps");
				}
				break;
				
				
			default:
				throw new InvalidParameterException(dateTime.getOperation());
		}
		
		return true;
	}
}
