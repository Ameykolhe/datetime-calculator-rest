package com.ameykolhe.datetime.utils;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TimeUnits {
	DAYS,
	WEEKS,
	MONTHS,
	YEARS,
	ALL
}
