package br.com.luizgarcia.moip.pojo;

/**
 * @author luizgarcia
 * Classe que representa o objeto com as url acionadas e a quantidade que foram acionadas.
 */
public class WebhooksURL {

	private String requestUrl;
	
	private int qtdRequestUrl;

	/**
	 * @return the requestUrl
	 */
	public String getRequestUrl() {
		return requestUrl;
	}

	/**
	 * @param requestUrl the requestUrl to set
	 */
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	/**
	 * @return the qtdRequestUrl
	 */
	public int getQtdRequestUrl() {
		return qtdRequestUrl;
	}

	/**
	 * @param qtdRequestUrl the qtdRequestUrl to set
	 */
	public void setQtdRequestUrl(int qtdRequestUrl) {
		this.qtdRequestUrl = qtdRequestUrl;
	}
	
	
	
}
