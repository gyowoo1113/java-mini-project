package co.micol.productprj.product.service;

import lombok.Data;

@Data
public class ProductVO {
	private String productCode;
	private String productName;
	private int productPrice;
	private int productStock;

	public ProductVO() {};
	public ProductVO(String productCode, String productName, int productPrice, int productStock) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += productCode + " ";
		str += productName + " ";
		str += productPrice + " ";
		str += productStock;
		return str;
	}
}
