package com.inbox.model;

public class InboxVO {
	private  String inbox_Mail_ID;
	private String member_ID;
	private String emp_ID;
	private String inbox_Mail_Info;
	private java.sql.Timestamp inbox_Mail_Date;
	private String inbox_Mail_Title;

	public String getInbox_Mail_Title() {
		return inbox_Mail_Title;
	}
	public void setInbox_Mail_Title(String inbox_Mail_Title) {
		this.inbox_Mail_Title = inbox_Mail_Title;
	}
	public String getInbox_Mail_ID() {
		return inbox_Mail_ID;
	}
	public void setInbox_Mail_ID(String inbox_Mail_ID) {
		this.inbox_Mail_ID = inbox_Mail_ID;
	}
	public String getMember_ID() {
		return member_ID;
	}
	public void setMember_ID(String member_ID) {
		this.member_ID = member_ID;
	}
	public String getEmp_ID() {
		return emp_ID;
	}
	public void setEmp_ID(String emp_ID) {
		this.emp_ID = emp_ID;
	}
	public String getInbox_Mail_Info() {
		return inbox_Mail_Info;
	}
	public void setInbox_Mail_Info(String inbox_Mail_Info) {
		this.inbox_Mail_Info = inbox_Mail_Info;
	}
	public java.sql.Timestamp getInbox_Mail_Date() {
		return inbox_Mail_Date;
	}
	public void setInbox_Mail_Date(java.sql.Timestamp inbox_Mail_Date) {
		this.inbox_Mail_Date = inbox_Mail_Date;
	}
	@Override
	public String toString() {
		return "InboxVO [inbox_Mail_ID=" + inbox_Mail_ID + ", member_ID=" + member_ID + ", emp_ID=" + emp_ID
				+ ", inbox_Mail_Info=" + inbox_Mail_Info + ", inbox_Mail_Date=" + inbox_Mail_Date
				+ ", inbox_mail_title=" + inbox_Mail_Title + "]";
	}

}
