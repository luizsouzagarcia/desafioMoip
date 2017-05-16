package br.com.luizgarcia.moip.service;

import java.io.IOException;
import java.util.List;

import br.com.luizgarcia.moip.pojo.ResponseHealthCheck;

public interface HealthCheckService {

	/**
	 * @return método que retorno as urls e suas quantidades.
	 * @throws IOException 
	 */
	public ResponseHealthCheck getHealthCheck() throws IOException;
	
}
