package co.micol.productprj.product.service;

import java.util.List;
import java.util.Map;

public interface ProductService {
	// 상품 등록, 수정, 삭제, 구매(입고), 판매(출고)
	public List<ProductVO> productSelectList();		// R
	public ProductVO productSelect(ProductVO vo);	// R
	public int productInsert(ProductVO vo);			// C
	public int productDelete(ProductVO vo);			// D
	public int productUpdateName(ProductVO vo);		// U
	public int productUpdatePrice(ProductVO vo);		// U
	public int productUpdateStock(ProductVO vo);		// U
	
	Map<String, Integer> categorySelectList();	// R
}
