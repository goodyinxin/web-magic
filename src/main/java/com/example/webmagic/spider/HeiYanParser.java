package com.example.webmagic.spider;

import com.example.webmagic.core.CrawlerCore;
import com.example.webmagic.core.HttpCrawler;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 尹欣
 * @version V1.0
 * @Title: ${Class}
 * @Package ${package_name}
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date ${date} ${time}
 **/
@Slf4j
public class HeiYanParser {

    private static final String url = "http://www.heiyan.com/accounts/login?backUrl=http://www.heiyan.com/";

 /* public static void main(String[] args){

      String j = "<li class=\"\" id=\"chapter1948052\" createdate=\"2017-07-19 18:07:42\">\n" +
              "\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"time\">17-07-19</span>\n" +
              "\t\t\t\t\t\t\t\t\t\t\t\t\t<a href=\"http://www.heiyan.com/book/73738/1948052\" class=\"isvip name\">504 以我之真气，合天地之造化</a>\n" +
              "\t\t\t\t\t\t\t\t\t\t\t\t</li>";

      Document parse = Jsoup.parse(j);
      Element first = parse.select("a[class*=isvip]").first();
      System.out.println(first);

  }*/


  public static void main(String[] args) throws Exception {

        WebClient webClient = HttpCrawler.getInstance().setJavaScriptEnabled(true).waitForBackgroundJavaScript(10000).setPageTimeout(20000).getWebClient();
        HtmlPage page;
        page = webClient.getPage(url);

        int code = page.getWebResponse().getStatusCode();
        if(code == 200) {
            Thread.sleep(6000);
            //HtmlPage page = client.getPage(url);
            //System.out.println("====================" + page.asText());
            //登录

            HtmlInput  ln = (HtmlInput)page.getHtmlElementById("email");

            //ln.setValueAttribute("18107328480");
            ln.setValueAttribute("13102680350");
            HtmlInput  pwd = (HtmlInput)page.getHtmlElementById("password");
            //pwd.setValueAttribute("56844813");
            pwd.setValueAttribute("d25hour");
            HtmlElement btn = page.getFirstByXPath("//*[@id=\"form_login\"]/div[1]/input");
            HtmlPage page2 = btn.click();


            HtmlPage page3 = webClient.getPage("http://www.heiyan.com/book/73738");
           /* System.out.println(" : " + page3.asXml());
            Thread.sleep(3000);
            HtmlElement pushBtn =  page3.getFirstByXPath("//*[@id=\"voteStaff\"]/div[2]/a");
            HtmlPage click = pushBtn.click();
            System.out.println(click.asXml());*/

           /*小说章节列表*/
            HtmlElement munu =  page3.getFirstByXPath("//*[@id=\"voteList\"]/div[1]/a[1]");
            HtmlPage lib = munu.click();
            String lis = lib.asXml();
            Document document = Jsoup.parse(lis);
            Element ul = document.select("ul[class=float-list fill-block]").first();
            Elements li = ul.select("li");
            List<Element> collect = li.stream().skip(li.size() - 2).collect(Collectors.toList());
            for (Element element : collect) {

                String href = element.select("a[class*=isvip]").attr("href");
                HtmlPage pageInfo = webClient.getPage(href);
                Thread.sleep(3000);
                try {
                    HtmlElement buyBnt = pageInfo.getFirstByXPath("/html/body/div[6]/div/div/div[2]/form/ul/li[1]/a");
                    HtmlPage buy = buyBnt.click();
                    System.out.println(buy.asText());
                }catch (Exception e){
                    log.info("本章已购买!");
                }
            }

            webClient.close();
        }
    }




}
