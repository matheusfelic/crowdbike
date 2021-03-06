package com.software.project.service.rest.resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
//import com.software.project.cep.handler.PositionEventHandler;
import com.software.project.entities.VehiclePosition;
import com.software.project.util.ApplicationContextProvider;


public class VehicleResource extends ServerResource{
	

//	private PositionEventHandler vehicleRequestEventHandler;
	
	@Post
	public String createEntity(final String representation) throws JSONException 
	{
		Gson gson = new Gson();
		VehiclePosition msg = gson.fromJson(representation, VehiclePosition.class);

		String imei = msg.getImei();
		double lat = Double.valueOf(msg.getLat());
		double lng = Double.valueOf(msg.getLng());
		
	/*	vehicleRequestEventHandler = (PositionEventHandler)ApplicationContextProvider.getBean("positionRequestEventHandler");
	    vehicleRequestEventHandler.handleVehiclePosition(new VehiclePosition(imei,String.valueOf(lat), String.valueOf(lng)));
*/
		//verifica na fila se tem carro perto
		//ocorrenciaServiceRestBO = (OcorrenciaServiceRestBO)ApplicationContextProvider.getBean("ocorrenciaServiceRestBO");
		//Ocorrencia ocorrencia = ocorrenciaServiceRestBO.getByLatLng(lat, lng);

		//MsgResponse msgResponse = ocorrenciaServiceRestBO.getAlertByLatLng(lat, lng, 0.03);// 0.03 = 30 metros -> distancia em km
		
		return "OK";
	}

}
