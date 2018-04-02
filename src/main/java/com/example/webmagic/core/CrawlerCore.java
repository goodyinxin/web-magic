package com.example.webmagic.core;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CrawlerCore {
	
	private static final Logger log = LoggerFactory.getLogger(CrawlerCore.class);
	
	public static String getHtml(String url){
		WebClient webClient =  HttpCrawler.getInstance().setJavaScriptEnabled(false).setPageTimeout(20000).getWebClient();
		HtmlPage page;
		String html = null;
		try {
			page = webClient.getPage(url);
			int code = page.getWebResponse().getStatusCode();
			if(code == 200){
				html = page.asXml();				
			}
		} catch (FailingHttpStatusCodeException | IOException e) {
			log.info("获取页面出错！");
			e.printStackTrace();
		}
		return html;
	}
	
	
	public static String getHtml(String url,Map<String,String> map) throws Exception{
		String html = "";
		URL gsurl = new URL(url);
		WebRequest request = new WebRequest(gsurl, HttpMethod.POST);
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		for (Entry<String, String> entry : map.entrySet()) {  
			list.add(new NameValuePair(entry.getKey(), entry.getValue()));  
		}  
		request.setRequestParameters(list);
		request.setCharset("utf-8");
		WebClient webClient = WebCrawler.getInstance().getWebClient(30000);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setCssEnabled(false); 
		Page page = webClient.getPage(request);
		int code = page.getWebResponse().getStatusCode();
//		System.out.println(code);
		if(code == 200){
			html = page.getWebResponse().getContentAsString();				
		}
		return html;	
	}
	
	public static String getPage(String url) throws Exception{
		String html = "";
		URL gsurl = new URL(url);
		WebRequest request = new WebRequest(gsurl, HttpMethod.POST);
		request.setCharset("gbk");
		WebClient webClient = WebCrawler.getInstance().getWebClient(30000);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setCssEnabled(false); 
		Page page = webClient.getPage(request);
		int code = page.getWebResponse().getStatusCode();
//		System.out.println(code);
		if(code == 200){
			html = page.getWebResponse().getContentAsString();				
		}
		return html;	
	}
	
	
	
	public static String getDetail(String url) throws  IOException{
		
		String html = "";
		URL gsurl = new URL(url);
		WebRequest request = new WebRequest(gsurl, HttpMethod.POST);
		request.setCharset("utf-8");
		WebClient webClient = WebCrawler.getInstance().getWebClient(30000);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setCssEnabled(false); 
		Page page = webClient.getPage(request);
		int code = page.getWebResponse().getStatusCode();
//		System.out.println(code);
		if(code == 200){
			html = page.getWebResponse().getContentAsString();				
		}
		return html;	
	}
	
}
