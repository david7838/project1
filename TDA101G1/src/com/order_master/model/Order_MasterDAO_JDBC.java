package com.order_master.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Order_MasterDAO_JDBC implements Order_MasterDAO_interface {
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:49161:XE";
	String userid = "TDA101G1";
	String passwd = "123456";
	
	private static final String INSERT_STMT = "INSERT INTO ORDER_MASTER (ORDER_MASTER_ID, MEMBER_ID, COUPON_ID, ORDER_MASTER_PAYMENT, ORDER_MASTER_STATE) VALUES ('OMID'||LPAD(to_char(SEQ_ORDER_MASTER_ID.NEXTVAL),6,'0'), ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE ORDER_MASTER set MEMBER_ID=?, COUPON_ID=?, ORDER_MASTER_PAYMENT=?, ORDER_MASTER_TIMESTAMP=CURRENT_TIMESTAMP, ORDER_MASTER_STATE=? where ORDER_MASTER_ID=?";
	private static final String GET_ALL_STMT = "SELECT ORDER_MASTER_ID, MEMBER_ID, COUPON_ID, ORDER_MASTER_PAYMENT, ORDER_MASTER_TIMESTAMP, ORDER_MASTER_STATE FROM ORDER_MASTER order by ORDER_MASTER_ID";
	private static final String GET_ONE_STMT = "SELECT ORDER_MASTER_ID, MEMBER_ID, COUPON_ID, ORDER_MASTER_PAYMENT, ORDER_MASTER_TIMESTAMP, ORDER_MASTER_STATE FROM ORDER_MASTER where ORDER_MASTER_ID=?";
	private static final String DELETE = "DELETE from ORDER_MASTER where ORDER_MASTER_ID=?";
	private static final String SELECT_BY_MEMEBER = "SELECT ORDER_MASTER_ID, MEMBER_ID, COUPON_ID, ORDER_MASTER_PAYMENT, ORDER_MASTER_TIMESTAMP, ORDER_MASTER_STATE FROM ORDER_MASTER where member_id=?";
	
	
	@Override
	public Order_MasterVO select(String order_Master_ID) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order_MasterVO OM = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(GET_ONE_STMT);
			ps.setString(1, order_Master_ID);
			rs = ps.executeQuery();
			
			OM = new Order_MasterVO();
			while(rs.next()) {
				OM.setCoupon_ID(rs.getString("COUPON_ID"));
				OM.setMember_ID(rs.getString("MEMBER_ID"));
				OM.setOrder_Master_ID(rs.getString("ORDER_MASTER_ID"));
				OM.setOrder_Master_Payment(rs.getString("ORDER_MASTER_PAYMENT"));
				OM.setOrder_Master_State(rs.getInt("ORDER_MASTER_STATE"));
				OM.setOrder_Master_TimeStamp(rs.getTimestamp("ORDER_MASTER_TIMESTAMP"));
			}
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}
		finally{
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return OM;
	}

	@Override
	public List<Order_MasterVO> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Order_MasterVO OM = null;
		List<Order_MasterVO>OMS = new ArrayList<Order_MasterVO>();
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(GET_ALL_STMT);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				OM = new Order_MasterVO();
				OM.setCoupon_ID(rs.getString("COUPON_ID"));
				OM.setMember_ID(rs.getString("MEMBER_ID"));
				OM.setOrder_Master_ID(rs.getString("ORDER_MASTER_ID"));
				OM.setOrder_Master_Payment(rs.getString("ORDER_MASTER_PAYMENT"));
				OM.setOrder_Master_State(rs.getInt("ORDER_MASTER_STATE"));
				OM.setOrder_Master_TimeStamp(rs.getTimestamp("ORDER_MASTER_TIMESTAMP"));
				OMS.add(OM);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}
		finally {
		
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return OMS;
	}

	@Override
	public Order_MasterVO insert(Order_MasterVO order_Master) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			con.setAutoCommit(false);
			ps = con.prepareStatement(INSERT_STMT, new String[] { "ORDER_MASTER_ID" });
			ps.setString(1, order_Master.getMember_ID());
			ps.setString(2, order_Master.getCoupon_ID());	
			ps.setString(3, order_Master.getOrder_Master_Payment());
			ps.setInt(4, order_Master.getOrder_Master_State());
			
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				order_Master.setOrder_Master_ID(rs.getString(1));
			}
			con.commit();
			return order_Master;
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			try {
				con.rollback();
				throw new RuntimeException("A database error occured. " + e.getMessage());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
		
	}

	@Override
	public Order_MasterVO update(Order_MasterVO order_Master) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			con.setAutoCommit(false);
			ps = con.prepareStatement(UPDATE);
			
			ps.setString(1, order_Master.getMember_ID());
			ps.setString(2, order_Master.getCoupon_ID());
			ps.setString(3, order_Master.getOrder_Master_Payment());
			ps.setInt(4, order_Master.getOrder_Master_State());
			ps.setString(5, order_Master.getOrder_Master_ID());
			ps.executeUpdate();
			con.commit();
			return order_Master;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			try {
				con.rollback();
				throw new RuntimeException("A database error occured. " + e.getMessage());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (con != null) {
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
		
	}

	@Override
	public Integer delete(String order_Master_ID) {
		Connection con = null;
		PreparedStatement ps = null;
		Integer result = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			con.setAutoCommit(false);
			ps = con.prepareStatement(DELETE);
			
			ps.setString(1, order_Master_ID);
			result = ps.executeUpdate();
			
			con.commit();
			return result;
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			try {
				con.rollback();
				throw new RuntimeException("A database error occured. " + e.getMessage());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.setAutoCommit(true);
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return -1;
		
	}

	@Override
	public Set<Order_MasterVO> selectByMember(String member_ID) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Set<Order_MasterVO> OMS = new HashSet<Order_MasterVO>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			ps = con.prepareStatement(SELECT_BY_MEMEBER);
			ps.setString(1, member_ID);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Order_MasterVO OM = new Order_MasterVO();
				OM.setCoupon_ID(rs.getString("Coupon_ID"));
				OM.setMember_ID(rs.getString("Member_ID"));
				OM.setOrder_Master_ID(rs.getString("Order_Master_ID"));
				OM.setOrder_Master_Payment(rs.getString("Order_Master_Payment"));
				OM.setOrder_Master_State(rs.getInt("Order_Master_State"));
				OM.setOrder_Master_TimeStamp(rs.getTimestamp("ORDER_MASTER_TIMESTAMP"));
				OMS.add(OM);
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}
		
		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return OMS;
	}

}
