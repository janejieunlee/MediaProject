package comment.service;

public class WriteRequest {
	private String writer;
	private String subject;
	private String content;
	private double grade;
	
	public WriteRequest(String writer, String subject, String content, double grade) {
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.grade = grade;
	}
	
	public String getWrtier() {
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
