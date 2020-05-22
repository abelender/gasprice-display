package com.abelender.gaspricedisplay;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GasApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/*
		 *  		CREATE OBJECTS TO HANDLE ACTUAL PRODUCT PRICES 	
		 */
		
		
		// Create ContentHandler object for the parser
		ContentHandler handler = context.getBean("handler", ContentHandler.class);
		
		// Parsing XML from product prices online site
		SaxParser sax = context.getBean("parser", SaxParser.class);

		GasStationPrice prices = handler.getPricesObject();

		
		JPanel mainPanel = new JPanel();
		GridLayout grid = new GridLayout(3, 2);
		mainPanel.setLayout(grid);
		
		PremiumGasPriceDisplay premium = new PremiumGasPriceDisplay(prices.getPremiumPrice());
		RegularGasPriceDisplay regular = new RegularGasPriceDisplay(prices.getRegularPrice());
		DieselGasPriceDisplay diesel = new DieselGasPriceDisplay(prices.getDieselPrice());

		mainPanel.add(premium);
		mainPanel.add(regular);
		mainPanel.add(diesel);
	
		JFrame frame = new JFrame("Premium|Regular|Diesel Price");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(mainPanel);
	
		frame.pack();
		frame.setMinimumSize( frame.getSize() );

		frame.setResizable(false);
		frame.setVisible(true);	
		

	}
}