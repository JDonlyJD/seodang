package kr.spring.onclass.service;

import java.util.List;
import java.util.Map;

import kr.spring.onclass.vo.OnclassVO;

public interface OnclassService {
	public void insertOnclass(OnclassVO onclass);
	public int getOnclassCount();
	public List<OnclassVO> getOnclassList(Map<String,Object> map);
	public OnclassVO getOnclass(int num);
	public void updateOnclass(OnclassVO onclass);
	public void deleteOnclass(int num);
}
