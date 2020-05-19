package com.abelender.gaspricedisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DieselGasPriceDisplay extends JPanel {
	
	BufferedImage productImage;
	JLabel imageLabel;
	JLabel priceLabel;
	PersonalFont font;
	
	private String productPrice;
	
	public DieselGasPriceDisplay(String price) {
	
		try {
			productImage = ImageIO.read(new File("diesel.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		font = new PersonalFont();
		priceLabel = new JLabel(price);
		priceLabel.setBackground(Color.BLACK);
		priceLabel.setOpaque(true);
		priceLabel.setFont(font.getFont());
		priceLabel.setForeground(Color.WHITE);

		imageLabel = new JLabel(new ImageIcon(productImage));
		add(imageLabel);
		add(priceLabel);
	}
}
