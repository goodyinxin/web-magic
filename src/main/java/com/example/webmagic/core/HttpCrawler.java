package com.example.webmagic.core;

import com.gargoylesoftware.htmlunit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpCrawler {
	
	private static final Logger log = LoggerFactory.getLogger(HttpCrawler.class);
	
	private static WebClient webClient = null; 
	
	private int defaultPageTimeout = 20000; //ms
	
	private int defaultBackgroundJSTimeout = 5000;
	
	private boolean defaultJavaScriptEnabled = true;
	
	private static HttpCrawler instance;
	
	public static HttpCrawler getInstance() {
		if (instance == null) {
			synchronized (HttpCrawler.class) {
				if (instance == null) {
					instance = new HttpCrawler();
				}
			}
		}
		return instance;
	}
	
	public HttpCrawler(){
		log.info("-------------getWebClient---------------");
		if (webClient == null) { 
			log.info("-------------new one---------------");
			webClient = new WebClient(BrowserVersion.CHROME);
			webClient.setRefreshHandler(new ThreadedRefreshHandler());
			webClient.getOptions().setCssEnabled(false);
			webClient.getOptions().setJavaScriptEnabled(defaultJavaScriptEnabled);
			webClient.getOptions().setThrowExceptionOnScriptError(false);
			webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
			webClient.getOptions().setRedirectEnabled(true);
			webClient.getOptions().setTimeout(defaultPageTimeout);    
			webClient.waitForBackgroundJavaScript(defaultBackgroundJSTimeout);  
			webClient.setAjaxController(new NicelyResynchronizingAjaxController()); 
			webClient.getOptions().setUseInsecureSSL(true); 
		}
	}
	
	public WebClient getWebClient(){
		return webClient;
	}
	
	public HttpCrawler setJavaScriptEnabled(boolean bool){
		webClient.getOptions().setJavaScriptEnabled(bool);
		return this;
	}
	
	public HttpCrawler setPageTimeout(int pageTimeout){
		webClient.getOptions().setTimeout(pageTimeout);
		return this;
	}
	
	public HttpCrawler waitForBackgroundJavaScript(int backgroundJSTimeout){
		webClient.waitForBackgroundJavaScript(backgroundJSTimeout);
		return this;
	}
	
	public HttpCrawler setProxyConfig(String proxyHost,int proxyPort){
		ProxyConfig proxyConfig = new ProxyConfig(proxyHost, proxyPort);
		webClient.getOptions().setProxyConfig(proxyConfig);
		return this;
	}
	
	
	
	

}
