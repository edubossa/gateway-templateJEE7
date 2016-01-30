package br.com.gateway.elavon.util;

import java.net.SocketTimeoutException;
import java.util.logging.Logger;

import javax.enterprise.context.Dependent;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import br.com.gateway.elavon.callback.ElavonResponseHandler;

@Dependent
public class HttpUtil {
	
	private Logger log = Logger.getLogger(getClass().getCanonicalName());
	
	public  String postParameter(String url, String xml) throws SocketTimeoutException, Exception {
		HttpPost httpPost = new HttpPost(url);
		StringEntity input = new StringEntity(xml);
		log.info("XML ENVIO: " + xml);
		input.setContentType("application/xml");
		httpPost.setEntity(input);
		
		return execute(httpPost, 0);
	}
	
	/** Executa requisicao http **/
	private String execute(HttpRequestBase requestBase, int timeout) throws SocketTimeoutException, Exception {
		Builder config = RequestConfig.custom();
		
		if (timeout > 0) {
			log.info("timeout: " + timeout);
			config.setSocketTimeout(timeout);
		}
		RequestConfig requestConfig = config.build();
		CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
		String response = null;
		try {
			
			log.fine("URL Requisicao: " + requestBase.getRequestLine());
            response = httpclient.execute(requestBase, new ElavonResponseHandler());
            log.info("XML Retorno: " + response);
			
		} catch (Exception e) {
			log.severe(e.getCause() +  " " + e.getMessage()); 
		} finally {
			httpclient.close();
		}
		
		return response; 
	}
	
}
