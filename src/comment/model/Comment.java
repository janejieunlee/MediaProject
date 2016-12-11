package comment.model;

public class Comment {
	private Integer number;
	private String writer;
	private String subject;
	private String content;
	private double grade;

	public Comment(Integer number, String writer, String subject, String content, double grade) {
		this.number = number;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.grade = grade;
	}

	public Integer getNumber() {
		return number;
	}

	public String getWriter() {
		return writer;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public double getGrade() {
		return grade;
	}
}
