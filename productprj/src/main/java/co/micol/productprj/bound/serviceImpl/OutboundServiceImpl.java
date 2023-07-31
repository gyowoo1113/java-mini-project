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
		return outbounds;
	}

	@Override
	public List<OutboundVO> outboundSelectList(OutboundVO vo) {
		String sql = "SELECT * FROM outbound WHERE product_code = ?";
		return null;
	}

	@Override
	public int outboundInsert(OutboundVO vo) {
		// product_code, count, date
		String sql = "INSERT INTO outbound VALUES (?,?,?)";
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
