package com.abelender.gaspricedisplay;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class PersonalFont {
	
	private Font font = null; 
	
	PersonalFont() {
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File("7-segment.ttf"));
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);
			font = font.deriveFont(142f);

	    
		} catch (IOException | FontFormatException e) {

			e.printStackTrace();
		} 
	}
	
	public Font getFont() {
		return font;
	}

}
