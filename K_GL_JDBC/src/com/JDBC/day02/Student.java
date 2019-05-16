package com.JDBC.day02;

public class Student {

	// 流水号
	private int flowid;
	// 考试的类型
	private int type;
	// 身份证号
	private String idcard;
	// 准考证号
	private String examcard;
	// 学生名
	private String strdenrname;
	// 学生地址
	private String localhost;
	// 考试分数.
	private int geade;
	
	public Student() {
		super();
	}

	public Student(int flowid, int type, String idcard, String examcard, String strdenrname, String localhost,
			int geade) {
		super();
		this.flowid = flowid;
		this.type = type;
		this.idcard = idcard;
		this.examcard = examcard;
		this.strdenrname = strdenrname;
		this.localhost = localhost;
		this.geade = geade;
	}

	public int getFlowid() {
		return flowid;
	}

	public void setFlowid(int flowid) {
		this.flowid = flowid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getExamcard() {
		return examcard;
	}

	public void setExamcard(String examcard) {
		this.examcard = examcard;
	}

	public String getStrdenrname() {
		return strdenrname;
	}

	public void setStrdenrname(String strdenrname) {
		this.strdenrname = strdenrname;
	}

	public String getLocalhost() {
		return localhost;
	}

	public void setLocalhost(String localhost) {
		this.localhost = localhost;
	}

	public int getGrand() {
		return geade;
	}

	public void setGrand(int geade) {
		this.geade = geade;
	}

	@Override
	public String toString() {
		return "Student [flowid=" + flowid + ", type=" + type + ", idcard=" + idcard + ", examcard=" + examcard
				+ ", strdenrname=" + strdenrname + ", localhost=" + localhost + ", geade=" + geade + "]";
	} 
	 
	
	
}
