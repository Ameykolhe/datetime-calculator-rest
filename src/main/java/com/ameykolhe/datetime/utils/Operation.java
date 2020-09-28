package com.ameykolhe.datetime.utils;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Operation {
	DIFF_BETWEEN_DATES,
	ADD_N_UNITS,
	SUB_N_UNITS,
	NATURAL_LANGUAGE_PHRASES,
	GET_DATA_FROM_DATE
}
