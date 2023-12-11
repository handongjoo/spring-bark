package egovframework.example.main.service;

import java.util.List;

import egovframework.example.main.vo.CommentVo;
import egovframework.example.main.vo.MainVo;
import egovframework.example.main.vo.UserVo;

public interface MainService {

	public List<MainVo> selectList(MainVo mainVo);
	
	// 게시글 작성
	public void insertBoard(MainVo mainVo) throws Exception;
	
	public MainVo detailBoard(int board_id) throws Exception;
	
	public List<CommentVo> getComment(int board_id) throws Exception;
	
	public void insertComment(CommentVo commentVo) throws Exception;

	public UserVo findUserById(String author);

	public void updateBoard(MainVo mainVo);

	public void deleteBoard(int board_id);

	public void registerUser(UserVo userVo);

}
