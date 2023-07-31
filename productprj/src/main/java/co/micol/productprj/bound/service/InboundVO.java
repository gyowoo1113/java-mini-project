package co.micol.productprj.bound.service;

import java.sql.Date;

public class InboundVO {
	private String productCode;
	private int inboundCount;
	private Date inboundDate;

	public InboundVO(String productCode, int inboundCount, Date inboundDate) {
		super();
		this.productCode = productCode;
		this.inboundCount = inboundCount;
		this.inboundDate = inboundDate;
	}
}
