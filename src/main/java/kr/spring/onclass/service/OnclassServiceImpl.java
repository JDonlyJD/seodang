package kr.spring.onclass.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.spring.onclass.dao.OnclassMapper;
import kr.spring.onclass.vo.OnclassVO;

@Service
@Transactional
public class OnclassServiceImpl implements OnclassService{
	
	@Autowired
	OnclassMapper onclassMapper;
	
	@Override
	public void insertOnclass(OnclassVO onclass) {
		// TODO Auto-generated method stub
		onclassMapper.insertOnclass(onclass);
	}

	@Override
	public int getOnclassCount() {
		// TODO Auto-generated method stub
		return onclassMapper.getOnclassCount();
	}

	@Override
	public List<OnclassVO> getOnclassList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return onclassMapper.getOnclassList(map);
	}

	@Override
	public OnclassVO getOnclass(int num) {
		// TODO Auto-generated method stub
		return onclassMapper.getOnclass(num);
	}

	@Override
	public void updateOnclass(OnclassVO onclass) {
		// TODO Auto-generated method stub
		onclassMapper.updateOnclass(onclass);
	}

	@Override
	public void deleteOnclass(int num) {
		// TODO Auto-generated method stub
		onclassMapper.deleteOnclass(num);
	}

}
