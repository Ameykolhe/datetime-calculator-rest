package com.ameykolhe.datetime.utils;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DataRetrivalOps {
	DAY_OF_WEEK,
	DAY_OF_MONTH,
	DAY_OF_YEAR,
	WEEK_NUMBER,
	MONTH,
	YEAR
}
