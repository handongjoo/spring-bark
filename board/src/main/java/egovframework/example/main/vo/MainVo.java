package egovframework.example.main.vo;

public class MainVo {
	private int board_id;
	private String title;
	private String content;
	private String author;
	private String imageFile;
	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String filePath) {
		this.imageFile = filePath;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	private int visiting;
	private String createdAt;
	
	public int getBoard_id() {
		return board_id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}


	public int getVisiting() {
		return visiting;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setVisiting(int visiting) {
		this.visiting = visiting;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
