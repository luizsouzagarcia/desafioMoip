package br.com.luizgarcia.moip.service;

import java.util.List;

import br.com.luizgarcia.moip.pojo.WebhooksURL;

public interface HealthCheckService {

	/**
	 * @return método que retorno as urls e suas quantidades.
	 */
	public List<WebhooksURL> getHealthCheck();
	
}
