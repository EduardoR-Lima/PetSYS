package petsys.gui;

import java.awt.Component;

public interface CardComponent<T extends Component> extends CustomComponent<T> {
	
	public String getCardId();
}
