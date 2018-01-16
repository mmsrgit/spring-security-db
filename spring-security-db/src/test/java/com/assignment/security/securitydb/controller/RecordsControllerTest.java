package com.assignment.security.securitydb.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.assignment.security.securitydb.model.Record;
import com.assignment.security.securitydb.service.RecordService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 
 * @author Maruthi
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value= RecordsController.class, secure=false)
public class RecordsControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private RecordService recordService;
	
	private Authentication authentication;
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	
	Record mockRecord = new Record(2, "name2", "description2");
	List<Record> mockRecordList = Arrays.asList(new Record(1, "name1", "description1"),
			new Record(2, "name2", "description2"),
			new Record(3, "name3", "description3"));
	
	@Before
	public void init() {
		this.authentication = new UsernamePasswordAuthenticationToken("mmsr", "mmsr");
	}
	
	@Test
	public void testGetAllRecords() throws Exception {
		
		SecurityContextHolder.getContext().setAuthentication(this.authentication);
		Mockito.when(
				recordService.getAllRecords()).thenReturn(mockRecordList);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/secured/getRecords").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}
	
	@Test
	public void testGetRecordById() throws Exception {
		
		SecurityContextHolder.getContext().setAuthentication(this.authentication);
		Mockito.when(
				recordService.getRecordById(Mockito.anyInt())).thenReturn(mockRecord);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/secured/getRecord/1").accept(
				MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		
	}
	
	@Test
	public void testCreateRecord() throws Exception {
		SecurityContextHolder.getContext().setAuthentication(this.authentication);
		Mockito.when(
				recordService.createRecord(Mockito.any())).thenReturn(mockRecord);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/secured/createRecord").contentType(APPLICATION_JSON_UTF8)
				.content(convertObjectToJsonBytes(mockRecord))
				.accept(	MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		
	}
	
	@Test
	public void testUpdateRecord() throws Exception {
		SecurityContextHolder.getContext().setAuthentication(this.authentication);
		Mockito.when(
				recordService.updateRecord(Mockito.any())).thenReturn(mockRecord);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
				"/secured/updateRecord").contentType(APPLICATION_JSON_UTF8)
				.content(convertObjectToJsonBytes(mockRecord))
				.accept(	MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}
	
	@Test
	public void testDeleteRecord() {
		
	}
	
    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsBytes(object);
    }
 
    public static String createStringWithLength(int length) {
        StringBuilder builder = new StringBuilder();
 
        for (int index = 0; index < length; index++) {
            builder.append("a");
        }
 
        return builder.toString();
    }

}
