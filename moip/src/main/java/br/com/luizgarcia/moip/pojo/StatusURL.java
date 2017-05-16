package br.com.luizgarcia.moip.pojo;


/**
 * @author luizgarcia
 * Classe que representa o objeto com os códigos de resposta e a quantidade.
 */
public class StatusURL {

	private String urlResponseCode;

	private int qtdResponseCode;

	/**
	 * @return the urlResponseCode
	 */
	public String getUrlResponseCode() {
		return urlResponseCode;
	}

	/**
	 * @param urlResponseCode the urlResponseCode to set
	 */
	public void setUrlResponseCode(String urlResponseCode) {
		this.urlResponseCode = urlResponseCode;
	}

	/**
	 * @return the qtdResponseCode
	 */
	public int getQtdResponseCode() {
		return qtdResponseCode;
	}

	/**
	 * @param qtdResponseCode the qtdResponseCode to set
	 */
	public void setQtdResponseCode(int qtdResponseCode) {
		this.qtdResponseCode = qtdResponseCode;
	}

}
