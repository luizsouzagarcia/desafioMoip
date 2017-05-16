package br.com.luizgarcia.moip.pojo;

import java.util.List;

public class ResponseHealthCheck {

	public ResponseHealthCheck(List<WebhooksURL> webhooksURLList, List<StatusURL> statusURLList) {
		super();
		this.webhooksURLList = webhooksURLList;
		this.statusURLList = statusURLList;
	}

	public ResponseHealthCheck() {
		// TODO Auto-generated constructor stub
	}

	private List<WebhooksURL> webhooksURLList;
	
	private List<StatusURL> statusURLList;

	/**
	 * @return the webhooksURLList
	 */
	public List<WebhooksURL> getWebhooksURLList() {
		return webhooksURLList;
	}

	/**
	 * @param webhooksURLList the webhooksURLList to set
	 */
	public void setWebhooksURLList(List<WebhooksURL> webhooksURLList) {
		this.webhooksURLList = webhooksURLList;
	}

	/**
	 * @return the statusURLList
	 */
	public List<StatusURL> getStatusURLList() {
		return statusURLList;
	}

	/**
	 * @param statusURLList the statusURLList to set
	 */
	public void setStatusURLList(List<StatusURL> statusURLList) {
		this.statusURLList = statusURLList;
	}
}
