package com.atguigu.jdbc;

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
	private String STUDENTNAME;
	// 学生地址
	private String LOCATION;
	// 考试分数.
	private int GRADE;
	public Student(int flowId, int type, String idCard, String examCard, String studentName, String location,
			int grade) {
		super();
		this.FLOWID = flowId;
		this.TYPE = type;
		this.IDCARD = idCard;
		this.EXAMCARD = examCard;
		this.STUDENTNAME = studentName;
		this.LOCATION = location;
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
		return STUDENTNAME;
	}
	public void setStudentName(String studentName) {
		this.STUDENTNAME = studentName;
	}
	public String getLocation() {
		return LOCATION;
	}
	public void setLocation(String location) {
		this.LOCATION = location;
	}
	public int getGrade() {
		return GRADE;
	}
	public void setGrade(int grade) {
		this.GRADE = grade;
	}
	@Override
	public String toString() {
		return "Student [flowId=" + FLOWID + ", type=" + TYPE + ", idCard=" + IDCARD + ", examCard=" + EXAMCARD
				+ ", studentName=" + STUDENTNAME + ", location=" + LOCATION + ", grade=" + GRADE + "]";
	}
	
	
}
