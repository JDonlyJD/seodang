package kr.spring.onclass.vo;

import java.io.IOException;
import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class OnclassVO {
	private int on_num;
	private int user_num;
	private String on_name;
	private int on_price;
	private String on_image;
	private String on_content;
	private String on_filename;
	private byte[] on_uploadfile;
	private Date reg_date;
	private Date modify_date;
	private MultipartFile upload;
	
	//MultipartFile 바이트변환 , 파일처리 및 파일명 저장 .
	public void setOn_uploadfile(MultipartFile upload)throws IOException{
		this.upload = upload;
		setOn_uploadfile(upload.getBytes());
		setOn_filename(upload.getOriginalFilename());
	}

	public int getOn_num() {
		return on_num;
	}

	public void setOn_num(int on_num) {
		this.on_num = on_num;
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public String getOn_name() {
		return on_name;
	}

	public void setOn_name(String on_name) {
		this.on_name = on_name;
	}

	public int getOn_price() {
		return on_price;
	}

	public void setOn_price(int on_price) {
		this.on_price = on_price;
	}

	public String getOn_image() {
		return on_image;
	}

	public void setOn_image(String on_image) {
		this.on_image = on_image;
	}

	public String getOn_content() {
		return on_content;
	}

	public void setOn_content(String on_content) {
		this.on_content = on_content;
	}

	public String getOn_filename() {
		return on_filename;
	}

	public void setOn_filename(String on_filename) {
		this.on_filename = on_filename;
	}

	public byte[] getOn_uploadfile() {
		return on_uploadfile;
	}

	public void setOn_uploadfile(byte[] on_uploadfile) {
		this.on_uploadfile = on_uploadfile;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
	
}
