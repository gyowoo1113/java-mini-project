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
		
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				ProductVO product = new ProductVO();
				product.setProductCode(resultSet.getString("product_code"));
				product.setProductName(resultSet.getString("product_name"));
				product.setProductPrice(resultSet.getInt("product_price"));
				product.setProductStock(resultSet.getInt("product_stock"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return products;
	}

	@Override
	public ProductVO productSelect(ProductVO vo) {
		String sql = "SELECT * FROM product WHERE product_code = ?";

		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductCode());
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				vo.setProductName(resultSet.getString("product_name"));
				vo.setProductPrice(resultSet.getInt("product_price"));
				vo.setProductStock(resultSet.getInt("product_stock"));
				return vo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return null;
	}

	@Override
	public int productInsert(ProductVO vo) {
		// code, name, price, stock
		String sql = "INSERT INTO product VALUES (?,?,?,?)";
		int n = 0;
		
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductCode());
			preparedStatement.setString(2, vo.getProductName());
			preparedStatement.setInt(3, vo.getProductPrice());
			preparedStatement.setInt(4, vo.getProductStock());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public int productDelete(ProductVO vo) {
		String sql = "DELETE FROM product WHERE product_code = ?";
		int n = 0;
		
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductCode());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return n;
	}

	@Override
	public int productUpdate(ProductVO vo) {
		String sql = "UPDATE product SET product_price = ? WHERE product_code = ?";
		int n = 0;
		
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, vo.getProductPrice());
			preparedStatement.setString(2, vo.getProductCode());
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
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
