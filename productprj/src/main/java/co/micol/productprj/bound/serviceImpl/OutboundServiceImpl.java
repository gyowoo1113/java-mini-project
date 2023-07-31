package co.micol.productprj.bound.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.productprj.bound.service.OutboundService;
import co.micol.productprj.bound.service.OutboundVO;
import co.micol.productprj.common.DataSource;

public class OutboundServiceImpl implements OutboundService {
	private DataSource dao = DataSource.getInstance();
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	@Override
	public List<OutboundVO> outboundSelectAll() {
		String sql = "SELECT * FROM outbound";
		List<OutboundVO> outbounds = new ArrayList<OutboundVO>();
		
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				OutboundVO outbound = new OutboundVO();
				outbound.setProductCode(resultSet.getString("product_code"));
				outbound.setOutBoundCount(resultSet.getInt("outbound_count"));
				outbound.setOutBoundDate(resultSet.getDate("outbound_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return outbounds;
	}

	@Override
	public List<OutboundVO> outboundSelectList(OutboundVO vo) {
		String sql = "SELECT * FROM outbound WHERE product_code = ?";
		
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				OutboundVO outbound = new OutboundVO();
				outbound.setProductCode(resultSet.getString("product_code"));
				outbound.setOutBoundCount(resultSet.getInt("outbound_count"));
				outbound.setOutBoundDate(resultSet.getDate("outbound_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return null;
	}

	@Override
	public int outboundInsert(OutboundVO vo) {
		// product_code, count, date
		String sql = "INSERT INTO outbound VALUES (?,?,?)";
		int n = 0;
		
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductCode());
			preparedStatement.setInt(2, vo.getOutBoundCount());
			preparedStatement.setDate(3, vo.getOutBoundDate());
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
