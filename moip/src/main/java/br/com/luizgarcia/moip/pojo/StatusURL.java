package br.com.luizgarcia.moip.pojo;


/**
 * @author luizgarcia
 * Classe que representa o objeto com os códigos de resposta e a quantidade.
 */
public class StatusURL {

	private String urlResponseCode;

	private Long qtdResponseCode;

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
	public Long getQtdResponseCode() {
		return qtdResponseCode;
	}

	/**
	 * @param long1 the qtdResponseCode to set
	 */
	public void setQtdResponseCode(Long long1) {
		this.qtdResponseCode = long1;
	}

}
