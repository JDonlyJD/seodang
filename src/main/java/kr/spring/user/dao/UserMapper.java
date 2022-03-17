package kr.spring.user.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.spring.user.vo.UserVO;

public interface UserMapper {
	//사용자
	@Select("SELECT ouser_seq.nextval FROM dual")
	public int selectUser_num();
	@Insert("INSERT INTO ouser (user_num,id,auth) VALUES (#{user_num},#{id},#{auth})")
	public void insertUser(UserVO user);
	@Insert("INSERT INTO ouser_detail(user_num,name,age,passwd,phone,email,zipcode,address1,address2) VALUES (#{user_num},#{name},#{age},#{passwd},#{phone},#{email},#{zipcode},#{address1},#{address2})")
	public void insertUser_detail(UserVO user);
	@Select("SELECT u.user_num,d.name,u.auth,d.passwd,d.photo FROM ouser u LEFT OUTER JOIN ouser_detail d ON u.user_num=d.user_num WHERE u.id=#{id}")
	public UserVO selectCheckUser(String id);
	public UserVO selectUser(Integer user_num);
	public void updateUser(UserVO user);
	public void updatePassword(UserVO user);
	public void deleteUser(Integer user_num);
	public void deleteUser_detail(Integer user_num);
	public void updateProfile(UserVO user);
}
