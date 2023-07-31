package co.micol.productprj.product.service;

public class ProductVO {
	private String productCode;
	private String productName;
	private int productPrice;
	private int productStock;

	public ProductVO(String productCode, String productName, int productPrice, int productStock) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productStock = productStock;
	}
}
