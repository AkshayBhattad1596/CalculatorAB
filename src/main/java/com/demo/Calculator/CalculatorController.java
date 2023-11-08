package com.demo.Calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

	@PostMapping("/calculate")
	public double calculate(@RequestBody CalculatorRequest request, @RequestParam("operation") String operation) {

		try {
			double num1 = request.getNum1();
			double num2 = request.getNum2();
			switch (operation) {

			case "add":
				logger.info("Calculating addition of two numbers are num1=" + num1 + " ,num2=" + num2);
				return num1 + num2;
			case "subtract":
				logger.info("Calculating subtraction of two numbers are num1=" + num1 + " ,num2=" + num2);
				return num1 - num2;
			case "multiply":
				logger.info("Calculating multiplication of two numbers are num1=" + num1 + " ,num2=" + num2);
				return num1 * num2;
			case "divide":
				logger.info("Calculating division of two numbers are num1=" + num1 + " ,num2=" + num2);
				return num1 / num2;
			default:
				logger.error("Operation value not valid " + operation);
				logger.info("Accepted values are add,subtract,multiply,divide ");
				throw new IllegalArgumentException();
			}
			
			
		} catch (Exception e) {
			logger.error("Exception occured while calculating " + e);
		}
		return 0;
	}
}
