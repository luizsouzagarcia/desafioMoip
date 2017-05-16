package br.com.luizgarcia.moip.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.luizgarcia.moip.pojo.ResponseHealthCheck;
import br.com.luizgarcia.moip.pojo.StatusURL;
import br.com.luizgarcia.moip.pojo.WebhooksURL;
import br.com.luizgarcia.moip.service.HealthCheckService;

/**
 * @author luizgarcia
 * Classe que implementa as funcionalidades de leitura de dados do log.
 */
@Component
public class HealthCheckServiceImpl implements HealthCheckService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.luizgarcia.moip.service.HealthCheckService#getHttpStatusOcurrs()
	 */
	public List<StatusURL> getHttpStatusOcurrs() throws IOException, URISyntaxException {
		List<String> list = getHttpStatus();
		List<StatusURL> listStatusURL = new ArrayList<StatusURL>();
		Map<String, Long> counts = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		for (Entry<String, Long> entry : counts.entrySet()) {
			if (entry.getKey() != "") {
				StatusURL statusURL = new StatusURL();
				statusURL.setUrlResponseCode(entry.getKey());
				statusURL.setQtdResponseCode(entry.getValue());
				listStatusURL.add(statusURL);
			}
		}
		Collections.sort(listStatusURL, new StatusURL());
		return listStatusURL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.luizgarcia.moip.service.HealthCheckService#getRequestToOcurrs()
	 */
	public List<WebhooksURL> getRequestToOcurrs() throws IOException, URISyntaxException {
		List<String> list = getRequestTo();
		List<WebhooksURL> listWebhooksURL = new ArrayList<WebhooksURL>();
		Map<String, Long> counts = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		for (Entry<String, Long> entry : counts.entrySet()) {
			if (entry.getKey() != "") {
				WebhooksURL url = new WebhooksURL();
				url.setRequestUrl(entry.getKey());
				url.setQtdRequestUrl(entry.getValue());
				listWebhooksURL.add(url);
			}
		}
		Collections.sort(listWebhooksURL, new WebhooksURL());
		return listWebhooksURL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.luizgarcia.moip.service.HealthCheckService#getHealthCheck()
	 */
	public ResponseHealthCheck getHealthCheck() throws IOException, URISyntaxException {
		ResponseHealthCheck responseHC = new ResponseHealthCheck();
		responseHC.setStatusURLList(getHttpStatusOcurrs());
		responseHC.setWebhooksURLList(getRequestToOcurrs());
		return responseHC;
	}

	/**
	 * @return Retorna as urls que foram chamadas no arquivo de log.
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public List<String> getRequestTo() throws IOException, URISyntaxException {
		HealthCheckServiceImpl im = new HealthCheckServiceImpl();

		InputStream resource = this.getClass().getResourceAsStream("/log.txt");
		List<String> dados = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8)).lines()
				.collect(Collectors.toList());

		List<String> requestToList = new ArrayList<String>();
		Pattern p = Pattern.compile("\"([^\"]*)\"");
		for (String string : dados) {
			String requestTo = "";
			Matcher m = p.matcher(string);
			while (m.find()) {
				if (!m.group(1).isEmpty() && !m.group(1).matches("-?\\d+(\\.\\d+)?")) {
					requestTo = m.group(1);
				}
			}
			requestToList.add(requestTo);
		}
		return requestToList;
	}

	/**
	 * @return Retorna os HttpStatus que foram gravados no arquivo de log.
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public List<String> getHttpStatus() throws IOException, URISyntaxException {
		HealthCheckServiceImpl im = new HealthCheckServiceImpl();


		InputStream resource = this.getClass().getResourceAsStream("/log.txt");
		List<String> dados = new BufferedReader(new InputStreamReader(resource, StandardCharsets.UTF_8)).lines()
				.collect(Collectors.toList());

		List<String> requestToList = new ArrayList<String>();
		Pattern p = Pattern.compile("\"([^\"]*)\"");
		for (String string : dados) {
			String requestTo = "";
			Matcher m = p.matcher(string);
			while (m.find()) {
				if (!m.group(1).isEmpty() && m.group(1).matches("-?\\d+(\\.\\d+)?")) {
					requestTo = m.group(1);
				}
			}
			requestToList.add(requestTo);
		}
		return requestToList;
	}
}
