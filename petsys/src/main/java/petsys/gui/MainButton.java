package petsys.gui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class MainButton implements CustomComponent<JButton> {
	public static final Dimension DEFAULT_SIZE = new Dimension(0, 60);
	public static final int DEFAULT_TEXT_SIZE = 15;
	
	private JButton button;

	public MainButton(String label, Dimension buttonSize, int textSize) {
		button = new JButton(label);
		setFontSize(textSize);
		button.setPreferredSize(buttonSize);
	}
	
	public MainButton(String label) {
		this(label, DEFAULT_SIZE, DEFAULT_TEXT_SIZE);
	}
	
	public void setFontSize(int size) {
		Font currentFont = button.getFont();
		Font newFont = new Font(currentFont.getFamily(), currentFont.getStyle(), size);
		button.setFont(newFont);
	}
	
	@Override
	public JButton getBaseComponent() {
		return button;
	}
	
}
