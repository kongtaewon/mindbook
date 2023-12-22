package kr.co.dong.mindbook;

import java.util.List;
import java.util.Map;

public interface MdService {

	
	public Map login(Map<String, Object> map);
	
	public int signup(MdDTO mdDTO);
	
	public int idcheck(MdDTO mdDTO);
	
	public List<MdDTO> getCalendar(int user_uid);
	
	public int insert(MdDTO mdDTO); 
	
	public int delete(int CALENDAR_NO);
	
	
}
