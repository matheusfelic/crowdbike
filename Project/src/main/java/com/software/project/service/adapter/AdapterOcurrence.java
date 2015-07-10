package com.software.project.service.adapter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;






import com.google.gson.Gson;
import com.software.project.entities.Attributes;
import com.software.project.entities.Entity;
import com.software.project.entities.Ocorrencia;
import com.software.project.entities.User;

public class AdapterOcurrence {
	
	public static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
    public static Entity toEntity(Ocorrencia o) {
    	Entity e = new Entity();
    	List<Attributes> aList = new ArrayList<Attributes>();
    	aList.add(new Attributes("title", "String", o.getTitle()));
    	aList.add(new Attributes("lat", "String", o.getLat()));
    	aList.add(new Attributes("lng", "String", o.getLng()));
    	aList.add(new Attributes("endereco", "String", o.getEndereco()));
    	aList.add(new Attributes("dataOcorrencia", "String", df.format(o.getDataOcorrencia()))); 
    	aList.add(new Attributes("userId", "String", String.valueOf(o.getUser().getId())));   
    	
    	e.setId(String.valueOf(o.getIdOcorrencia()));
    	e.setType("Ocurrence");

		return e;
		
	}
    
    public static ContextResponses toContextResponses(String s) {
    	Gson g = new Gson();
    	ContextResponses cr = new ContextResponses();
    	cr = g.fromJson(s, ContextResponses.class);
		return cr;

    }
    
    public static Ocorrencia toOcurrence(Entity e) throws ParseException {
    	Ocorrencia o = new Ocorrencia();
    	o.setIdOcorrencia(Long.parseLong(e.getId()));
    	for (Attributes att : e.getAttributes()) {
    		switch (att.getName()) {
    		case "title":
				o.setTitle(att.getValue());
				break;
			case "lat":
				o.setLat(att.getValue());
				break;
			case "lng":
				o.setLng(att.getValue());
				break;
			case "endereco":
				o.setEndereco(att.getValue());
				break;
			case "dataOcorrencia":
				Date date = null;
				date = df.parse(att.getValue());
				o.setDataOcorrencia(date);
				break;	
			case "userId":
				User u = new User();
				u.setId(Long.parseLong(att.getValue()));
				o.setUser(u);
				break;	
			}
			
		}
		return o;
		
	}
}