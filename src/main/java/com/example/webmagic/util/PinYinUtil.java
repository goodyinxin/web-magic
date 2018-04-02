package com.example.webmagic.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtil {
    /**
     * 汉字转拼音
     * @param str
     * @return
     */
    public static String getPingYin(String str) {

        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        char[] input = str.trim().toCharArray();
        String outPut = "";
        try {
            for (int i = 0; i < input.length; i++) {
                if (Character.toString(input[i]).matches(("[\\u4E00-\\u9FA5]+"))) {
                    String[] temp = new String[0];
                    temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);

                    outPut += temp[0];
                } else
                    outPut += Character.toString(input[i]);
            }

        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
        return outPut;

    }


    public static void main(String[] args) {
        String str = "你好！世界！！wewewew";
        String pingYin = getPingYin(str);
        System.out.println(pingYin);
    }
}
