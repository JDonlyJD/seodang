package kr.spring.onclass.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;

import kr.spring.onclass.vo.OnclassVO;

public interface OnclassMapper {
	public List<OnclassVO> selectList(Map<String,Object> map);
	@Insert("insert into onclass (on_num, user_num,on_name,on_price,on_content,uploadfile,filename) "
			+ "values(onclass_seq.nextval,#{user_num},#{on_name},#{on_content},#{on_price},#{uploadfile},#{filename})")
	public void insertOnclass(OnclassVO onclassVO);
	@Select("select count(*) from onclass")
	public int getOnclassCount();
	public List<OnclassVO> getOnclassList(Map<String,Object> map);
	@Select("select * from onclass where user_num = #{num}")
	public OnclassVO getOnclass(int num);
	@Update("update onclass set on_name=#{on_name},on_price=#{on_price},on_content=#{on_content} where user_num=#{num}")
	public void updateOnclass(OnclassVO onclass);
	public void deleteOnclass(int num);
}
