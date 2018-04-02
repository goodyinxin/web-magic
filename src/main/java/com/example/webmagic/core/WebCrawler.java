package com.example.webmagic.core;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.javascript.JavaScriptErrorListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class WebCrawler {
	
	private static final Logger log = LoggerFactory.getLogger(WebCrawler.class);
	
	private static WebClient webClient = null; 
	
	private int defaultPageTimeout = 20000; //ms
	
	private int defaultBackgroundJSTimeout = 5000;
	
	private boolean defaultJavaScriptEnabled = true;
	
	private static WebCrawler instance;
	
	public static WebCrawler getInstance() {
		if (instance == null) {
			synchronized (WebCrawler.class) {
				if (instance == null) {
					instance = new WebCrawler();
				}
			}
		}
		return instance;
	} 
	
	public WebClient getWebClient(int pageTimeout,int backgroundJSTimeout,boolean javaScriptEnabled) {
		//log.info("-------------getWebClient---------------");
		if (webClient == null) { 
			//log.info("-------------  new one---------------");
			webClient = new WebClient(BrowserVersion.FIREFOX_45);
			webClient.setRefreshHandler(new ThreadedRefreshHandler());
			webClient.getOptions().setCssEnabled(false);
			webClient.getOptions().setJavaScriptEnabled(javaScriptEnabled);
			webClient.getOptions().setThrowExceptionOnScriptError(false);
			webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
			webClient.getOptions().setRedirectEnabled(true);
			webClient.getOptions().setTimeout(pageTimeout);    
			webClient.waitForBackgroundJavaScript(backgroundJSTimeout);  
			webClient.setAjaxController(new NicelyResynchronizingAjaxController()); 
			webClient.getOptions().setUseInsecureSSL(true); //
			//webClient.getJavaScriptEngine().getContextFactory().enterContext().setOptimizationLevel(9);
			webClient.setAlertHandler(new AlertHandler() {

				@Override
				public void handleAlert(Page arg0, String arg1) {
					// TODO Auto-generated method stub
					
				}
				 
			});
			webClient.setJavaScriptErrorListener(new JavaScriptErrorListener() { 
				
				public void loadScriptError(InteractivePage arg0, URL arg1, Exception arg2) {
					// TODO Auto-generated method stub
					
				}

				public void malformedScriptURL(InteractivePage arg0, String arg1, MalformedURLException arg2) {
					// TODO Auto-generated method stub
					
				}

				public void scriptException(InteractivePage arg0, ScriptException arg1) {
					// TODO Auto-generated method stub
					
				}

				public void timeoutError(InteractivePage arg0, long arg1, long arg2) {
					// TODO Auto-generated method stub
					
				}
			}); 
		} 
		
		return webClient;
	}
	
	public WebClient getWebClient() { 
		return getWebClient(defaultPageTimeout,defaultBackgroundJSTimeout,defaultJavaScriptEnabled);
	}
	
	public WebClient getWebClient(int pageTimeout){
		return getWebClient(pageTimeout,defaultBackgroundJSTimeout,defaultJavaScriptEnabled);
	}
	
	public WebClient getWebClient(int pageTimeout,int backgroundJSTimeout){
		return getWebClient(pageTimeout,backgroundJSTimeout,defaultJavaScriptEnabled);
	}
	
	public WebClient getWebClient(boolean javaScriptEnabled){
		return getWebClient(defaultPageTimeout,defaultBackgroundJSTimeout,javaScriptEnabled);
	}
	

}
