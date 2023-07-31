package co.micol.productprj.bound.service;

import java.sql.Date;

public class OutboundVO {
	private String productCode;
	private int outBoundCount;
	private Date outBoundDate;

	public OutboundVO(String productCode, int outboundCount, Date outboundDate) {
		super();
		this.productCode = productCode;
		this.outBoundCount = outboundCount;
		this.outBoundDate = outboundDate;
	}
}
