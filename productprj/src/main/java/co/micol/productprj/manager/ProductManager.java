package co.micol.productprj.manager;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import co.micol.productprj.log.MenuLogger;
import co.micol.productprj.product.service.ProductService;
import co.micol.productprj.product.service.ProductVO;
import co.micol.productprj.product.serviceImpl.ProductServiceImpl;
import lombok.Data;

@Data
public class ProductManager {
	private ProductService productService = new ProductServiceImpl();

	public void productTitle() {
		System.out.println("== 상품 관리 ==");
		System.out.println("= 1.상품 조회 =");
		System.out.println("= 2.품목별재고 =");
		System.out.println("= 3.상품 등록 =");
		System.out.println("= 4.상품 수정 =");
		System.out.println("= 5.상품 삭제 =");
		System.out.println("= 6.입고 관리 =");
		System.out.println("= 7.출고 관리 =");
		System.out.println("= 8.    종료 =");
		System.out.println("=============");
		System.out.println("원하는 작업번호를 입력하세요 >>");
	}
	
	public void productUpdateTitle() {
		System.out.println("== 상품 수정  ==");
		System.out.println("= 1.이름 수정  =");
		System.out.println("= 2.가격 수정  =");
		System.out.println("==============");
		System.out.println("원하는 작업번호를 입력하세요?");
	}
	
	public void productSelectList() {
		List<ProductVO> products = productService.productSelectList();
		for (ProductVO product : products) {
			System.out.println(product);
		}
	}
	
	public void productCategoryList() {
		Map<String, Integer> categorys = productService.categorySelectList();
		
		categorys.forEach((key,value)->{
			System.out.println(key + ": " + value + " 개");
		});
	}

	public void productInsert(Scanner scn) {
		// code, name, price, stock
		System.out.print("입력(상품코드)>>");
		String code = scn.nextLine();
		System.out.print("입력(이름)>>");
		String name = scn.nextLine();
		System.out.print("입력(가격)>>");
		int price = Integer.parseInt(scn.nextLine());
		System.out.print("입력(재고)>>");
		int stock = Integer.parseInt(scn.nextLine());
		
		if (stock < 0) {
			System.out.println("Error: 재고는 음수가 될 수 없습니다");
			return;
		}
		
		ProductVO product = new ProductVO(code,name,price,stock);
		int result = productService.productInsert(product);
		MenuLogger.printResult(result,"등록");
	}
	
	public void productUpdatePrice(Scanner scn) {
		// code, price
		System.out.print("입력(상품코드)>>");
		String code = scn.nextLine();
		System.out.print("입력(가격)>>");
		int price = Integer.parseInt(scn.nextLine());
		
		ProductVO product = new ProductVO();
		product.setProductCode(code);
		product.setProductPrice(price);
		int result = productService.productUpdatePrice(product);
		MenuLogger.printResult(result,"가격변경 ");
	}
	
	public void productUpdateName(Scanner scn) {
		// code, price
		System.out.print("입력(상품코드)>>");
		String code = scn.nextLine();
		System.out.print("입력(이름)>>");
		String name = scn.nextLine();
		
		ProductVO product = new ProductVO();
		product.setProductCode(code);
		product.setProductName(name);
		int result = productService.productUpdateName(product);
		MenuLogger.printResult(result,"이름변경 ");
	}

	public void productDelete(Scanner scn) {
		// code 
		System.out.print("입력(상품코드)>>");
		String code = scn.nextLine();
		
		ProductVO product = new ProductVO();
		product.setProductCode(code);
		int result = productService.productDelete(product);
		MenuLogger.printResult(result,"삭제");
	}
}
