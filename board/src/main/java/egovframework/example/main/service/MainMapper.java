package egovframework.example.main.service;

import java.util.List;

import egovframework.example.main.vo.CommentVo;
import egovframework.example.main.vo.MainVo;
import egovframework.example.main.vo.UserVo;

public interface MainMapper {
	public List<MainVo> selectList(MainVo mainVo);

	public void insertBoard(MainVo mainVo) throws Exception;
	
	public MainVo detailBoard(int board_id);

	public List<CommentVo> getComment(int board_id) throws Exception;

	public void insertComment(CommentVo commentVo);
	
	public UserVo findUserById(String author);

	public void updateBoard(MainVo mainVo);

	public void deleteBoard(int board_id);

	public void registerUser(UserVo userVo);
}
