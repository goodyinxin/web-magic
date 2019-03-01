package com.example.webmagic.spider;

import com.example.webmagic.core.CrawlerCore;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 尹欣
 * @version V1.0
 * @Title: XinShiPuParser
 * @Package com.example.webmagic.spider
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2018/4/8 10:33
 **/
public class XinShiPuParser {

   static String con = "<li> <a href=\"/zuofadaquan/428/\" rel=\"cpdq\"> 猪肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/622/\" rel=\"cpdq\"> 排骨 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8061/\" rel=\"cpdq\"> 猪蹄 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/432/\" rel=\"cpdq\"> 猪肚 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/301/\" rel=\"cpdq\"> 猪排 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/431/\" rel=\"cpdq\"> 猪肝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/3060/\" rel=\"cpdq\"> 猪骨 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6842/\" rel=\"cpdq\"> 猪腰 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8063/\" rel=\"cpdq\"> 猪脑 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/123/\" rel=\"cpdq\"> 里脊 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/254/\" rel=\"cpdq\"> 猪头 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/468/\" rel=\"cpdq\"> 猪血 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8431/\" rel=\"cpdq\"> 大排 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/279/\" rel=\"cpdq\"> 猪心 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/392/\" rel=\"cpdq\"> 猪皮 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8067/\" rel=\"cpdq\"> 肘子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1897/\" rel=\"cpdq\"> 肉松 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8410/\" rel=\"cpdq\"> 肥肠 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/157/\" rel=\"cpdq\"> 腰花 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/13/\" rel=\"cpdq\"> 肉皮 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1512/\" rel=\"cpdq\"> 猪大肠 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/87/\" rel=\"cpdq\"> 火腿 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/981/\" rel=\"cpdq\"> 培根 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8066/\" rel=\"cpdq\"> 猪耳朵 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8325/\" rel=\"cpdq\"> 腊肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1008/\" rel=\"cpdq\"> 香肠 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8057/\" rel=\"cpdq\"> 猪尾巴 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4837/\" rel=\"cpdq\"> 猪油 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/763/\" rel=\"cpdq\"> 瘦肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1161/\" rel=\"cpdq\"> 五花肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/435/\" rel=\"cpdq\"> 猪肺 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/563/\" rel=\"cpdq\"> 叉烧 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6588/\" rel=\"cpdq\"> 火腿肠 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1896/\" rel=\"cpdq\"> 肉末 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/122/\" rel=\"cpdq\"> 腊肠 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1593/\" rel=\"cpdq\"> 午餐肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/217/\" rel=\"cpdq\"> 熏肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1813/\" rel=\"cpdq\"> 肉丸 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/710/\" rel=\"cpdq\"> 咸肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/319/\" rel=\"cpdq\"> 牛肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8268/\" rel=\"cpdq\"> 牛排 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8039/\" rel=\"cpdq\"> 牛仔骨 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/292/\" rel=\"cpdq\"> 牛筋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/175/\" rel=\"cpdq\"> 牛尾 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8272/\" rel=\"cpdq\"> 牛百叶 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/215/\" rel=\"cpdq\"> 牛杂 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/10/\" rel=\"cpdq\"> 肥牛 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/327/\" rel=\"cpdq\"> 牛腩 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/320/\" rel=\"cpdq\"> 牛肚 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8189/\" rel=\"cpdq\"> 兔肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8302/\" rel=\"cpdq\"> 驴肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8304/\" rel=\"cpdq\"> 鹿肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8587/\" rel=\"cpdq\"> 鹅肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1586/\" rel=\"cpdq\"> 鹅肝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1585/\" rel=\"cpdq\"> 鹅肠 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1417/\" rel=\"cpdq\"> 鹅掌 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8362/\" rel=\"cpdq\"> 鸡翅 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5559/\" rel=\"cpdq\"> 鸡胸 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1563/\" rel=\"cpdq\"> 鸡腿 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1482/\" rel=\"cpdq\"> 鸡爪 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8354/\" rel=\"cpdq\"> 鸡胗 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1553/\" rel=\"cpdq\"> 鸡肝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8356/\" rel=\"cpdq\"> 鸡心 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1552/\" rel=\"cpdq\"> 鸡肠 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8355/\" rel=\"cpdq\"> 鸡杂 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/465/\" rel=\"cpdq\"> 公鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1706/\" rel=\"cpdq\"> 小鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5849/\" rel=\"cpdq\"> 仔鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/73/\" rel=\"cpdq\"> 乌鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8104/\" rel=\"cpdq\"> 野鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7587/\" rel=\"cpdq\"> 火鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1554/\" rel=\"cpdq\"> 鸡肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8190/\" rel=\"cpdq\"> 土鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6955/\" rel=\"cpdq\"> 柴鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8239/\" rel=\"cpdq\"> 三黄鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/948/\" rel=\"cpdq\"> 童子鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6339/\" rel=\"cpdq\"> 老母鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8112/\" rel=\"cpdq\"> 羊肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8114/\" rel=\"cpdq\"> 羊排 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1877/\" rel=\"cpdq\"> 羊腿 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1375/\" rel=\"cpdq\"> 羊蝎子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6728/\" rel=\"cpdq\"> 牛奶 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1122/\" rel=\"cpdq\"> 奶油 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8278/\" rel=\"cpdq\"> 奶酪 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5874/\" rel=\"cpdq\"> 芝士 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7186/\" rel=\"cpdq\"> 酸奶 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5515/\" rel=\"cpdq\"> 黄油 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8279/\" rel=\"cpdq\"> 奶粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1884/\" rel=\"cpdq\"> 炼乳 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2647/\" rel=\"cpdq\"> 酥油 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1662/\" rel=\"cpdq\"> 淡奶油 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4326/\" rel=\"cpdq\"> 奶油奶酪 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1567/\" rel=\"cpdq\"> 鸭肝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8124/\" rel=\"cpdq\"> 鸭肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1365/\" rel=\"cpdq\"> 鸭头 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5736/\" rel=\"cpdq\"> 鸭脖 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2919/\" rel=\"cpdq\"> 鸭掌 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5766/\" rel=\"cpdq\"> 鸭腿 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1566/\" rel=\"cpdq\"> 鸭肠 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1560/\" rel=\"cpdq\"> 鸭翅 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/239/\" rel=\"cpdq\"> 野鸭 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/85/\" rel=\"cpdq\"> 老鸭 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1612/\" rel=\"cpdq\"> 鸭血 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1569/\" rel=\"cpdq\"> 鸭胗 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1572/\" rel=\"cpdq\"> 鸭舌 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1458/\" rel=\"cpdq\"> 鲤鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/500/\" rel=\"cpdq\"> 草鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8175/\" rel=\"cpdq\"> 武昌鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1462/\" rel=\"cpdq\"> 鲫鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8305/\" rel=\"cpdq\"> 鲈鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8264/\" rel=\"cpdq\"> 胖头鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8273/\" rel=\"cpdq\"> 鲶鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1785/\" rel=\"cpdq\"> 黑鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/911/\" rel=\"cpdq\"> 罗非鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8292/\" rel=\"cpdq\"> 鳗鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8313/\" rel=\"cpdq\"> 鲢鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8250/\" rel=\"cpdq\"> 青鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1103/\" rel=\"cpdq\"> 桂鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8098/\" rel=\"cpdq\"> 银鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1475/\" rel=\"cpdq\"> 鲷鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1467/\" rel=\"cpdq\"> 鲮鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8584/\" rel=\"cpdq\"> 鲟鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1507/\" rel=\"cpdq\"> 鳟鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8177/\" rel=\"cpdq\"> 乌鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6794/\" rel=\"cpdq\"> 柴鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4237/\" rel=\"cpdq\"> 鳊鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8420/\" rel=\"cpdq\"> 刀鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1505/\" rel=\"cpdq\"> 鳜鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1502/\" rel=\"cpdq\"> 鳙鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1469/\" rel=\"cpdq\"> 鲳鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8385/\" rel=\"cpdq\"> 海鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8425/\" rel=\"cpdq\"> 带鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1779/\" rel=\"cpdq\"> 黄鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8238/\" rel=\"cpdq\"> 三文鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8130/\" rel=\"cpdq\"> 鳕鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1431/\" rel=\"cpdq\"> 鲅鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8343/\" rel=\"cpdq\"> 金枪鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1441/\" rel=\"cpdq\"> 鲑鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8233/\" rel=\"cpdq\"> 鲨鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8128/\" rel=\"cpdq\"> 鸦片鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1658/\" rel=\"cpdq\"> 沙丁鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/417/\" rel=\"cpdq\"> 黄花鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6836/\" rel=\"cpdq\"> 虱目鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6683/\" rel=\"cpdq\"> 石斑鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8891/\" rel=\"cpdq\"> 银雪鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8138/\" rel=\"cpdq\"> 小黄鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1671/\" rel=\"cpdq\"> 秋刀鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8455/\" rel=\"cpdq\"> 比目鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8308/\" rel=\"cpdq\"> 龙利鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6328/\" rel=\"cpdq\"> 多宝鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6978/\" rel=\"cpdq\"> 多春鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/9034/\" rel=\"cpdq\"> 大马哈鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1210/\" rel=\"cpdq\"> 鱼排 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8088/\" rel=\"cpdq\"> 鱼片 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1416/\" rel=\"cpdq\"> 鱼骨 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1118/\" rel=\"cpdq\"> 鱼丸 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8089/\" rel=\"cpdq\"> 鱼皮 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8155/\" rel=\"cpdq\"> 咸鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1160/\" rel=\"cpdq\"> 鱼头 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8083/\" rel=\"cpdq\"> 鱼子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6826/\" rel=\"cpdq\"> 木鱼花 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1314/\" rel=\"cpdq\"> 鱼肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1189/\" rel=\"cpdq\"> 鱼干 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1599/\" rel=\"cpdq\"> 鸡蛋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1606/\" rel=\"cpdq\"> 鸭蛋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8470/\" rel=\"cpdq\"> 鹌鹑蛋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/854/\" rel=\"cpdq\"> 皮蛋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/734/\" rel=\"cpdq\"> 咸蛋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1639/\" rel=\"cpdq\"> 咸鸭蛋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/885/\" rel=\"cpdq\"> 蛋黄 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/702/\" rel=\"cpdq\"> 蛋清 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8411/\" rel=\"cpdq\"> 鹅蛋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1480/\" rel=\"cpdq\"> 毛蟹 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1739/\" rel=\"cpdq\"> 海蟹 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1234/\" rel=\"cpdq\"> 大闸蟹 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/877/\" rel=\"cpdq\"> 螃蟹 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/912/\" rel=\"cpdq\"> 蟹肉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/534/\" rel=\"cpdq\"> 梭子蟹 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/997/\" rel=\"cpdq\"> 蟹黄 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8379/\" rel=\"cpdq\"> 河蟹 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/299/\" rel=\"cpdq\"> 珍宝蟹 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7333/\" rel=\"cpdq\"> 田螺 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1750/\" rel=\"cpdq\"> 泥鳅 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8365/\" rel=\"cpdq\"> 黄鳝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/757/\" rel=\"cpdq\"> 甲鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1504/\" rel=\"cpdq\"> 鳝鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/356/\" rel=\"cpdq\"> 牛蛙 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/762/\" rel=\"cpdq\"> 田鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/695/\" rel=\"cpdq\"> 螺丝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8394/\" rel=\"cpdq\"> 海参 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8096/\" rel=\"cpdq\"> 鱿鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6113/\" rel=\"cpdq\"> 紫菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7809/\" rel=\"cpdq\"> 章鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1217/\" rel=\"cpdq\"> 墨鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8570/\" rel=\"cpdq\"> 海蜇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1737/\" rel=\"cpdq\"> 海螺 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1529/\" rel=\"cpdq\"> 海带 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1446/\" rel=\"cpdq\"> 海兔 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1729/\" rel=\"cpdq\"> 海藻 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1697/\" rel=\"cpdq\"> 海胆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/18/\" rel=\"cpdq\"> 乌贼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5216/\" rel=\"cpdq\"> 裙带菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1708/\" rel=\"cpdq\"> 海苔 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7135/\" rel=\"cpdq\"> 螺蛳 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/225/\" rel=\"cpdq\"> 燕窝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/3791/\" rel=\"cpdq\"> 花胶 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/3112/\" rel=\"cpdq\"> 雪蛤 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6736/\" rel=\"cpdq\"> 阿胶 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1798/\" rel=\"cpdq\"> 人参 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5612/\" rel=\"cpdq\"> 首乌 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1313/\" rel=\"cpdq\"> 鱼肚 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/941/\" rel=\"cpdq\"> 虫草花 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/826/\" rel=\"cpdq\"> 白菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8253/\" rel=\"cpdq\"> 芹菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1807/\" rel=\"cpdq\"> 油麦菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5834/\" rel=\"cpdq\"> 韭菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1359/\" rel=\"cpdq\"> 豆芽 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1407/\" rel=\"cpdq\"> 圆白菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1607/\" rel=\"cpdq\"> 油菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8151/\" rel=\"cpdq\"> 香菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/421/\" rel=\"cpdq\"> 小白菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/475/\" rel=\"cpdq\"> 菠菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/658/\" rel=\"cpdq\"> 生菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1171/\" rel=\"cpdq\"> 娃娃菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/260/\" rel=\"cpdq\"> 芦笋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8206/\" rel=\"cpdq\"> 蒜苗 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1395/\" rel=\"cpdq\"> 大白菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8193/\" rel=\"cpdq\"> 茼蒿 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1362/\" rel=\"cpdq\"> 豆苗 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6448/\" rel=\"cpdq\"> 卷心菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4385/\" rel=\"cpdq\"> 苋菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/302/\" rel=\"cpdq\"> 芥菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8052/\" rel=\"cpdq\"> 紫甘蓝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/797/\" rel=\"cpdq\"> 青菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5781/\" rel=\"cpdq\"> 西芹 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1997/\" rel=\"cpdq\"> 马齿苋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8205/\" rel=\"cpdq\"> 蒜苔 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4009/\" rel=\"cpdq\"> 芥蓝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1816/\" rel=\"cpdq\"> 西洋菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/799/\" rel=\"cpdq\"> 青蒜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4446/\" rel=\"cpdq\"> 牛至 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8185/\" rel=\"cpdq\"> 豌豆苗 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/309/\" rel=\"cpdq\"> 菜心 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8341/\" rel=\"cpdq\"> 韭黄 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2843/\" rel=\"cpdq\"> 芝麻菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4010/\" rel=\"cpdq\"> 芦蒿 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/107/\" rel=\"cpdq\"> 芥兰 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5623/\" rel=\"cpdq\"> 马兰头 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5996/\" rel=\"cpdq\"> 紫苏 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/659/\" rel=\"cpdq\"> 甘蓝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1876/\" rel=\"cpdq\"> 穿心莲 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5189/\" rel=\"cpdq\"> 桂花 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2174/\" rel=\"cpdq\"> 香椿 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/983/\" rel=\"cpdq\"> 菊花菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8957/\" rel=\"cpdq\"> 塔菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/628/\" rel=\"cpdq\"> 蕨菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/177/\" rel=\"cpdq\"> 橄榄菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8256/\" rel=\"cpdq\"> 荠菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1524/\" rel=\"cpdq\"> 鱼腥草 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8590/\" rel=\"cpdq\"> 水芹菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2705/\" rel=\"cpdq\"> 花生 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7158/\" rel=\"cpdq\"> 枸杞 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2740/\" rel=\"cpdq\"> 葡萄干 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/416/\" rel=\"cpdq\"> 芝麻 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/774/\" rel=\"cpdq\"> 杏仁 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6653/\" rel=\"cpdq\"> 蔓越莓 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/262/\" rel=\"cpdq\"> 莲子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/908/\" rel=\"cpdq\"> 桂圆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1678/\" rel=\"cpdq\"> 鹰嘴豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/704/\" rel=\"cpdq\"> 白果 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8568/\" rel=\"cpdq\"> 麦芽 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/3001/\" rel=\"cpdq\"> 罗汉果 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/875/\" rel=\"cpdq\"> 板栗 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1860/\" rel=\"cpdq\"> 绿豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4427/\" rel=\"cpdq\"> 南瓜子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1730/\" rel=\"cpdq\"> 黑豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1720/\" rel=\"cpdq\"> 黄豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8108/\" rel=\"cpdq\"> 腰果 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4993/\" rel=\"cpdq\"> 芸豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/801/\" rel=\"cpdq\"> 蚕豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1824/\" rel=\"cpdq\"> 红豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1720/\" rel=\"cpdq\"> 黄豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/906/\" rel=\"cpdq\"> 栗子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/425/\" rel=\"cpdq\"> 银杏 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/140/\" rel=\"cpdq\"> 芡实 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4189/\" rel=\"cpdq\"> 话梅 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2579/\" rel=\"cpdq\"> 核桃 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/860/\" rel=\"cpdq\"> 蜜豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8214/\" rel=\"cpdq\"> 松仁 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5268/\" rel=\"cpdq\"> 乌梅 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/9063/\" rel=\"cpdq\"> 桃胶 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2640/\" rel=\"cpdq\"> 橄榄 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8072/\" rel=\"cpdq\"> 榛子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7123/\" rel=\"cpdq\"> 眉豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5262/\" rel=\"cpdq\"> 松子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1352/\" rel=\"cpdq\"> 豆腐 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1272/\" rel=\"cpdq\"> 豆浆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/581/\" rel=\"cpdq\"> 豆腐干 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8413/\" rel=\"cpdq\"> 豆皮 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1278/\" rel=\"cpdq\"> 豆渣 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/696/\" rel=\"cpdq\"> 豆腐脑 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2398/\" rel=\"cpdq\"> 素鸡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/108/\" rel=\"cpdq\"> 腐竹 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1535/\" rel=\"cpdq\"> 油豆腐 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1227/\" rel=\"cpdq\"> 豆干 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/914/\" rel=\"cpdq\"> 香干 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1094/\" rel=\"cpdq\"> 臭豆腐 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1772/\" rel=\"cpdq\"> 内酯豆腐 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8417/\" rel=\"cpdq\"> 冻豆腐 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8245/\" rel=\"cpdq\"> 日本豆腐 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/647/\" rel=\"cpdq\"> 豆腐皮 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1376/\" rel=\"cpdq\"> 鸽子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1741/\" rel=\"cpdq\"> 鹌鹑 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8429/\" rel=\"cpdq\"> 大虾 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/570/\" rel=\"cpdq\"> 虾仁 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1295/\" rel=\"cpdq\"> 小龙虾 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/722/\" rel=\"cpdq\"> 虾米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1575/\" rel=\"cpdq\"> 对虾 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1175/\" rel=\"cpdq\"> 基围虾 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1791/\" rel=\"cpdq\"> 龙虾 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5148/\" rel=\"cpdq\"> 明虾 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/919/\" rel=\"cpdq\"> 北极虾 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8170/\" rel=\"cpdq\"> 虾皮 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8168/\" rel=\"cpdq\"> 虾子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/396/\" rel=\"cpdq\"> 皮皮虾 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8387/\" rel=\"cpdq\"> 海虾 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/612/\" rel=\"cpdq\"> 虾干 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1682/\" rel=\"cpdq\"> 海米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/406/\" rel=\"cpdq\"> 草虾 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8230/\" rel=\"cpdq\"> 扇贝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/361/\" rel=\"cpdq\"> 牡蛎 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4616/\" rel=\"cpdq\"> 蛤蜊 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7746/\" rel=\"cpdq\"> 干贝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8424/\" rel=\"cpdq\"> 带子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/499/\" rel=\"cpdq\"> 瑶柱 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8153/\" rel=\"cpdq\"> 蚬子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/245/\" rel=\"cpdq\"> 花甲 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/668/\" rel=\"cpdq\"> 生蚝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8381/\" rel=\"cpdq\"> 河蚌 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6352/\" rel=\"cpdq\"> 蛏子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1437/\" rel=\"cpdq\"> 鲍鱼 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/3569/\" rel=\"cpdq\"> 文蛤 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8164/\" rel=\"cpdq\"> 鲜贝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/610/\" rel=\"cpdq\"> 青口 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/930/\" rel=\"cpdq\"> 北极贝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1006/\" rel=\"cpdq\"> 土豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8231/\" rel=\"cpdq\"> 山药 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1020/\" rel=\"cpdq\"> 白萝卜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1656/\" rel=\"cpdq\"> 洋葱 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/347/\" rel=\"cpdq\"> 牛蒡 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8369/\" rel=\"cpdq\"> 胡萝卜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1796/\" rel=\"cpdq\"> 红薯 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8284/\" rel=\"cpdq\"> 魔芋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6872/\" rel=\"cpdq\"> 雪里蕻 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1178/\" rel=\"cpdq\"> 榨菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8315/\" rel=\"cpdq\"> 芋头 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1912/\" rel=\"cpdq\"> 大头菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1240/\" rel=\"cpdq\"> 竹笋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/409/\" rel=\"cpdq\"> 莴笋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1794/\" rel=\"cpdq\"> 花椰菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/315/\" rel=\"cpdq\"> 茭白 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4703/\" rel=\"cpdq\"> 牛蒂 </a> </li>\n" +
            "<li> <a href=\"/jiachangzuofa/82024/\" rel=\"cpdq\"> 心里美 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1603/\" rel=\"cpdq\"> 紫薯 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/444/\" rel=\"cpdq\"> 莴苣 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4936/\" rel=\"cpdq\"> 青萝卜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2032/\" rel=\"cpdq\"> 马蹄 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/278/\" rel=\"cpdq\"> 芋艿 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/946/\" rel=\"cpdq\"> 地瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/285/\" rel=\"cpdq\"> 萝卜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/638/\" rel=\"cpdq\"> 百合 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4310/\" rel=\"cpdq\"> 春笋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/514/\" rel=\"cpdq\"> 菱角 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8581/\" rel=\"cpdq\"> 慈姑 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8419/\" rel=\"cpdq\"> 冬笋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/412/\" rel=\"cpdq\"> 荸荠 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1596/\" rel=\"cpdq\"> 淮山 </a> </li>\n" +
            "<li> <a href=\"/caipu/8474/\" rel=\"cpdq\"> 藕 </a> </li>\n" +
            "<li> <a href=\"/caipu/8491/\" rel=\"cpdq\"> 笋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8254/\" rel=\"cpdq\"> 茄子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8251/\" rel=\"cpdq\"> 青椒 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/524/\" rel=\"cpdq\"> 西兰花 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/466/\" rel=\"cpdq\"> 菜花 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1380/\" rel=\"cpdq\"> 豆角 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1821/\" rel=\"cpdq\"> 西红柿 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1399/\" rel=\"cpdq\"> 豌豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6703/\" rel=\"cpdq\"> 扁豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1568/\" rel=\"cpdq\"> 四季豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1393/\" rel=\"cpdq\"> 豇豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4075/\" rel=\"cpdq\"> 花菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8378/\" rel=\"cpdq\"> 荷兰豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1756/\" rel=\"cpdq\"> 辣椒 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7570/\" rel=\"cpdq\"> 番茄 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4088/\" rel=\"cpdq\"> 黄花菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1892/\" rel=\"cpdq\"> 彩椒 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1132/\" rel=\"cpdq\"> 秋葵 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4119/\" rel=\"cpdq\"> 圣女果 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7518/\" rel=\"cpdq\"> 刀豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4866/\" rel=\"cpdq\"> 青豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/660/\" rel=\"cpdq\"> 西葫芦 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4520/\" rel=\"cpdq\"> 毛豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4536/\" rel=\"cpdq\"> 瓠瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2257/\" rel=\"cpdq\"> 玉米笋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8275/\" rel=\"cpdq\"> 南瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1608/\" rel=\"cpdq\"> 黄瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4221/\" rel=\"cpdq\"> 冬瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/266/\" rel=\"cpdq\"> 苦瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1853/\" rel=\"cpdq\"> 丝瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1915/\" rel=\"cpdq\"> 佛手 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2141/\" rel=\"cpdq\"> 节瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/730/\" rel=\"cpdq\"> 青瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1031/\" rel=\"cpdq\"> 角瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8148/\" rel=\"cpdq\"> 香菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/698/\" rel=\"cpdq\"> 蘑菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1583/\" rel=\"cpdq\"> 茶树菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8260/\" rel=\"cpdq\"> 平菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8698/\" rel=\"cpdq\"> 口菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8370/\" rel=\"cpdq\"> 猴头菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5634/\" rel=\"cpdq\"> 竹荪 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5828/\" rel=\"cpdq\"> 草菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8342/\" rel=\"cpdq\"> 金针菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/386/\" rel=\"cpdq\"> 冬菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8333/\" rel=\"cpdq\"> 口蘑 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8132/\" rel=\"cpdq\"> 杏鲍菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8048/\" rel=\"cpdq\"> 银耳 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5888/\" rel=\"cpdq\"> 发菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1434/\" rel=\"cpdq\"> 滑子菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8213/\" rel=\"cpdq\"> 松茸 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/559/\" rel=\"cpdq\"> 琼脂 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1055/\" rel=\"cpdq\"> 黑木耳 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1182/\" rel=\"cpdq\"> 榛蘑 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4043/\" rel=\"cpdq\"> 花菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1734/\" rel=\"cpdq\"> 白木耳 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1043/\" rel=\"cpdq\"> 蟹味菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8358/\" rel=\"cpdq\"> 鸡腿菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1165/\" rel=\"cpdq\"> 白玉菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8027/\" rel=\"cpdq\"> 双孢菇 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/580/\" rel=\"cpdq\"> 姬松茸 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/928/\" rel=\"cpdq\"> 木耳 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/388/\" rel=\"cpdq\"> 冬菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4216/\" rel=\"cpdq\"> 芽菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8/\" rel=\"cpdq\"> 玉兰片 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/97/\" rel=\"cpdq\"> 酸菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1628/\" rel=\"cpdq\"> 泡菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/378/\" rel=\"cpdq\"> 萝卜干 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2371/\" rel=\"cpdq\"> 笋干 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2500/\" rel=\"cpdq\"> 咸菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/3323/\" rel=\"cpdq\"> 梅干菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1832/\" rel=\"cpdq\"> 纳豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4202/\" rel=\"cpdq\"> 酸笋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4800/\" rel=\"cpdq\"> 酸豇豆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8349/\" rel=\"cpdq\"> 酱菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/40/\" rel=\"cpdq\"> 辣白菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/618/\" rel=\"cpdq\"> 薏米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/775/\" rel=\"cpdq\"> 面粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1241/\" rel=\"cpdq\"> 玉米面 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1649/\" rel=\"cpdq\"> 黑米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/693/\" rel=\"cpdq\"> 面条 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/894/\" rel=\"cpdq\"> 荞麦面 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/888/\" rel=\"cpdq\"> 馒头 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/876/\" rel=\"cpdq\"> 白面 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/77/\" rel=\"cpdq\"> 方便面 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8274/\" rel=\"cpdq\"> 年糕 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/313/\" rel=\"cpdq\"> 意面 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/952/\" rel=\"cpdq\"> 通心粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1105/\" rel=\"cpdq\"> 高粱 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1277/\" rel=\"cpdq\"> 大麦 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7411/\" rel=\"cpdq\"> 燕麦片 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/385/\" rel=\"cpdq\"> 燕麦 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/879/\" rel=\"cpdq\"> 饺子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4243/\" rel=\"cpdq\"> 高粱米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1440/\" rel=\"cpdq\"> 油条 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1253/\" rel=\"cpdq\"> 粉丝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1136/\" rel=\"cpdq\"> 粘米粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/371/\" rel=\"cpdq\"> 凉粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1420/\" rel=\"cpdq\"> 米粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2855/\" rel=\"cpdq\"> 糯米粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1343/\" rel=\"cpdq\"> 粉条 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2952/\" rel=\"cpdq\"> 粉皮 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1833/\" rel=\"cpdq\"> 蕨根粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/464/\" rel=\"cpdq\"> 玉米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1147/\" rel=\"cpdq\"> 大米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2954/\" rel=\"cpdq\"> 全麦粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2346/\" rel=\"cpdq\"> 小麦 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8266/\" rel=\"cpdq\"> 糯米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/269/\" rel=\"cpdq\"> 红曲米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5201/\" rel=\"cpdq\"> 西米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1537/\" rel=\"cpdq\"> 小米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/387/\" rel=\"cpdq\"> 乌冬面 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/349/\" rel=\"cpdq\"> 凉皮 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1433/\" rel=\"cpdq\"> 米线 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1500/\" rel=\"cpdq\"> 糙米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1589/\" rel=\"cpdq\"> 米饭 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2870/\" rel=\"cpdq\"> 烤麸 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8201/\" rel=\"cpdq\"> 汤圆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1550/\" rel=\"cpdq\"> 河粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/654/\" rel=\"cpdq\"> 藕粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5369/\" rel=\"cpdq\"> 紫米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8034/\" rel=\"cpdq\"> 黄米 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4182/\" rel=\"cpdq\"> 澄面 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/385/\" rel=\"cpdq\"> 燕麦 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6882/\" rel=\"cpdq\"> 小麦胚芽 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/766/\" rel=\"cpdq\"> 面筋 </a> </li>\n" +
            "<li> <a href=\"/jiachangzuofa/263/\" rel=\"cpdq\"> 低筋面粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/525/\" rel=\"cpdq\"> 荞麦 </a> </li>\n" +
            "<li> <a href=\"/jiachangzuofa/664/\" rel=\"cpdq\"> 高筋面粉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/526/\" rel=\"cpdq\"> 莜面 </a> </li>\n" +
            "<li> <a href=\"/jiachangzuofa/58887/\" rel=\"cpdq\"> 粤菜 </a> </li>\n" +
            "<li> <a href=\"/jiachangzuofa/43000/\" rel=\"cpdq\"> 川菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1818/\" rel=\"cpdq\"> 湘菜 </a> </li>\n" +
            "<li> <a href=\"/caipu/112108/\" rel=\"cpdq\"> 东北菜 </a> </li>\n" +
            "<li> <a href=\"/caipu/113739/\" rel=\"cpdq\"> 上海菜 </a> </li>\n" +
            "<li> <a href=\"/caipu/112875/\" rel=\"cpdq\"> 清真菜 </a> </li>\n" +
            "<li> <a href=\"/caipu/112880/\" rel=\"cpdq\"> 湖北菜 </a> </li>\n" +
            "<li> <a href=\"/caipu/112873/\" rel=\"cpdq\"> 云南菜 </a> </li>\n" +
            "<li> <a href=\"/s/b9f3d6ddb2cb/\" rel=\"cpdq\"> 贵州菜 </a> </li>\n" +
            "<li> <a href=\"/caipu/112030/\" rel=\"cpdq\"> 新疆菜 </a> </li>\n" +
            "<li> <a href=\"/jiachangzuofa/17511/\" rel=\"cpdq\"> 韩国菜 </a> </li>\n" +
            "<li> <a href=\"/caipu/112867/\" rel=\"cpdq\"> 泰国菜 </a> </li>\n" +
            "<li> <a href=\"/jiachangzuofa/81129/\" rel=\"cpdq\"> 法国菜 </a> </li>\n" +
            "<li> <a href=\"/caipu/112726/\" rel=\"cpdq\"> 鲁菜 </a> </li>\n" +
            "<li> <a href=\"/caipu/113752/\" rel=\"cpdq\"> 日本料理 </a> </li>\n" +
            "<li> <a href=\"/jiachangzuofa/111632/\" rel=\"cpdq\"> 意大利菜 </a> </li>\n" +
            "<li> <a href=\"/jiachangzuofa/81160/\" rel=\"cpdq\"> 墨西哥菜 </a> </li>\n" +
            "<li> <a href=\"/caipu/112164/\" rel=\"cpdq\"> 麻辣 </a> </li>\n" +
            "<li> <a href=\"/jiachangzuofa/68967/\" rel=\"cpdq\"> 糖醋 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8337/\" rel=\"cpdq\"> 咖喱 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1411/\" rel=\"cpdq\"> 鱼香 </a> </li>\n" +
            "<li> <a href=\"/caipu/112161/\" rel=\"cpdq\"> 香辣 </a> </li>\n" +
            "<li> <a href=\"/caipu/112162/\" rel=\"cpdq\"> 酸辣 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1302/\" rel=\"cpdq\"> 豆瓣 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8372/\" rel=\"cpdq\"> 红油 </a> </li>\n" +
            "<li> <a href=\"/caipu/112191/\" rel=\"cpdq\"> 拔丝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/624/\" rel=\"cpdq\"> 陈皮 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7401/\" rel=\"cpdq\"> 芥末 </a> </li>\n" +
            "<li> <a href=\"/caipu/112216/\" rel=\"cpdq\"> 酸甜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1394/\" rel=\"cpdq\"> 豆豉 </a> </li>\n" +
            "<li> <a href=\"/caipu/114186/\" rel=\"cpdq\"> 卤菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4625/\" rel=\"cpdq\"> 烧烤 </a> </li>\n" +
            "<li> <a href=\"/caipu/112204/\" rel=\"cpdq\"> 干锅 </a> </li>\n" +
            "<li> <a href=\"/caipu/112230/\" rel=\"cpdq\"> 红烧 </a> </li>\n" +
            "<li> <a href=\"/jiachangzuofa/112007/\" rel=\"cpdq\"> 蒸菜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7905/\" rel=\"cpdq\"> 柠檬 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8451/\" rel=\"cpdq\"> 菠萝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6518/\" rel=\"cpdq\"> 石榴 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4169/\" rel=\"cpdq\"> 椰子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8147/\" rel=\"cpdq\"> 香蕉 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/179/\" rel=\"cpdq\"> 芒果 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/544/\" rel=\"cpdq\"> 葡萄 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/228/\" rel=\"cpdq\"> 苹果 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1185/\" rel=\"cpdq\"> 榴莲 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/397/\" rel=\"cpdq\"> 草莓 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4371/\" rel=\"cpdq\"> 蓝莓 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/8281/\" rel=\"cpdq\"> 木瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/908/\" rel=\"cpdq\"> 桂圆 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/871/\" rel=\"cpdq\"> 柚子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1010/\" rel=\"cpdq\"> 西瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5110/\" rel=\"cpdq\"> 黄桃 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2316/\" rel=\"cpdq\"> 樱桃 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/925/\" rel=\"cpdq\"> 桔子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7610/\" rel=\"cpdq\"> 青梅 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4447/\" rel=\"cpdq\"> 山楂 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4740/\" rel=\"cpdq\"> 李子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/3634/\" rel=\"cpdq\"> 金橘 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/3259/\" rel=\"cpdq\"> 荔枝 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/4749/\" rel=\"cpdq\"> 杏子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/3224/\" rel=\"cpdq\"> 香瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6311/\" rel=\"cpdq\"> 杨梅 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/5494/\" rel=\"cpdq\"> 桑葚 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6282/\" rel=\"cpdq\"> 杨桃 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6817/\" rel=\"cpdq\"> 柿子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6570/\" rel=\"cpdq\"> 枇杷 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/2628/\" rel=\"cpdq\"> 梨子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1102/\" rel=\"cpdq\"> 橙子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7612/\" rel=\"cpdq\"> 桃子 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/6787/\" rel=\"cpdq\"> 甘蔗 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/344/\" rel=\"cpdq\"> 猕猴桃 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/800/\" rel=\"cpdq\"> 牛油果 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/1679/\" rel=\"cpdq\"> 火龙果 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/3925/\" rel=\"cpdq\"> 哈密瓜 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/3549/\" rel=\"cpdq\"> 百香果 </a> </li>\n" +
            "<li> <a href=\"/zuofadaquan/7946/\" rel=\"cpdq\"> 覆盆子 </a> </li>";


