package kr.co.dong.mindbook;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MdServiceImpl implements MdService{

	@Inject
	private MdDAO dao;
	@Override
	public Map login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.login(map);
	}
	@Override
	public int signup(MdDTO mdDTO) {
		// TODO Auto-generated method stub
		return dao.signup(mdDTO);
	}
	@Override
	public int idcheck(MdDTO mdDTO) {
		// TODO Auto-generated method stub
		int result=dao.idcheck(mdDTO);
		return result;
	}
	
	
	@Override
	public List<MdDTO> getCalendar(int user_uid) {
		// TODO Auto-generated method stub
		return dao.getCalendar(user_uid);
	}
	@Override
	public int insert(MdDTO mdDTO) {
		// TODO Auto-generated method stub
		return dao.insert(mdDTO);
	}
	@Override
	public int delete(int CALENDAR_NO) {
		// TODO Auto-generated method stub
		return dao.delete(CALENDAR_NO);
	}
	

}
