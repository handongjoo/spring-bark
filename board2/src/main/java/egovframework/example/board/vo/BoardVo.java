package egovframework.example.board.vo;

public class BoardVo {

	private int boardId;
	private String title;
	private String content;
	private String userId;
	
	public int getBoardId() {
		return boardId;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getUserId() {
		return userId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
