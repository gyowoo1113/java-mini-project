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
import co.micol.productprj.manager.InboundManager;
import co.micol.productprj.manager.OutboundManager;
import co.micol.productprj.manager.ProductManager;
import co.micol.productprj.product.service.ProductService;
import co.micol.productprj.product.service.ProductVO;
import co.micol.productprj.product.serviceImpl.ProductServiceImpl;

public class MainMenu {
	private Scanner scn = new Scanner(System.in);
	private ProductManager productManager = new ProductManager();
	private InboundManager inboundManager = new  InboundManager();
	private OutboundManager outboundManager = new OutboundManager();
	
	// management while loop -- 
	public void run() {
		boolean isLoop = true;
		while(isLoop) {
			productManager.productTitle();
			int key = scn.nextInt();
			scn.nextLine();
			
			switch(key) {
			case 1:
				productManager.productSelectList();
				break;
			case 2:
				productManager.productCategoryList();
				break;
			case 3:
				productManager.productInsert(scn); 
				break;
			case 4:
				productUpdateManagement();
				break;
			case 5:
				productManager.productDelete(scn);
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
		scn.close();
	}
	
	private void productUpdateManagement() {
		productManager.productUpdateTitle();
		int key = Integer.parseInt(scn.nextLine());
		
		switch(key) {
		case 1:
			productManager.productUpdateName(scn);
			break;
		case 2:
			productManager.productUpdatePrice(scn);
			break;
		}
	}
	
	private void inboundManagement() {
		inboundManager.inboundTitle();
		int key = scn.nextInt();
		scn.nextLine();
		
		switch(key) {
		case 1:
			inboundManager.inboundSelectAll();
			break;
		case 2:
			inboundManager.inboundSelectList(scn);
			break;
		case 3:
			inboundManager.inboundInsert(scn, productManager.getProductService());
			break;
		}
	}

	private void outboundManagement() {
		outboundManager.outboundTitle();
		int key = scn.nextInt();
		scn.nextLine();
		
		switch(key) {
		case 1:
			outboundManager.outboundSelectAll();
			break;
		case 2:
			outboundManager.outboundSelectList(scn);
			break;
		case 3:
			outboundManager.outboundInsert(scn, productManager.getProductService());
			break;
		}
	}
}




