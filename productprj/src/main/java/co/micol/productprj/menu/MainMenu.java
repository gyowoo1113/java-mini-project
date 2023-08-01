package co.micol.productprj.menu;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import co.micol.productprj.bound.service.InboundService;
import co.micol.productprj.bound.service.InboundVO;
import co.micol.productprj.bound.service.OutboundService;
import co.micol.productprj.bound.service.OutboundVO;
import co.micol.productprj.bound.serviceImpl.InboundServiceImpl;
import co.micol.productprj.bound.serviceImpl.OutboundServiceImpl;
import co.micol.productprj.product.service.ProductService;
import co.micol.productprj.product.service.ProductVO;
import co.micol.productprj.product.serviceImpl.ProductServiceImpl;

public class MainMenu {
	private Scanner scn = new Scanner(System.in);
	private ProductService productService = new ProductServiceImpl();
	private InboundService inboundService = new InboundServiceImpl();
	private OutboundService outboundService = new OutboundServiceImpl();
	
	// title 
	private void productTitle() {
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
	
	private void inboundTitle() {
		System.out.println("===  입고 관리 ===");
		System.out.println("= 1.전체내역 조회 =");
		System.out.println("= 2.특정재고 조회 =");
		System.out.println("= 3.   상품 입고 =");
		System.out.println("================");
		System.out.println("원하는 작업번호를 입력하세요?");
	}
	
	private void outboundTitle() {
		System.out.println("=== 출고 관리  ===");
		System.out.println("= 1.전체내역 조회 =");
		System.out.println("= 2.특정재고 조회 =");
		System.out.println("= 3.   상품 출고 =");
		System.out.println("================");
		System.out.println("원하는 작업번호를 입력하세요?");
	}
	
	private void productUpdateTitle() {
		System.out.println("== 상품 수정  ==");
		System.out.println("= 1.이름 수정  =");
		System.out.println("= 2.가격 수정  =");
		System.out.println("==============");
		System.out.println("원하는 작업번호를 입력하세요?");
	}
	
	// management while loop -- 
	public void run() {
		boolean isLoop = true;
		while(isLoop) {
			productTitle();
			int key = scn.nextInt();
			scn.nextLine();
			
			switch(key) {
			case 1:
				productSelectList();
				break;
			case 2:
				productCategoryList();
				break;
			case 3:
				productInsert(); 
				break;
			case 4:
				productUpdateManagement();
				break;
			case 5:
				productDelete();
				break;
			case 6:
				inboundManagement();
				break;
			case 7:
				outboundManagement();
				break;
			case 8:
				isLoop = false;
				break;
			}
		}
	}
	
	private void productUpdateManagement() {
		productUpdateTitle();
		int key = Integer.parseInt(scn.nextLine());
		
		switch(key) {
		case 1:
			productUpdateName();
			break;
		case 2:
			productUpdatePrice();
			break;
		}
	}
	
	private void productCategoryList() {
		Map<String, Integer> categorys = productService.categorySelectList();
		
		categorys.forEach((key,value)->{
			System.out.println(key + ": " + value + " 개");
		});
	}

	private void inboundManagement() {
		inboundTitle();
		int key = scn.nextInt();
		scn.nextLine();
		
		switch(key) {
		case 1:
			inboundSelectAll();
			break;
		case 2:
			inboundSelectList();
			break;
		case 3:
			inboundInsert();
			break;
		}
	}

	private void outboundManagement() {
		outboundTitle();
		int key = scn.nextInt();
		scn.nextLine();
		
		switch(key) {
		case 1:
			outboundSelectAll();
			break;
		case 2:
			outboundSelectList();
			break;
		case 3:
			outboundInsert();
			break;
		}
	}

	// product method -- 
	private void productSelectList() {
		List<ProductVO> products = productService.productSelectList();
		for (ProductVO product : products) {
			System.out.println(product);
		}
	}

	private void productInsert() {
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
		printResult(result,"등록");
	}
	
	private void productUpdatePrice() {
		// code, price
		System.out.print("입력(상품코드)>>");
		String code = scn.nextLine();
		System.out.print("입력(가격)>>");
		int price = Integer.parseInt(scn.nextLine());
		
		ProductVO product = new ProductVO();
		product.setProductCode(code);
		product.setProductPrice(price);
		int result = productService.productUpdatePrice(product);
		printResult(result,"가격변경 ");
	}
	
	private void productUpdateName() {
		// code, price
		System.out.print("입력(상품코드)>>");
		String code = scn.nextLine();
		System.out.print("입력(이름)>>");
		String name = scn.nextLine();
		
		ProductVO product = new ProductVO();
		product.setProductCode(code);
		product.setProductName(name);
		int result = productService.productUpdateName(product);
		printResult(result,"이름변경 ");
	}

	private void productDelete() {
		// code 
		System.out.print("입력(상품코드)>>");
		String code = scn.nextLine();
		
		ProductVO product = new ProductVO();
		product.setProductCode(code);
		int result = productService.productDelete(product);
		printResult(result,"삭제");
	}

	// inbound method --
	private void inboundSelectAll() {
		List<InboundVO> inbounds = new ArrayList<InboundVO>();
		inbounds = inboundService.inboundSelectAll();
		
		for (InboundVO bound : inbounds) {
			System.out.println(bound);
		}
	}

	private void inboundSelectList() {
		// code
		System.out.print("입력(상품코드)>>");
		String code = scn.nextLine();
		
		InboundVO inbound = new InboundVO();
		inbound.setProductCode(code);
		List<InboundVO> inbounds = new ArrayList<InboundVO>();
		inbounds = inboundService.inboundSelectList(inbound);
		
		for (InboundVO bound : inbounds) {
			System.out.println(bound);
		}
	}

	private void inboundInsert() {
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
		printResult(result,"입고");
	}
	
	// outbound method --
	private void outboundSelectAll() {
		List<OutboundVO> outbounds = new ArrayList<OutboundVO>();
		outbounds = outboundService.outboundSelectAll();
		
		for (OutboundVO bound : outbounds) {
			System.out.println(bound);
		}
	}

	private void outboundSelectList() {
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

	private void outboundInsert() {
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
		printResult(result,"출고");
	}
	
	public void printResult(int result, String word) {
		if (result == 1) {
			System.out.println("**"+word+"성공**");
		} else {
			System.out.println("**"+word+"실패**");
		}
	}
}
