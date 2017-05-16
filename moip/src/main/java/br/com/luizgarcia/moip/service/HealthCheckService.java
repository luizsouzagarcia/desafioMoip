package br.com.luizgarcia.moip.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import br.com.luizgarcia.moip.pojo.ResponseHealthCheck;
import br.com.luizgarcia.moip.pojo.StatusURL;
import br.com.luizgarcia.moip.pojo.WebhooksURL;

public interface HealthCheckService {

	/**
	 * @return método que retorno as urls e suas quantidades.
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public ResponseHealthCheck getHealthCheck() throws IOException, URISyntaxException;
	
	/**
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException 
	 */
	public List<StatusURL> getHttpStatusOcurrs() throws IOException, URISyntaxException;
	
	/**
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException 
	 */
	public List<WebhooksURL> getRequestToOcurrs() throws IOException, URISyntaxException;
	
}
