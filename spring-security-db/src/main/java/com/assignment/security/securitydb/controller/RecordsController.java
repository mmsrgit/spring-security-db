package com.assignment.security.securitydb.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.security.securitydb.model.Record;
import com.assignment.security.securitydb.service.RecordService;


/**
 * 
 * @author Maruthi
 * Following Controller class is used to perform CRUD operations on Record table conforming
 * to HTTP standards
 *
 */

@RestController
public class RecordsController {

	@Autowired
	RecordService service;

	@RequestMapping("/all")
	public String hello() {
		return "Hello World";
	}
	
	@RequestMapping(
			value="/getSimpleRecord",
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
			)
	public @ResponseBody Record getUnsecuredRecord() {
		return new Record(2, "name2", "record2");
	}


	@RequestMapping("/secured/all")
	public String securedHello() {
		return "Secured Hello";
	}

	@RequestMapping(
			value = "secured/getRecords", 
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
			)	
	public @ResponseBody List<Record> getAllRecords() {
		return	service.getAllRecords();
	}

	@RequestMapping(
			value = "secured/getRecord/{id}", 
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
			)
	public @ResponseBody Record getRecordById(@PathVariable int id) {
		return service.getRecordById(id);
	}

	@RequestMapping(
			value = "secured/createRecord", 
			method = RequestMethod.POST,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
			)
	public @ResponseBody Record createRecord(@RequestBody  Record record) {
		return service.createRecord(record);
	}

	@RequestMapping(
			value = "secured/updateRecord",
			method = RequestMethod.PUT,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
			)
	public @ResponseBody Record updateRecord(@RequestBody Record record) {
		return service.updateRecord(record);
	}

	@RequestMapping(
			value = "secured/deleteRecord/{id}",
			method = RequestMethod.DELETE
			)
	public void deleteRecord(@PathVariable int id) {
		service.deleteRecord(id);
	}

}
