package com.nagarro.restfulservice.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import com.nagarro.restfulservice.entities.Employee;

public class CSVDownloader {
	public static ByteArrayInputStream employeeToCSV(List<Employee> employees) {
	    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

	    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
	        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
	      for (Employee employee : employees) {
	        List<String> data = Arrays.asList(
	              String.valueOf(employee.getEmployeeCode()),
	              employee.getEmployeeName(),
	              employee.getLocation(),
	              employee.getEmail(),
	              employee.getDob()
	            );

	        csvPrinter.printRecord(data);
	      }

	      csvPrinter.flush();
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
	    }
	}
}
