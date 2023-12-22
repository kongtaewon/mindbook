package kr.co.dong.mindbook;

import java.util.List;
import java.util.Map;






public interface MdDAO {

	
	// 로그인!
	public Map login(Map<String,Object> map);
	//회원가입
	public int signup(MdDTO mdDTO);
	//아이디 중복
	public int idcheck(MdDTO mdDTO);
	// 글정보(리스트에서 유저 아이디통해서 정보 가져오는것)
	public List<MdDTO> getCalendar(int user_uid);
	
	public int insert(MdDTO mdDTO); 
	
	public int delete(int CALENDAR_NO);
//	
//	public int update(MdDTO mdDTO);
//	
//	public MdDTO detail(int cal_no);
//	
//	public int delete(int cal_no);
	
	//일기쓰기
	
}
