package com.collection.model;

import java.util.List;
import java.util.Set;

public class CollectionService {
	private CollectionDAO_interface dao;

	public CollectionService() {
		this.dao = new CollectionDAO_JDBC();
	}

	public CollectionVO addCollection(String member_ID, String product_ID) {
		if (member_ID != null && product_ID != null) {

			CollectionVO collection = new CollectionVO();
			collection.setMember_ID(member_ID);
			collection.setProduct_ID(product_ID);
			collection = dao.insert(collection);
			return collection;
		}
		return null;
	

	}

	public Integer deleteCollection(String collection_ID) {
		if(collection_ID != null) {
			return dao.delete(collection_ID);
			
		}
		return null;
	}

	public CollectionVO getOne(String collection_ID) {
		if(collection_ID != null) {
			return dao.getOne(collection_ID);
		}
		return null;

	}

	public List<CollectionVO> getAll() {
		return dao.getAll();
	}

	public Set<CollectionVO> getCollectionByMemberID(String member_ID) {
		if(member_ID != null) {
			
			return dao.getCollectionByMemberID(member_ID);
		}
		return null;
	}

	public static void main(String[] args) {
		CollectionService dao = new CollectionService();
		System.out.println(dao.getAll());
		System.out.println(dao.getOne("COID000023"));
		System.out.println(dao.getCollectionByMemberID("MID000000"));

		System.out.println(dao.deleteCollection("COID000001"));
//		System.out.println(dao.addCollection("MID000000", "PID000000"));
	}

}
