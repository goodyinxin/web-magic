package com.example.webmagic.spider;

import com.example.webmagic.core.CrawlerCore;
import com.example.webmagic.entity.CrawlerKCookbook;
import com.example.webmagic.util.GsonFactory;
import com.example.webmagic.util.Uuid;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 尹欣
 * @version V1.0
 * @Title: MeiShiChinaPerser
 * @Package com.lk.sydn.knowledge.perser
 * @Description: ${todo}(美食天下)
 * @date 2018/3/16 9:34
 **/

public class MeiShiChinaPerser {

    /*获取一级页面所有连接*/
    public static List<String> getUrls() {
        String url ="http://home.meishichina.com/recipe-type.html";
        String    html = CrawlerCore.getHtml(url);
        Document document = Jsoup.parse(html);
        Elements category = document.select("div[class=category_box mt20]").select("div[class=category_sub clear]").select("li");
       List<String> strList = new ArrayList<>();
        for (Element element : category) {
            String href = element.select("a").attr("href");
            strList.add(href);
           /* if(href.contains("view")){
                System.out.println(href);
            }*/

        }
      return strList;
    }


    /*解析一级页面*/
    public static List<com.example.webmagic.entity.CrawlerKCookbook> getParse(String url){
        List<CrawlerKCookbook> list = new ArrayList<>();
        String html = null;
        try {
            html = CrawlerCore.getHtml(url);
        }catch (Exception e){

        }
        if(html != null) {
            Document document = Jsoup.parse(html);
            Element j_list = document.getElementById("J_list");
            Elements li_a = j_list.select("li");
            for (Element element : li_a) {
                String href = element.select("a").attr("href");
                CrawlerKCookbook parseDeatil = getParseDeatil(href);
                list.add(parseDeatil);
            }
            return list;
        }
        return null;
    }


    /*二级页面解析*/
    public static CrawlerKCookbook getParseDeatil(String url) {
        //String url = "http://home.meishichina.com/recipe-362152.html";
        CrawlerKCookbook crawlerKCookbook = new CrawlerKCookbook();
        crawlerKCookbook.setSOURCE("美食天下");
        crawlerKCookbook.setURL(url);
        String html = CrawlerCore.getHtml(url);
        Document document = Jsoup.parse(html);
        Element first = document.select("div[class=space_left]").first();
        crawlerKCookbook.setKCBNAME(first.select("h1[class=recipe_De_title]").text());
        crawlerKCookbook.setKCBIMG(first.select("div[id=recipe_De_imgBox]").select("img").attr("src"));
        crawlerKCookbook.setFEATURE(first.select("blockquote").text());
        Element eles = first.select("div[class=recipeCategory_sub_R mt30 clear]").first();
        Elements li = eles.select("li");
        crawlerKCookbook.setTECHNICS(getCon(li, "工艺"));
        crawlerKCookbook.setTASTE(getCon(li,"口味"));
        crawlerKCookbook.setSTEP(first.select("div.recipeStep").text());
        Element a = first.select("div[class=recipeTip mt16]").last();
        Elements a1 = a.select("a");
        List<String> list = new ArrayList<>();
        for (Element element : a1) {
            list.add(element.ownText());
        }
        crawlerKCookbook.setKTTYPE(GsonFactory.getJson("TYPE",list));
        List<String> sb = new ArrayList<>();
        Elements bs =  first.select("fieldset").select("b");
        for (Element b : bs) {
            sb.add(b.text());
        }
        crawlerKCookbook.setFOODS(GsonFactory.getJson("FOODS", sb));
        crawlerKCookbook.setCONTENT(first.toString());
        crawlerKCookbook.setCREATETIME(new Date());
        crawlerKCookbook.setUPDTETIME(new Date());
        crawlerKCookbook.setKCBCODE(Uuid.getUUID());
        return crawlerKCookbook;
    }





    public static String getCon(Elements ele,String key){
        String value = "";
        if(ele !=null) {
            Element el = ele.select("span[class=category_s2]:contains("+key+")").first();
            if(el != null){
                value =  el.firstElementSibling().text();
            }
        }
        return value;
    }


    public static void main(String[] args){
        String url ="http://home.meishichina.com/recipe/yankecai/page/16/";
        String html = CrawlerCore.getHtml(url);
        Document document = Jsoup.parse(html);
        Element j_list = document.getElementById("J_list");
        Elements li_a = j_list.select("li");
        for (Element element : li_a) {
            String href = element.select("a").attr("href");
            System.out.println(href);
        }
    }
}
