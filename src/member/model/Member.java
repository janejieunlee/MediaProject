package member.model;

public class Member {
	private String id;
	private String name;
	// private String picture; //
	private String email; //
	private String phoneNumber;//
	private double grade; //
	private String password;
	private String introduction;

	public Member(String id, String name, /* String picture, */String email, String phoneNumber, double grade,
			String password, String introduction) {
		this.id = id;
		this.name = name;
		// this.picture = picture;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.grade = grade;
		this.password = password;
		this.introduction = introduction;

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// public String getPicture(){
	// return picture;
	// }

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public double getGrade() {
		return grade;
	}

	public String getPassword() {
		return password;
	}

	public String getIntroduction() {
		return introduction;
	}

	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.password = newPwd;
	}

	public void changeEmail(String newEmail) {
		this.email = newEmail;
	}

	public void changePhoneNumber(String newPhoneNumber) {
		this.phoneNumber = newPhoneNumber;
	}

	public void changeIntroduction(String newIntroduction) {
		this.introduction = newIntroduction;
	}

}
