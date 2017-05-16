package br.com.luizgarcia.moip.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.luizgarcia.moip.pojo.ResponseHealthCheck;
import br.com.luizgarcia.moip.service.impl.HealthCheckServiceImpl;

@RestController
public class HealthCheckController {
	
	//Listar as informações selecionadas para o desafio.
	@Autowired
    HealthCheckServiceImpl healthCheckServiceImpl;  
	
    /**
     * @return 
     * @throws IOException 
     * @throws URISyntaxException 
     * @throws JSONException 
     */
    @RequestMapping(value = "/healthcheck/", method = RequestMethod.GET)
    public @ResponseBody String getHealthCheck() throws IOException, URISyntaxException {
        ResponseHealthCheck responseHealthCheck = healthCheckServiceImpl.getHealthCheck();
        String json = new Gson().toJson(responseHealthCheck);
        return json;
    }
	
}
