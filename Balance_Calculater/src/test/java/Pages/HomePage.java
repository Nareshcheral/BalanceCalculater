package Pages;

import org.openqa.selenium.By;

import Utils.utility_values;

public class HomePage extends utility_values {

	By txt_lbl_val_1=By.id("txt_val_1");
	By txt_lbl_val_2=By.id("txt_val_2");
	By txt_lbl_val_3=By.id("txt_val_3");
	By txt_lbl_val_4=By.id("txt_val_4");
	By txt_lbl_val_5=By.id("txt_val_5");
	By txt_lbl_ttl_val=By.id("txt_ttl_val");
	By txt_ttl_values=By.xpath("//input[starts-with(@id,'txt_val_')");
	String value_xpath="//input[starts-with(@id,'txt_val_')";
	public By getTxt_lbl_val_1() {
		return txt_lbl_val_1;
	}
	public void setTxt_lbl_val_1(By txt_lbl_val_1) {
		this.txt_lbl_val_1 = txt_lbl_val_1;
	}
	public By getTxt_lbl_val_2() {
		return txt_lbl_val_2;
	}
	public void setTxt_lbl_val_2(By txt_lbl_val_2) {
		this.txt_lbl_val_2 = txt_lbl_val_2;
	}
	public By getTxt_lbl_val_3() {
		return txt_lbl_val_3;
	}
	public void setTxt_lbl_val_3(By txt_lbl_val_3) {
		this.txt_lbl_val_3 = txt_lbl_val_3;
	}
	public By getTxt_lbl_val_4() {
		return txt_lbl_val_4;
	}
	public void setTxt_lbl_val_4(By txt_lbl_val_4) {
		this.txt_lbl_val_4 = txt_lbl_val_4;
	}
	public By getTxt_lbl_val_5() {
		return txt_lbl_val_5;
	}
	public void setTxt_lbl_val_5(By txt_lbl_val_5) {
		this.txt_lbl_val_5 = txt_lbl_val_5;
	}
	public By getTxt_lbl_ttl_val() {
		return txt_lbl_ttl_val;
	}
	public void setTxt_lbl_ttl_val(By txt_lbl_ttl_val) {
		this.txt_lbl_ttl_val = txt_lbl_ttl_val;
	}
	public By getTxt_ttl_values() {
		return txt_ttl_values;
	}
	public void setTxt_ttl_values(By txt_ttl_values) {
		this.txt_ttl_values = txt_ttl_values;
	}
	public String getValue_xpath() {
		return value_xpath;
	}
	public void setValue_xpath(String value_xpath) {
		this.value_xpath = value_xpath;
	}
}
