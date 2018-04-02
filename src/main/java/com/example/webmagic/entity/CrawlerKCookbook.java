package com.example.webmagic.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 
 * 爬虫菜谱表，包含各种食材
 * 
 **/
@SuppressWarnings("serial")
@Entity
@Table(name="crawler_k_cookbook")
public class CrawlerKCookbook implements Serializable {

	/**唯一主键**/
	@Id
	@GeneratedValue
	 private Integer KCBID;

	/**菜谱唯一标识**/
	 private String KCBCODE;

	/**菜谱名称**/
	 private String KCBNAME;

	/**名称汉字全拼**/
	 private String KCBP;

	/**菜谱图片地址**/
	 private String KCBIMG;

	/**菜谱别名**/
	 private String KCBNICKNAME;

	/**口味**/
	 private String TASTE;

	/**特色**/
	 private String FEATURE;

	/**食谱分类**/
	 private String KTTYPE;

	/**工艺**/
	 private String TECHNICS;

	/**修改时间**/
	 private java.util.Date UPDTETIME;

	/**创建时间**/
	 private java.util.Date CREATETIME;

	/**步骤**/
	 private String STEP;

	/**详情内容**/
	 private String CONTENT;

     private String URL;

	private String FOODS;
	/*功效*/
	private String EFFECT;
    /*技巧*/
	private String SKILL;


	public String getEFFECT() {
		return EFFECT;
	}

	public void setEFFECT(String EFFECT) {
		this.EFFECT = EFFECT;
	}

	public String getSKILL() {
		return SKILL;
	}

	public void setSKILL(String SKILL) {
		this.SKILL = SKILL;
	}

	public String getFOODS() {
		return FOODS;
	}

	public void setFOODS(String FOODS) {
		this.FOODS = FOODS;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}

	private String SOURCE;

	public String getSOURCE() {
		return SOURCE;
	}

	public void setSOURCE(String SOURCE) {
		this.SOURCE = SOURCE;
	}

	public void setKCBID(Integer KCBID){
		this.KCBID = KCBID;
	}

	public Integer getKCBID(){
		return this.KCBID;
	}

	public void setKCBCODE(String KCBCODE){
		this.KCBCODE = KCBCODE;
	}

	public String getKCBCODE(){
		return this.KCBCODE;
	}

	public void setKCBNAME(String KCBNAME){
		this.KCBNAME = KCBNAME;
	}

	public String getKCBNAME(){
		return this.KCBNAME;
	}

	public void setKCBP(String KCBP){
		this.KCBP = KCBP;
	}

	public String getKCBP(){
		return this.KCBP;
	}

	public void setKCBIMG(String KCBIMG){
		this.KCBIMG = KCBIMG;
	}

	public String getKCBIMG(){
		return this.KCBIMG;
	}

	public void setKCBNICKNAME(String KCBNICKNAME){
		this.KCBNICKNAME = KCBNICKNAME;
	}

	public String getKCBNICKNAME(){
		return this.KCBNICKNAME;
	}

	public void setTASTE(String TASTE){
		this.TASTE = TASTE;
	}

	public String getTASTE(){
		return this.TASTE;
	}

	public void setFEATURE(String FEATURE){
		this.FEATURE = FEATURE;
	}

	public String getFEATURE(){
		return this.FEATURE;
	}

	public void setKTTYPE(String KTTYPE){
		this.KTTYPE = KTTYPE;
	}

	public String getKTTYPE(){
		return this.KTTYPE;
	}

	public void setTECHNICS(String TECHNICS){
		this.TECHNICS = TECHNICS;
	}

	public String getTECHNICS(){
		return this.TECHNICS;
	}

	public void setUPDTETIME(java.util.Date UPDTETIME){
		this.UPDTETIME = UPDTETIME;
	}

	public java.util.Date getUPDTETIME(){
		return this.UPDTETIME;
	}

	public void setCREATETIME(java.util.Date CREATETIME){
		this.CREATETIME = CREATETIME;
	}

	public java.util.Date getCREATETIME(){
		return this.CREATETIME;
	}

	public void setSTEP(String STEP){
		this.STEP = STEP;
	}

	public String getSTEP(){
		return this.STEP;
	}

	public void setCONTENT(String CONTENT){
		this.CONTENT = CONTENT;
	}

	public String getCONTENT(){
		return this.CONTENT;
	}

	@Override
	public String toString() {
		return "CrawlerKCookbook{" +
				"KCBID=" + KCBID +
				", KCBCODE='" + KCBCODE + '\'' +
				", KCBNAME='" + KCBNAME + '\'' +
				", KCBP='" + KCBP + '\'' +
				", KCBIMG='" + KCBIMG + '\'' +
				", KCBNICKNAME='" + KCBNICKNAME + '\'' +
				", TASTE='" + TASTE + '\'' +
				", FEATURE='" + FEATURE + '\'' +
				", KTTYPE='" + KTTYPE + '\'' +
				", TECHNICS='" + TECHNICS + '\'' +
				", UPDTETIME=" + UPDTETIME +
				", CREATETIME=" + CREATETIME +
				", STEP='" + STEP + '\'' +
				", CONTENT='" + CONTENT + '\'' +
				", URL='" + URL + '\'' +
				", FOODS='" + FOODS + '\'' +
				", EFFECT='" + EFFECT + '\'' +
				", SKILL='" + SKILL + '\'' +
				", SOURCE='" + SOURCE + '\'' +
				'}';
	}
}
