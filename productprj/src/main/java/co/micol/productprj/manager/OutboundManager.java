package co.micol.productprj.manager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.productprj.bound.service.OutboundService;
import co.micol.productprj.bound.service.OutboundVO;
import co.micol.productprj.bound.serviceImpl.OutboundServiceImpl;
import co.micol.productprj.log.MenuLogger;
import co.micol.productprj.product.service.ProductService;
import co.micol.productprj.product.service.ProductVO;

public class OutboundManager {
	private OutboundService outboundService = new OutboundServiceImpl();
	
	public void outboundTitle() {
		System.out.println("=== 출고 관리  ===");
		System.out.println("= 1.전체내역 조회 =");
		System.out.println("= 2.특정재고 조회 =");
		System.out.println("= 3.   상품 출고 =");
		System.out.println("================");
		System.out.println("원하는 작업번호를 입력하세요?");
	}
	
	public void outboundSelectAll() {
		List<OutboundVO> outbounds = new ArrayList<OutboundVO>();
		outbounds = outboundService.outboundSelectAll();
		
		for (OutboundVO bound : outbounds) {
			System.out.println(bound);
		}
	}

	public void outboundSelectList(Scanner scn) {
		// code
		System.out.print("입력(상품코드)>>");
		String code = scn.nextLine();

		OutboundVO outbound = new OutboundVO();
		outbound.setProductCode(code);
		List<OutboundVO> outbounds = new ArrayList<OutboundVO>();
		outbounds = outboundService.outboundSelectList(outbound);
		
		for (OutboundVO bound : outbounds) {
			System.out.println(bound);
		}
	}

	public void outboundInsert(Scanner scn, ProductService productService) {
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
		if (curStock - count < 0) {
			System.out.println("Fail: 재고가 부족합니다.");
			return;
		}
		
		// result 추가필요
		curStock -= count;
		product.setProductStock(curStock);
		int stockResult = productService.productUpdateStock(product);
		
		if (stockResult != 1) {
			System.out.println("Error : 재고내역 갱신실패");
			return;
		}
		
		OutboundVO outbound = new OutboundVO(code,count,date);
		int result = outboundService.outboundInsert(outbound);
		MenuLogger.printResult(result,"출고");
	}
	
}
