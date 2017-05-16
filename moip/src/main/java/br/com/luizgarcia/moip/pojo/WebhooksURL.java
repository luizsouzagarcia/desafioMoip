package br.com.luizgarcia.moip.pojo;

/**
 * @author luizgarcia
 * Classe que representa o objeto com as url acionadas e a quantidade que foram acionadas.
 */
public class WebhooksURL {

	

	private String requestUrl;
	
	private Long qtdRequestUrl;

	public WebhooksURL(String requestUrl, Long qtdRequestUrl) {
		super();
		this.requestUrl = requestUrl;
		this.qtdRequestUrl = qtdRequestUrl;
	}
	
	public WebhooksURL() {
		// TODO Auto-generated constructor stub
	}

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
	public Long getQtdRequestUrl() {
		return qtdRequestUrl;
	}

	/**
	 * @param long1 the qtdRequestUrl to set
	 */
	public void setQtdRequestUrl(Long long1) {
		this.qtdRequestUrl = long1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qtdRequestUrl == null) ? 0 : qtdRequestUrl.hashCode());
		result = prime * result + ((requestUrl == null) ? 0 : requestUrl.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebhooksURL other = (WebhooksURL) obj;
		if (qtdRequestUrl == null) {
			if (other.qtdRequestUrl != null)
				return false;
		} else if (!qtdRequestUrl.equals(other.qtdRequestUrl))
			return false;
		if (requestUrl == null) {
			if (other.requestUrl != null)
				return false;
		} else if (!requestUrl.equals(other.requestUrl))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WebhooksURL [requestUrl=" + requestUrl + ", qtdRequestUrl=" + qtdRequestUrl + "]";
	}
	
	
	
}
