package com.abelender.gaspricedisplay;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProductLabel extends JPanel{
	
	private JLabel nameLabel;
	private JLabel priceLabel;
	BufferedImage myPicture;
	JLabel picLabel;
	

	public ProductLabel(String productName, Color bg) {
		
		try {
			myPicture = ImageIO.read(new File("regular.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		picLabel = new JLabel(new ImageIcon(myPicture));
		
		
		nameLabel = new JLabel(productName);
		priceLabel = new JLabel("13.87");
		
		nameLabel.setOpaque(true);
		nameLabel.setBackground(Color.GRAY);
		
		priceLabel.setOpaque(true);
		priceLabel.setBackground(Color.ORANGE);
		
		add(picLabel);
		add(nameLabel);
		add(priceLabel);
		
		setBackground(bg);
		
	}
}
