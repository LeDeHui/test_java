package com.atguigu.jdbc;

public class Student {

	// ��ˮ��
	private int FLOWID;
	// ���Ե�����
	private int TYPE;
	// ���֤��
	private String IDCARD;
	// ׼��֤��
	private String EXAMCARD;
	// ѧ����
	private String STUDENTNAME;
	// ѧ����ַ
	private String LOCATION;
	// ���Է���.
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
