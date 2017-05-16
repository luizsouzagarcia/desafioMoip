package br.com.luizgarcia.moip.service;

import java.io.IOException;
import java.util.List;

import br.com.luizgarcia.moip.pojo.ResponseHealthCheck;
import br.com.luizgarcia.moip.pojo.StatusURL;
import br.com.luizgarcia.moip.pojo.WebhooksURL;

public interface HealthCheckService {

	/**
	 * @return método que retorno as urls e suas quantidades.
	 * @throws IOException 
	 */
	public ResponseHealthCheck getHealthCheck() throws IOException;
	
	/**
	 * @return
	 * @throws IOException
	 */
	public List<StatusURL> getHttpStatusOcurrs() throws IOException;
	
	/**
	 * @return
	 * @throws IOException
	 */
	public List<WebhooksURL> getRequestToOcurrs() throws IOException;
	
}
