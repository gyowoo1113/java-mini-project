package co.micol.productprj.bound.service;


import java.time.LocalDate;

import lombok.Data;

@Data
public class OutboundVO {
	private String productCode;
	private int outBoundCount;
	private LocalDate outBoundDate;

	public OutboundVO() {};
	public OutboundVO(String productCode, int outboundCount, LocalDate outboundDate) {
		super();
		this.productCode = productCode;
		this.outBoundCount = outboundCount;
		this.outBoundDate = outboundDate;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += productCode + " ";
		str += outBoundCount + " ";
		str += outBoundDate + " ";
		return str;
	}
}
