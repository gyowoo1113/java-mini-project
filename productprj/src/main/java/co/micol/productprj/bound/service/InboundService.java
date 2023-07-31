package co.micol.productprj.bound.service;

import java.util.List;

import co.micol.productprj.product.service.ProductVO;

public interface InboundService {
	// 모든입/출고내역보기, 특정 입출고내역보기
	// 삭제 cascade, 수정불가능 (트랜잭션 테이블)
	List<InboundVO> inboundSelectAll();					// R
	List<InboundVO> inboundSelectList(InboundVO vo);	// R
	int inboundInsert(InboundVO vo);					// C
}
