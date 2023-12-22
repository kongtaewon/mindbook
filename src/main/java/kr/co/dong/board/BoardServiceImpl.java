package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	@Inject
	private BoardDAO boardDAO; 
	
	@Override
	public Map login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDAO.login(map);
	}

	@Override
	public List<BoardDTO> list() {
		// TODO Auto-generated method stub
		return boardDAO.list();
	}

	@Override
	public int updateReadCnt(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.updateReadCnt(bno);
	}

	@Override
	public BoardDTO getDetail(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.getDetail(bno);
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return boardDAO.delete(bno);
	}

	@Override
	public int register(BoardDTO boardDTO) {
		// TODO Auto-generated method stub
		return boardDAO.register(boardDTO);
	}
	@Override
	public int update(BoardDTO dto) {
		// TODO Auto-generated method stub
		return boardDAO.update(dto);
	}

}
