package co.micol.productprj.product.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.micol.productprj.product.service.ProductService;
import co.micol.productprj.product.service.ProductVO;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<ProductVO> productSelectList() {
		String sql = "SELECT * FROM product";
		List<ProductVO> products = new ArrayList<ProductVO>();
		return products;
	}

	@Override
	public ProductVO productSelect(ProductVO vo) {
		String sql = "SELECT * FROM product WHERE product_code = ?";
		return null;
	}

	@Override
	public int productInsert(ProductVO vo) {
		// code, name, price, stock
		String sql = "INSERT INTO product VALUES (?,?,?,?)";
		int n = 0;
		return n;
	}

	@Override
	public int productDelete(ProductVO vo) {
		String sql = "DELETE FROM product WHERE product_code = ?";
		int n = 0;
		return n;
	}

	@Override
	public int productUpdate(ProductVO vo) {
		String sql = "UPDATE product SET product_price = ? WHERE product_code = ?";
		int n = 0;
		return n;
	}

}
