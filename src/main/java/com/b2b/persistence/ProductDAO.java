package com.b2b.persistence;

import com.b2b.domain.ProductVO;

public interface ProductDAO {
	
	public void create(ProductVO vo) throws Exception;
	
	public ProductVO read(int pno) throws Exception;
	
	public void update(ProductVO vo) throws Exception;
	
	public void delete(int pno) throws Exception;

}
