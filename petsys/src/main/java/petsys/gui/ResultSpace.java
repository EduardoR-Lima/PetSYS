package petsys.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import petsys.database.models.Model;

public class ResultSpace<T extends Model> implements CustomComponent<JScrollPane>, Populateable<T> {
	
	private boolean hasVisualizeButton = false;

	private JScrollPane basePanel;
	private JPanel contentPanel;
	private JPanel contentPanel2;
	private EntryHandler<T> eHandler;
	
	public ResultSpace() {
		basePanel = new JScrollPane();
		basePanel.setBorder(null);
		contentPanel = new JPanel();
		contentPanel.setLayout(new BorderLayout(10, 10));
		contentPanel.setBorder(new EmptyBorder(20, 20, 10, 20));
		contentPanel2 = new JPanel(new GridLayout(0, 1, 10, 10));
		contentPanel.add(contentPanel2, BorderLayout.NORTH);
		basePanel.setViewportView(contentPanel);
	}

	@Override
	public void setPopulateEntryHandler(EntryHandler<T> handler) {
		this.eHandler = handler;
	}

	@Override
	public void populate(List<T> values) {
		for (T value : values) {
			String entryLabel = eHandler.handle(value);
			if (entryLabel != null) {
				ResultEntry entry = new ResultEntry(entryLabel, hasVisualizeButton);
				contentPanel2.add(entry.getBaseComponent());
			}
		}
 	}
	
	public void setHasVisualizeButton(boolean flag) {
		hasVisualizeButton = flag;
	}
	
	public void clearSpace() {
		contentPanel2.removeAll();
	}
	
	@Override
	public JScrollPane getBaseComponent() {
		return basePanel;
	}

}
