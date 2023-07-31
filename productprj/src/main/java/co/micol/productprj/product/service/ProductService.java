package co.micol.productprj.product.service;

import java.util.List;

public interface ProductService {
	// 상품 등록, 수정, 삭제, 구매(입고), 판매(출고)
	public List<ProductVO> productSelectList();		// R
	public ProductVO productSelect(ProductVO vo);	// R
	public int productInsert(ProductVO vo);			// C
	public int productDelete(ProductVO vo);			// D
	public int productUpdate(ProductVO vo);			// U
}
