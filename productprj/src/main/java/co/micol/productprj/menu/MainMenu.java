package co.micol.productprj.menu;

import java.util.Scanner;

import co.micol.productprj.bound.service.InboundService;
import co.micol.productprj.bound.service.OutboundService;
import co.micol.productprj.bound.serviceImpl.InboundServiceImpl;
import co.micol.productprj.bound.serviceImpl.OutboundServiceImpl;
import co.micol.productprj.product.service.ProductService;
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
		System.out.println("= 2.상품 등록 =");
		System.out.println("= 3.상품 수정 =");
		System.out.println("= 4.상품 삭제 =");
		System.out.println("= 5.입고 관리 =");
		System.out.println("= 6.출고 관리 =");
		System.out.println("= 7.    종료 =");
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
				productInsert(); 
				break;
			case 3:
				productUpdate();
				break;
			case 4:
				productDelete();
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				isLoop = false;
				break;
			}
		}
		
	// product method -- 
	private void productSelectList() {
	}

	private void productInsert() {
	}
	
	private void productUpdate() {
	}

	private void productDelete() {
	}
}
