package egovframework.example.main.vo;

public class CommentVo {
	
	private int comment_id;
	private String author;
	private String c_content;
	private String c_createdAt;
	private int board_id;
	
	public int getComment_id() {
		return comment_id;
	}
	public String getAuthor() {
		return author;
	}
	public String getC_content() {
		return c_content;
	}
	public String getC_createdAt() {
		return c_createdAt;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public void setC_createdAt(String c_createdAt) {
		this.c_createdAt = c_createdAt;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	
}
