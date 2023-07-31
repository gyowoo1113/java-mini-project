package co.micol.productprj.product.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.productprj.common.DataSource;
import co.micol.productprj.product.service.ProductService;
import co.micol.productprj.product.service.ProductVO;

public class ProductServiceImpl implements ProductService {
	private DataSource dao = DataSource.getInstance();
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;

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

	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
