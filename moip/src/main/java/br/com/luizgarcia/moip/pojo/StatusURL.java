package br.com.luizgarcia.moip.pojo;

import java.util.Comparator;

/**
 * @author luizgarcia
 * Classe que representa o objeto com os códigos de resposta e a quantidade.
 */
public class StatusURL implements Comparator<StatusURL>{

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

	@Override
	public int compare(StatusURL o1, StatusURL o2) {
		return (o1.getQtdResponseCode() > o2.getQtdResponseCode()) ? -1
                : (o1.getQtdResponseCode() < o2.getQtdResponseCode()) ? 1 : 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((qtdResponseCode == null) ? 0 : qtdResponseCode.hashCode());
		result = prime * result + ((urlResponseCode == null) ? 0 : urlResponseCode.hashCode());
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
		StatusURL other = (StatusURL) obj;
		if (qtdResponseCode == null) {
			if (other.qtdResponseCode != null)
				return false;
		} else if (!qtdResponseCode.equals(other.qtdResponseCode))
			return false;
		if (urlResponseCode == null) {
			if (other.urlResponseCode != null)
				return false;
		} else if (!urlResponseCode.equals(other.urlResponseCode))
			return false;
		return true;
	}

}
