package com.example.webmagic.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 尹欣
 * @version V1.0
 * @Title: $Class$
 * @Package $package_name$
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date $date$ $time$
 **/
public class DownloadPic {

    public static String uploadQianURL(String fileUrl,String fileName) {
        //获取文件名，文件名实际上在URL中可以找到
        //String fileName = fileUrl.substring(fileUrl.lastIndexOf("/"), fileUrl.indexOf("?")) + ".jpg";
        //这里服务器上要将此图保存的路径
        String savePath = "E:\\食谱图片\\"+fileName+"\\";
        try {
            URL url = new URL(fileUrl);/*将网络资源地址传给,即赋值给url*/
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            DataInputStream in = new DataInputStream(connection.getInputStream());
            File file =new File(savePath);
            DataOutputStream out = new DataOutputStream(new FileOutputStream(savePath+fileName+ ".jpg"));

            /*将参数savePath，即将截取的图片的存储在本地地址赋值给out输出流所指定的地址*/
            byte[] buffer = new byte[4096];
            int count = 0;
            /*将输入流以字节的形式读取并写入buffer中*/
            while ((count = in.read(buffer)) > 0) {
                out.write(buffer, 0, count);
            }
            out.close();/*后面三行为关闭输入输出流以及网络资源的固定格式*/
            in.close();
            connection.disconnect();
            //返回内容是保存后的完整的URL
            //return PATH+UPLOAD_PATH+fileName;/*网络资源截取并存储本地成功返回true*/
            return "";
        } catch (Exception e) {
            System.out.println(e + fileUrl + savePath);
            return null;
        }
    }



    public static void download(String urlString, String filename,String savePath) throws Exception {
        URL url = new URL(urlString);
        URLConnection con = url.openConnection();
        con.setConnectTimeout(5*1000);
        InputStream is = con.getInputStream();
        byte[] bs = new byte[1024];
        int len;
        File sf=new File(savePath);
        if(!sf.exists()){
            sf.mkdirs();
        }
        String str = urlString.substring(urlString.lastIndexOf("."));
        if(str.contains("jpg")){
            str =".jpg";
        }
        OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename+str);
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        os.close();
        is.close();
    }



    public static void main(String[] args){
        String url ="http://s1.ttmeishi.com/caipu/200709/12/f0031ee653015f9aa14bb80cab7f7423.jpg";
        //uploadQianURL(url,"tupian");
        String fileName ="fileName";
        String savePath = "E:\\食谱图片\\"+fileName+"\\";
        try {
            download(url,fileName,savePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
