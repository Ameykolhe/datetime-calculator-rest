package com.ameykolhe.datetime.utils;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum NaturalLanguageOps {
	TODAY,
	TOMORROW,
	DAY_AFTER_TOMORROW,
	YESTERDAY,
	DAY_BEFORE_YESTERDAY,
	LAST_WEEK,
	LAST_MONTH,
	LAST_YEAR,
	NEXT_WEEK,
	NEXT_MONTH,
	NEXT_YEAR
}
