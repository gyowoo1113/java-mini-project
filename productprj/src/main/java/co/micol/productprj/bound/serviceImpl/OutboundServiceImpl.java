package co.micol.productprj.bound.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.micol.productprj.bound.service.OutboundService;
import co.micol.productprj.bound.service.OutboundVO;

public class OutboundServiceImpl implements OutboundService {

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

}
