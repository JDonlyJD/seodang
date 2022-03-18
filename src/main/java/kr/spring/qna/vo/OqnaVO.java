package kr.spring.qna.vo;

import java.io.IOException;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class OqnaVO {	//전체 게시판
	private int qna_num;
	private int user_num;
	private String title;
	private String content;
	private Date reg_date;
	private Date modify_date;
	
	private MultipartFile upload;	//파일업로드시 parameter로 넘어오는 부분 
	private byte[] uploadfile;		//파일(byte배열로 처리하기 위한)
	private String filename;		//파일명
	
	
	//* 업로드 파일 처리하는 setter (파일upload By.blob타입)
	public void setUpload(MultipartFile upload)throws IOException {	//getBytes()사용시 IOException
		this.upload = upload;
		
		setUploadfile(upload.getBytes());

		setFilename(upload.getOriginalFilename());
	}	
	
	
	//* toString()재정의
	@Override
	public String toString() {
		return "OqnaVO [qna_num=" + qna_num + ", user_num=" + user_num + ", title=" + title + ", content=" + content
				+ ", reg_date=" + reg_date + ", modify_date=" + modify_date + ", upload=" + upload + ", filename="
				+ filename + "]";
	}	
	
	
	public int getQna_num() {
		return qna_num;
	}
	public void setQna_num(int qna_num) {
		this.qna_num = qna_num;
	}
	public int getUser_num() {
		return user_num;
	}
	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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

	public byte[] getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(byte[] uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}