package co.micol.productprj.product.service;

import java.util.List;
import java.util.Map;

public interface ProductService {
	// 상품 등록, 수정, 삭제, 구매(입고), 판매(출고)
	List<ProductVO> productSelectList();		// R
	Map<String, Integer> categorySelectList();	// R
	ProductVO productSelect(ProductVO vo);		// R
	int productInsert(ProductVO vo);			// C
	int productDelete(ProductVO vo);			// D
	int productUpdateName(ProductVO vo);		// U
	int productUpdatePrice(ProductVO vo);		// U
	int productUpdateStock(ProductVO vo);		// U
}
