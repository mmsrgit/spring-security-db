package com.assignment.security.securitydb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.security.securitydb.model.Record;
import com.assignment.security.securitydb.repository.RecordRepository;

/**
 * 
 * @author Maruthi
 * 
 * Following class is used at the service layer to call DAO methods for persisting records.
 *
 */


@Service
public class RecordService {
	
	@Autowired
	RecordRepository recordRepository;
	
	/**
	 * GET
	 * @return list of records
	 */
	public List<Record> getAllRecords() {
		List<Record> list = new ArrayList<Record>();
		recordRepository.findAll().forEach(list::add);
		return list;
	}
	
	/**
	 * GET
	 * @return matching record
	 */
	public Record getRecordById(int id) {
		return recordRepository.findOne(id);
	}
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	public Record createRecord(Record record) {
		return recordRepository.save(record);
	}
	
	/**
	 * 
	 * @param record
	 * @return
	 */
	public Record updateRecord(Record record) {
		return recordRepository.save(record);
	}
	
	/**
	 * 
	 * @param record
	 */
	public void deleteRecord(Integer id) {
		recordRepository.delete(id);
	}
	
	
	

}
