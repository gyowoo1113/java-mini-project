package co.micol.productprj.bound.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.productprj.bound.service.InboundService;
import co.micol.productprj.bound.service.InboundVO;
import co.micol.productprj.common.DataSource;

public class InboundServiceImpl implements InboundService {
	private DataSource dao = DataSource.getInstance();
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	@Override
	public List<InboundVO> inboundSelectAll() {
		String sql = "SELECT * FROM inbound";
		List<InboundVO> inbounds = new ArrayList<InboundVO>();
		
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				InboundVO inbound = new InboundVO();
				inbound.setProductCode(resultSet.getString("product_code"));
				inbound.setInboundCount(resultSet.getInt("inbound_count"));
				inbound.setInboundDate(resultSet.getDate("inbound_date"));
				inbounds.add(inbound);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return inbounds;
	}

	@Override
	public List<InboundVO> inboundSelectList(InboundVO vo) {
		String sql = "SELECT * FROM inbound WHERE product_code = ?";
		List<InboundVO> inbounds = new ArrayList<InboundVO>();
		
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductCode());
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				InboundVO inbound = new InboundVO();
				inbound.setProductCode(resultSet.getString("product_code"));
				inbound.setInboundCount(resultSet.getInt("inbound_count"));
				inbound.setInboundDate(resultSet.getDate("inbound_date"));
				inbounds.add(inbound);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return null;
	}

	@Override
	public int inboundInsert(InboundVO vo) {
		// product_code, count, date
		String sql = "INSERT INTO inbound VALUES (?,?,?)";
		int n = 0;
		
		connection = dao.getConnection();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, vo.getProductCode());
			preparedStatement.setInt(2, vo.getInboundCount());
			preparedStatement.setDate(3, vo.getInboundDate());
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
