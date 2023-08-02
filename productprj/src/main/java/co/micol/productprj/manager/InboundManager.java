package co.micol.productprj.manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.productprj.bound.service.InboundService;
import co.micol.productprj.bound.service.InboundVO;
import co.micol.productprj.bound.serviceImpl.InboundServiceImpl;
import co.micol.productprj.log.MenuLogger;
import co.micol.productprj.product.service.ProductService;
import co.micol.productprj.product.service.ProductVO;

public class InboundManager {
	private InboundService inboundService = new InboundServiceImpl();
	
	public void inboundTitle() {
		System.out.println("===  입고 관리 ===");
		System.out.println("= 1.전체내역 조회 =");
		System.out.println("= 2.특정재고 조회 =");
		System.out.println("= 3.   상품 입고 =");
		System.out.println("================");
		System.out.println("원하는 작업번호를 입력하세요?");
	}
	
	
	public void inboundSelectAll() {
		List<InboundVO> inbounds = new ArrayList<InboundVO>();
		inbounds = inboundService.inboundSelectAll();
		
		for (InboundVO bound : inbounds) {
			System.out.println(bound);
		}
	}

	public void inboundSelectList(Scanner scn) {
		// code
		System.out.print("입력(상품코드)>>");
		String code = scn.nextLine();
		
		InboundVO inbound = new InboundVO();
		inbound.setProductCode(code);
		List<InboundVO> inbounds = new ArrayList<InboundVO>();
		inbounds = inboundService.inboundSelectList(inbound);
		
		if (inbounds.isEmpty()) {
			System.out.println(code + " 제품 입고내역이 없습니다.");
			return;
		}
		
		for (InboundVO bound : inbounds) {
			System.out.println(bound);
		}
	}

	public void inboundInsert(Scanner scn, ProductService productService) {
		// code, count, date
		System.out.print("입력(상품코드)>>");
		String code = scn.nextLine();
		System.out.print("입력(갯수)>>");
		int count = Integer.parseInt(scn.nextLine());
		System.out.print("입력(날짜[YYYY-MM-DD])>>");
		String strDate = scn.nextLine();
		LocalDate date = LocalDate.parse(strDate);
		
		ProductVO product = new ProductVO();
		product.setProductCode(code);
		product = productService.productSelect(product);
		if (product == null) {
			System.out.println("Error: 상품이 존재하지 않습니다.");
			return;
		}
		
		int curStock = product.getProductStock();
		curStock += count;
		product.setProductStock(curStock);
		int stockResult = productService.productUpdateStock(product);
		
		if (stockResult != 1) {
			System.out.println("Error : 재고내역 갱신실패");
			return;
		}
		
		InboundVO inbound = new InboundVO(code,count,date);
		int result = inboundService.inboundInsert(inbound);
		MenuLogger.printResult(result,"입고");
	}
	
}
