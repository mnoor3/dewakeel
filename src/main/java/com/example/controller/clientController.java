package com.example.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.client;
import com.example.repository.clientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Controller
@RestController
@RequestMapping(value="/client")
public class clientController {
	
	@Autowired
	private clientRepository clientrepository;
	@RequestMapping(method=RequestMethod.GET)
	public String get() throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		List<client> client=clientrepository.findActive();
		return mapper.writeValueAsString(client);
		}
	
	@RequestMapping(value="/all" , method=RequestMethod.GET)
	public String getAll() throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		List<client> client=clientrepository.findAll();
		return mapper.writeValueAsString(client);
		}
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public String getOne(@PathVariable long id) throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		client client=clientrepository.findOne(id);
		return mapper.writeValueAsString(client);
		}
	@SuppressWarnings("static-access")
	@RequestMapping(method=RequestMethod.POST)
	public String insert(@RequestBody String data) throws JsonProcessingException{
		ObjectMapper mapper= new ObjectMapper();
		SimpleDateFormat format1=new SimpleDateFormat("dd/MMM/YYYY HH:mm:ss");
		Date date= new Date();
		client client= new client();
		JSONObject object=new JSONObject(data);
		
		
		client.setCLIENT_NAME(object.getString("CLIENT_NAME"));
		client.setCLIENT_ADDRESS(object.getString("CLIENT_ADDRESS"));
		
		client=clientrepository.saveAndFlush(client);
		return mapper.writeValueAsString(client);
	}
	@RequestMapping(value="/{id}" , method=RequestMethod.PUT)
	public String update(@PathVariable long id , @RequestBody String data) throws JsonProcessingException{
		SimpleDateFormat format1=new SimpleDateFormat("dd/MMM/YYYY HH:mm:ss");
		Date date= new Date();
		client client=clientrepository.findOne(id);
		ObjectMapper mapper= new ObjectMapper();
		JSONObject object=new JSONObject(data);
		if(object.has("CLIENT_NAME")) {
			client.setCLIENT_NAME(object.getString("CLIENT_NAME"));
		}
		client=clientrepository.saveAndFlush(client);
	       return mapper.writeValueAsString(client);	  
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable long id) {
		client client=clientrepository.findOne(id);
		clientrepository.delete(client);
		return "Record deleted";
	}
		
	/*@RequestMapping(value="/advancedsearch/all" ,method=RequestMethod.GET)
	public String getAllbySearch() throws JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		List<client> client=clientrepository.findAll();
		return mapper.writeValueAsString(client);
		}*/

	@RequestMapping(value="/search" , method=RequestMethod.GET)
	public String getBySearch(@RequestBody String data) throws JsonProcessingException {
		return getSearch(data ,false);
		}
	@RequestMapping(value="search/all", method=RequestMethod.GET)
	  public String getAllBySearch(@RequestBody String data) throws JsonProcessingException{
		return getSearch(data,false);
		}
	   public String getSearch(String data, boolean active) throws JsonProcessingException{
		   ObjectMapper mapper= new ObjectMapper();
		   JSONObject object=new JSONObject(data);
		   if(!object.has("search")) {
			   return "Search string is missing!";
		   }
		   List<client>client=((active==true)?
				   clientrepository.findBySearch(object.getString("search")):
					   clientrepository.findAllBySearch(object.getString("search")));
		 
		         return mapper.writeValueAsString(client);
	   }
				  
		 
	  
		@RequestMapping(value="/advancedsearch" , method=RequestMethod.GET)
		public String getByAdvancedSearch(@RequestBody String data) throws JsonProcessingException {
			return getAdvancedSearch(data,true);
		
		}
		@RequestMapping(value="/advancedsearch/all" , method=RequestMethod.GET)
		public String getAllByAdvancedSearch(@RequestBody String data) throws JsonProcessingException {
			return getAdvancedSearch(data,false);
		}
		
		public String getAdvancedSearch(String data, boolean active) throws JsonProcessingException{
			ObjectMapper mapper= new ObjectMapper();
			JSONObject object= new JSONObject(data);
			int CLIENT_ID=0;  String CLIENT_NAME=null;  String CLIENT_ADDRESS=null;
			
			if (object.has("CLIENT_ID"))
				CLIENT_ID=object.getInt("CLIENT_ID");
			
			if (object.has("CLIENT_NAME"))
				CLIENT_NAME=object.getString("CLIENT_NAME");
			
			if (object.has("CLIENT_ADDRESS"))
				CLIENT_ADDRESS=object.getString("CLIENT_ADDRESS");
			
			List<client> client=(active==true)?
					
	          clientrepository.findByAdvancedSearh( CLIENT_ID ,CLIENT_NAME ,CLIENT_ADDRESS):
              clientrepository.findAllByAdvancedSearch(CLIENT_ID , CLIENT_NAME ,CLIENT_ADDRESS);	
		return mapper.writeValueAsString(client);	
		}
}
		  
				
				
				
				
				
				
				
				
				
			
		
