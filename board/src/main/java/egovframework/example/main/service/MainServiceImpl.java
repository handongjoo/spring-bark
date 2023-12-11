package egovframework.example.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import egovframework.example.main.dao.MainDao;
import egovframework.example.main.vo.CommentVo;
import egovframework.example.main.vo.MainVo;
import egovframework.example.main.vo.UserVo;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	private MainDao mainDao;
	
	@Override
	public List<MainVo> selectList(MainVo mainVo) {
		return mainDao.selectList(mainVo);
	}
	
	@Override
	public void insertBoard(MainVo mainVo) throws Exception {
		mainDao.insertBoard(mainVo);
	}

	@Override
	public MainVo detailBoard(int board_id) throws Exception {
		return mainDao.detailBoard(board_id);
	}

	@Override
	public List<CommentVo> getComment(int board_id) throws Exception {
		return mainDao.getComment(board_id);
	}

	@Override
	public void insertComment(CommentVo commentVo) throws Exception {
		mainDao.insertComment(commentVo);
		
	}

	@Override
	public UserVo findUserById(String author) {
		return mainDao.findUserById(author);
	}

	@Override
	public void updateBoard(MainVo mainVo) {
		mainDao.updateBoard(mainVo);
		
	}

	@Override
	public void deleteBoard(int board_id) {
		mainDao.deleteBoard(board_id);
		
	}

	@Override
	public void registerUser(UserVo userVo) {
		mainDao.registerUser(userVo);		
	}

}
