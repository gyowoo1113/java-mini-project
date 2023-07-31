package co.micol.productprj.bound.service;

import java.util.List;

public interface OutboundService {
	List<OutboundVO> inboundSelectAll();					// R
	List<OutboundVO> inboundSelectList(OutboundVO vo);		// R
	int inboundInsert(OutboundVO vo);						// C
}
