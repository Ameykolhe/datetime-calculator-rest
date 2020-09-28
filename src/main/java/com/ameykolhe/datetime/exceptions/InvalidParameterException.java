package com.ameykolhe.datetime.exceptions;

import com.ameykolhe.datetime.utils.DataRetrivalOps;
import com.ameykolhe.datetime.utils.NaturalLanguageOps;
import com.ameykolhe.datetime.utils.Operation;
import com.ameykolhe.datetime.utils.TimeUnits;

public class InvalidParameterException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8591339797135943221L;

	public InvalidParameterException(Operation operation) {
		super("Invalid Operation : " + operation.name());
	}
	
	public InvalidParameterException(DataRetrivalOps dataRetrivalOps) {
		super("Invalid DataRetrivalOps : " + dataRetrivalOps.name());
	}
	
	public InvalidParameterException(NaturalLanguageOps naturalLanguageOps) {
		super("Invalid NaturalLanguageOps : " + naturalLanguageOps.name());
	}
	
	public InvalidParameterException(String str) {
		super(str);
	}

	public InvalidParameterException(TimeUnits timeUnits) {
		super("Invalid TimeUnits : " + timeUnits.name());
	}

}
