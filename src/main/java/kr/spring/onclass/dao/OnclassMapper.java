package kr.spring.onclass.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;

import kr.spring.onclass.vo.OnclassVO;

@MapperScan
public interface OnclassMapper {
	public void insertOnclass(OnclassVO onclass);
	@Select("select count(*) from onclass")
	public int getOnclassCount();
	public List<OnclassVO> getOnclassList(Map<String,Object> map);
	public OnclassVO getOnclass(int num);
	public void updateOnclass(OnclassVO onclass);
	public void deleteOnclass(int num);
}
