package com.inbox.model;

import java.util.List;
import java.util.Set;

public class InboxService {
	private InboxDAO_interface dao;
	
	public InboxService() {
		dao = new InboxDAO_JDBC();
	}
	
	public List<InboxVO> getAll(){
		return dao.selectAll();
	}
	
	public InboxVO getOne(String inbox_Mail_ID) {
		return dao.select(inbox_Mail_ID);
	}
	
	public Set<InboxVO>getInboxByMemberID(String member_ID){
		return dao.selectByMember(member_ID);
	}
	
	public InboxVO writeMail(String member_ID, String emp_ID, String inbox_Mail_Info, String inbox_Mail_Title) {
		if(member_ID != null && inbox_Mail_Info != null && inbox_Mail_Title != null) {
			InboxVO inbox = new InboxVO();
			
			inbox.setEmp_ID(emp_ID);
			inbox.setInbox_Mail_Info(inbox_Mail_Info);
			inbox.setMember_ID(member_ID);
			inbox.setInbox_Mail_Title(inbox_Mail_Title);
			dao.insert(inbox);
			
			return inbox;
			
		}
		return null;
	}
	
	public Integer deleteMail(String inbox_Mail_ID) {
		if(inbox_Mail_ID != null) {
			
			return dao.delete(inbox_Mail_ID);
		}
		return null;
	}
	
	public static void main(String[] args) {
		InboxService dao = new InboxService();
		System.out.println(dao.getOne("IMID000000"));
		System.out.println(dao.getAll());
		
		InboxVO inbox = new InboxVO();
		inbox.setEmp_ID("EID000001");
		inbox.setInbox_Mail_Info("這是測試這是測試這是測試這是測試這是測試這是測試這是測試這是測試這是測試這是測試這是測試這是測試這是測試這是測試這是測試這是測試這是測試");
		inbox.setMember_ID("MID000000");
		inbox.setInbox_Mail_Title("test");
		System.out.println(dao.writeMail(inbox.getMember_ID(), inbox.getEmp_ID(), inbox.getInbox_Mail_Info(), inbox.getInbox_Mail_Title()));
		
		
//		inbox.setInbox_Mail_ID("5");
//	    inbox.setEmp_ID("1000");
//		inbox.setMember_ID("5");
//		inbox.setInbox_Mail_Info("update test");
//		dao.update(inbox);
		
		System.out.println(dao.deleteMail("IMID000010"));
		
		System.out.println(dao.getInboxByMemberID("MID005000"));
		
	}
	
}
