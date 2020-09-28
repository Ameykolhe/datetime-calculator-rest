package com.ameykolhe.datetime.utils;

import com.ameykolhe.datetime.entities.DateTime;

public class DateTimeFormatter {
	
	public static String format(DateTime element) {
		String processedHistoryElement = element.getOperation().toString();
		switch(element.getOperation()) {
			case ADD_N_UNITS:
				processedHistoryElement += " : " + element.getDate1() + " + " + element.getValue() + " " + element.getTimeUnits() + " = " + element.getResult();
				break;
			case DIFF_BETWEEN_DATES:
				processedHistoryElement += " : " + element.getDate1() + " & " + element.getDate2() + " = " + element.getResult();
				break;
			case GET_DATA_FROM_DATE:
				processedHistoryElement += " : " + element.getDate1() + " = " + element.getResult();
				break;
			case NATURAL_LANGUAGE_PHRASES:
				processedHistoryElement += " : " + element.getNaturalLanguageOp() + " = " + element.getResult();
				break;
			case SUB_N_UNITS:
				processedHistoryElement += " : " + element.getDate1() + " - " + element.getValue() + " " + element.getTimeUnits() + " = " + element.getResult();
				break;
			default:
				break;
		}
		
		return processedHistoryElement;
	}
}
