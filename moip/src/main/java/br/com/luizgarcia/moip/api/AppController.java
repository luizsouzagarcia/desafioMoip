package br.com.luizgarcia.moip.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	//Listar as informações selecionadas para o desafio.
	@ResponseBody
    @RequestMapping(value = "/healthcheck/", method = RequestMethod.GET)
    public void listar() {
       System.out.println("teste");
    }
	
}
