package br.com.luizgarcia.moip.service.impl;

import java.io.File;
import java.io.IOException;
import java.net.URL;
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

@Component
public class HealthCheckServiceImpl implements HealthCheckService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.luizgarcia.moip.service.HealthCheckService#getHttpStatusOcurrs()
	 */
	public List<StatusURL> getHttpStatusOcurrs() throws IOException {
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
	public List<WebhooksURL> getRequestToOcurrs() throws IOException {
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
	public ResponseHealthCheck getHealthCheck() throws IOException {
		ResponseHealthCheck responseHC = new ResponseHealthCheck();
		responseHC.setStatusURLList(getHttpStatusOcurrs());
		responseHC.setWebhooksURLList(getRequestToOcurrs());
		return responseHC;
	}

	/**
	 * @return
	 */
	public URL getFile() {
		return getClass().getResource("/static/log/log.txt");
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public static String getLogInfo() throws IOException {
		HealthCheckServiceImpl im = new HealthCheckServiceImpl();
		URL url = im.getFile();
		File file = new File(url.getPath());
		String dados = new String(Files.readAllBytes(file.toPath()));
		return dados;
	}

	/**
	 * @return Retorna as urls que foram chamadas no arquivo de log.
	 * @throws IOException
	 */
	public List<String> getRequestTo() throws IOException {
		HealthCheckServiceImpl im = new HealthCheckServiceImpl();
		URL url = im.getFile();
		File file = new File(url.getPath());
		List<String> dados = Files.readAllLines(file.toPath());
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
	 */
	public List<String> getHttpStatus() throws IOException {
		HealthCheckServiceImpl im = new HealthCheckServiceImpl();
		URL url = im.getFile();
		File file = new File(url.getPath());
		List<String> dados = Files.readAllLines(file.toPath());
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
