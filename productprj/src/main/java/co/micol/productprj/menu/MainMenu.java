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
	
	public void run() {
		
	}
}
