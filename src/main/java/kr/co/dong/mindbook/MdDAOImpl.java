package kr.co.dong.mindbook;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MdDAOImpl implements MdDAO{

	@Inject
	private SqlSession sqlSession;

	private static final String namespace="kr.co.dong.mdMapper";
	
	@Override
	public Map login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".login",map);
	}

	@Override
	public int signup(MdDTO mdDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".uinsert", mdDTO);
	}

	@Override
	public int idcheck(MdDTO mdDTO) {
		// TODO Auto-generated method stub
		int result =sqlSession.selectOne(namespace+".idcheck", mdDTO);
		return result;
	}

	

	@Override
	public int insert(MdDTO mdDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".insert",mdDTO);
	}

	

	@Override
	public List<MdDTO> getCalendar(int user_uid) {
		// TODO Auto-generated method stub
		
		List<MdDTO> calendar=null;
		calendar = sqlSession.selectList(namespace+".calendarList",user_uid);
		return calendar;
	}

	@Override
	public int delete(int CALENDAR_NO) {
		// TODO Auto-generated method stub
		return sqlSession.delete(namespace+".delete",CALENDAR_NO);
	}

	
	
}
