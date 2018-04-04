package com.example.webmagic.service;

import com.example.webmagic.entity.CrawlerKCookbook;
import com.example.webmagic.repository.CrawlerKCookbookRepository;
import com.example.webmagic.spider.MeiShiChinaPerser;
import com.example.webmagic.util.DownloadPic;
import com.example.webmagic.util.PinYinUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**  
* @Title: MeiShiChinaService
* @Package com.example.webmagic.service
* @Description: ${todo}(用一句话描述该文件做什么)
* @author 尹欣
* @date 2018/4/3 10:35
* @version V1.0 
**/

@Slf4j
@Component
public class MeiShiChinaService {

    @Autowired
   private CrawlerKCookbookRepository crawlerKCookbookRepository;

    public void excute(){
        log.info("任务开始");
        getUrl();
        excute();
    }


    private static Integer page = 93;
    public void getUrl(){
        log.info("开始爬取第------"+page+"页");
        List<String> urls = MeiShiChinaPerser.getUrls();
        for (String url : urls) {
            if (page > 1) {
                if (url.contains("html")) {
                    url ="http:"+ url.replace(".html", "") + "-page-" + page + ".html";
                } else {
                    url ="http:"+ url + "page/" + page + "/";
                }
            }
            try{
                saveAndParse(url);

            }catch (Exception e){
                continue;
            }

        }
        page++;
    }



    public void saveAndParse(String url){
        log.info("列表url ----"+url);
        List<CrawlerKCookbook> crawlerKCookbookList = MeiShiChinaPerser.getParse(url);
        if(crawlerKCookbookList!= null && crawlerKCookbookList.size() >0) {
            for (CrawlerKCookbook crawlerKCookbook : crawlerKCookbookList) {
                CrawlerKCookbook one = crawlerKCookbookRepository.findByURL(crawlerKCookbook.getURL());
                if (one == null) {
                    crawlerKCookbook.setKCBP(PinYinUtil.getPingYin(crawlerKCookbook.getKCBNAME()));
                    log.info("保存的url-----"+crawlerKCookbook.getURL());

                    try {
                        CrawlerKCookbook save = crawlerKCookbookRepository.save(crawlerKCookbook);
                        String kcbimg = crawlerKCookbook.getKCBIMG();
                        String filePath = "E:\\食谱图片\\美食天下\\" + crawlerKCookbook.getKCBNAME() + "\\";
                        DownloadPic.download(kcbimg, crawlerKCookbook.getKCBNAME(), filePath);
                        log.info("图片下载成功！！！");
                    } catch (Exception e) {
                        log.error("出现异常--------保存失败");
                    }

                        log.info("数据保存成功");

                } else {
                    log.info("数据重复");
                }
            }

        }
    }
}
