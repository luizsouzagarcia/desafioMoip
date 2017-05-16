package br.com.luizgarcia.moip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.luizgarcia.moip.pojo.WebhooksURL;
import br.com.luizgarcia.moip.service.HealthCheckServiceImpl;

@RestController
public class HealthCheckController {
	
	//Listar as informações selecionadas para o desafio.
	@Autowired
    HealthCheckServiceImpl healthCheckService;  
	
    /**
     * @return 
     */
    @RequestMapping(value = "/healthcheck/", method = RequestMethod.GET)
    public ResponseEntity<List<WebhooksURL>> getHealthCheck() {
        List<WebhooksURL> webhooksURL = healthCheckService.getHealthCheck();
        if(webhooksURL.isEmpty()){
            return new ResponseEntity<List<WebhooksURL>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<WebhooksURL>>(webhooksURL, HttpStatus.OK);
    }
	
}
