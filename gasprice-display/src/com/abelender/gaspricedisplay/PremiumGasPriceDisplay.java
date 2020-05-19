package com.abelender.gaspricedisplay;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PremiumGasPriceDisplay extends JPanel {
	
	BufferedImage productImage;
	JLabel imageLabel;
	JLabel priceLabel;
	PersonalFont font;
	
	public PremiumGasPriceDisplay(String price) {
	
		try {
			productImage = ImageIO.read(new File("premium.jpg"));
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
