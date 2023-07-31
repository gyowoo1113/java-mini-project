package co.micol.productprj.bound.service;

import java.util.List;

public interface OutboundService {
	List<OutboundVO> outboundSelectAll();					// R
	List<OutboundVO> outboundSelectList(OutboundVO vo);		// R
	int outboundInsert(OutboundVO vo);						// C
}
