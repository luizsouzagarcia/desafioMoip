package br.com.luizgarcia.moip.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
     */
    @RequestMapping(value = "/healthcheck/", method = RequestMethod.GET)
    public ResponseEntity<ResponseHealthCheck> getHealthCheck() throws IOException {
        ResponseHealthCheck webhooksURL = healthCheckServiceImpl.getHealthCheck();
        if(webhooksURL == null){
            return new ResponseEntity<ResponseHealthCheck>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ResponseHealthCheck>(HttpStatus.OK);
    }
	
}
