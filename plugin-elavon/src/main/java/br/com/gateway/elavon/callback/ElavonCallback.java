package br.com.gateway.elavon.callback;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.concurrent.FutureCallback;

public class ElavonCallback implements FutureCallback<HttpResponse> {
	
	private Logger log = Logger.getLogger(getClass().getCanonicalName());
	
	@Override
	public void completed(HttpResponse result) {
		log.info("completed ->" + result.getStatusLine());
		
		try {
			
			HttpEntity entity = null;
			StringBuffer retorno = null;
			entity = result.getEntity();
			
			//verifica se a requisicao foi efetuada com sucesso
			if (HttpStatus.SC_OK == result.getStatusLine().getStatusCode()) {	
				retorno = new StringBuffer();	 			
				String linha = null;
				BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), "ISO-8859-1")); 	
				while((linha = br.readLine()) != null ) {
					retorno.append(linha);
				}
				br.close();
			}
			
			
			result.addHeader("xml", retorno.toString());
			
		} catch (Exception e) {
			log.severe(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void failed(Exception ex) {
		
	}

	@Override
	public void cancelled() {
		
	}

}
