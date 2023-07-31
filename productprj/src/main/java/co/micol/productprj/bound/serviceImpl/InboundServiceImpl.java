package co.micol.productprj.bound.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import co.micol.productprj.bound.service.InboundService;
import co.micol.productprj.bound.service.InboundVO;

public class InboundServiceImpl implements InboundService {

	@Override
	public List<InboundVO> inboundSelectAll() {
		String sql = "SELECT * FROM inbound";
		List<InboundVO> inbounds = new ArrayList<InboundVO>();
		return inbounds;
	}

	@Override
	public List<InboundVO> inboundSelectList(InboundVO vo) {
		String sql = "SELECT * FROM inbound WHERE product_code = ?";
		return null;
	}

	@Override
	public int inboundInsert(InboundVO vo) {
		// product_code, count, date
		String sql = "INSERT INTO inbound VALUES (?,?,?)";
		int n = 0;
		return n;
	}

}
