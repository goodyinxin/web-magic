package com.example.webmagic.repository;

import com.example.webmagic.entity.CrawlerKCookbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
* @Title: CrawlerKCookbookRepository
* @Package com.example.webmagic.repository
* @Description: ${todo}(用一句话描述该文件做什么)
* @author 尹欣
* @date 2018/4/2 15:26
* @version V1.0 
**/
public interface CrawlerKCookbookRepository extends JpaRepository<CrawlerKCookbook,Integer>{

    @Query(value ="SELECT * FROM crawler_k_cookbook  where URL =?1",nativeQuery = true)
    CrawlerKCookbook findByURL(String url);

}