      private static String host = "https://www.xinshipu.com";

   /* public static void main(String[] args) {
        //String url = "https://www.xinshipu.com/%E8%8F%9C%E8%B0%B1%E5%A4%A7%E5%85%A8.html";
        Map<String,String> map = new HashMap<>();
        Document parse = Jsoup.parse(con);
        Elements a = parse.select("a");
        for (Element element : a) {
            String href =host + element.attr("href");
            String text = element.text();
            map.put(text,href);
        }
        System.out.println(map);
    }*/



  /* public static void main(String[] args){
       String url = "https://www.xinshipu.com/zuofadaquan/1567/";
       String html = CrawlerCore.getHtml(url);
       Document parse = Jsoup.parse(html);
       Element element = parse.select("div[class=new-menu-list search-menu-list clearfix mt10]").first();
       Elements select = element.select("div[class=new-menu mt20]");
       for (Element element1 : select) {
           String attr = element1.select("a").attr("href");
           String href = host + attr;
           System.out.println(href);
       }

   }*/


  public static void main(String[] args){
     String url = "https://www.xinshipu.com/zuofa/427949";
      String html = CrawlerCore.getHtml(url);
      Document parse = Jsoup.parse(html);
      String attr = parse.select("div[class=gallery]").select("a").select("img").attr("src");
      System.out.println(attr);
      Elements script = parse.select("script");
      Element last = script.last();
      System.out.println(last);
     /* for (Element element : script) {
          System.out.println(element);
      }*/


  }

}
