package com.abelender.gaspricedisplay;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GasApp {

	public static void main(String[] args) {
		
		/*
		 *  		CREATE OBJECTS TO HANDLE ACTUAL PRODUCT PRICES 	
		 */
		
		
		// Create ContentHandler object for the parser
		ContentHandler handler = new ContentHandler();
		
		// Parsing XML from product prices online site
		SaxParser sax = new SaxParser(handler, "https://bit.ly/2JNcTha");
		
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
	


		JFrame frame = new JFrame("Testing");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(mainPanel);
	
		frame.pack();
		frame.setMinimumSize( frame.getSize() );

		frame.setResizable(false);
		frame.setVisible(true);	
	}
}