package com.ameykolhe.datetime.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ameykolhe.datetime.entities.DateTime;
import com.ameykolhe.datetime.entities.Result;
import com.ameykolhe.datetime.exceptions.InvalidParameterException;
import com.ameykolhe.datetime.service.DateTimeCalculatorService;
import com.ameykolhe.datetime.utils.InputValidator;

@RestController
@RequestMapping("/api")
public class DateTimeCalculatorRestController {
	
	@Autowired
	private DateTimeCalculatorService service;
	
	@GetMapping("/history")
	public List<String> getHistory() {
		return service.getHistory();
	}
	
	@PostMapping("/calculate")
	public Result calculate(@RequestBody DateTime dateTime) throws InvalidParameterException {
		System.out.println(dateTime);
		if (InputValidator.validate(dateTime)) {
			return service.calculate(dateTime);
		}
		return null;
	}

}
