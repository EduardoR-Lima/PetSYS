package petsys.gui;

import java.awt.Component;

public interface CustomComponent<T extends Component> {
	
	public T getBaseComponent();
}
