package com.order_master.model;

import java.util.List;
import java.util.Set;

public interface Order_MasterDAO_interface {
	public Order_MasterVO select(String order_Master_ID);
	public List<Order_MasterVO> selectAll();
	public Order_MasterVO insert(Order_MasterVO order_Master);
	public Order_MasterVO update(Order_MasterVO order_Master);
	public Integer delete(String order_Master_ID);
	public Set<Order_MasterVO> selectByMember(String member_ID);
}
