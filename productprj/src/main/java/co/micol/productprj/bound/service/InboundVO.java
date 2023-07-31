package co.micol.productprj.bound.service;

import java.time.LocalDate;

import lombok.Data;

@Data
public class InboundVO {
	private String productCode;
	private int inboundCount;
	private LocalDate inboundDate;

	public InboundVO() {};
	public InboundVO(String productCode, int inboundCount, LocalDate inboundDate) {
		super();
		this.productCode = productCode;
		this.inboundCount = inboundCount;
		this.inboundDate = inboundDate;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += productCode + " ";
		str += inboundCount + " ";
		str += inboundDate + " ";
		return str;
	}
}
