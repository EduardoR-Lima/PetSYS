package petsys.gui;

import java.awt.Dimension;

/**
 * Todos os valores foram definidos durante a prototipagem no figma
 */
public interface SideBarConstants {
	
	/**
	 * O tamanho padrão definido para botões que vão ser adicionados à barra lateral
	 */
	public static final Dimension PREFERRED_BUTTON_SIZE = new Dimension(0, 60);
	
	/**
	 * Pad entre a borda lateral esquerda e o componenet
	 */
	public static final int LEFT_PAD = 60;
	
	/**
	 * Pad entre a borda lateral direita e o component
	 */
	public static final int RIGHT_PAD = -60;
	
	/**
	 * Pad entre a borda de cima da barra lateral e o primeiro component
	 */
	public static final int TOP_PAD = 70;
	
	/**
	 * Pad entre components
	 */
	public static final int BETWEEN_PAD = 40;
}
