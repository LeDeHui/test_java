package com.JDBC.day02;

public class Student {

	// 流水号
	private int FLOWID;
	// 考试的类型
	private int TYPE;
	// 身份证号
	private String IDCARD;
	// 准考证号
	private String EXAMCARD;
	// 学生名
	private String STUDENRNAME;
	// 学生地址
	private String LOCALHOST;
	// 考试分数.
	private int GRADE; 
	
	public Student(int flowId, int type, String idCard, String examCard, String studentName, String location,
			int grade) {
		super();
		this.FLOWID = flowId;
		this.TYPE = type;
		this.IDCARD = idCard;
		this.EXAMCARD = examCard;
		this.STUDENRNAME = studentName;
		this.LOCALHOST = location;
		this.GRADE = grade;
	}
	public Student() {
		super();
	}
	public int getFlowId() {
		return FLOWID;
	}
	public void setFlowId(int flowId) {
		this.FLOWID = flowId;
	}
	public int getType() {
		return TYPE;
	}
	public void setType(int type) {
		this.TYPE = type;
	}
	public String getIdCard() {
		return IDCARD;
	}
	public void setIdCard(String idCard) {
		this.IDCARD = idCard;
	}
	public String getExamCard() {
		return EXAMCARD;
	}
	public void setExamCard(String examCard) {
		this.EXAMCARD = examCard;
	}
	public String getStudentName() {
		return STUDENRNAME;
	}
	public void setStudentName(String studentName) {
		this.STUDENRNAME = studentName;
	}
	public String getLocation() {
		return LOCALHOST;
	}
	public void setLocation(String location) {
		this.LOCALHOST = location;
	}
	public int getGrade() {
		return GRADE;
	}
	public void setGrade(int grade) {
		this.GRADE = grade;
	}
	@Override
	public String toString() {
		return "Student [FLOWID=" + FLOWID + ", TYPE=" + TYPE + ", IDCARD=" + IDCARD + ", EXAMCARD=" + EXAMCARD
				+ ", STUDENRNAME=" + STUDENRNAME + ", LOCALHOST=" + LOCALHOST + ", GRADE=" + GRADE + "]";
	}
	
	
}
