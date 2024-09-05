package petsys.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import petsys.database.models.Model;

public class ResultFilter<T extends Model> implements CustomComponent<JComboBox<String>>, Populateable<T> {

	private JComboBox<String> comboBox;
	private EntryHandler<T> eHandler;

	public ResultFilter(String nome) {
		comboBox = new JComboBox<>();
		comboBox.insertItemAt(null, 0);
		comboBox.setRenderer(new PromptComboBoxRenderer("[ %s ]".formatted(nome)));
		comboBox.setPreferredSize(new Dimension(130, 30));

	}

	public void setPopulateEntryHandler(EntryHandler<T> handler) {
		this.eHandler = handler;
	}
	
	public String applyEntryHandler(T model) {
		return eHandler.handle(model);
	}

	public void setSelectionCallBack(SCallback callback) {
		comboBox.addItemListener(e -> {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				callback.run((String) e.getItem());
			} else if (comboBox.getSelectedItem() == null) {
				callback.run(null);
			}
		});
	}

	public void populate(List<T> models) {
		List<String> insertedValues = new ArrayList<>();
		for (T model : models) {
			String filterLine = applyEntryHandler(model);
			
			if (filterLine != null && !insertedValues.contains(filterLine)) {
				comboBox.addItem(filterLine);
				insertedValues.add(filterLine);
			}
		}
	}
	
	public void clearItems() {
		comboBox.removeAllItems();
		comboBox.insertItemAt(null, 0);
	}

	@Override
	public JComboBox<String> getBaseComponent() {
		return comboBox;
	}

	@SuppressWarnings("serial")
	private static class PromptComboBoxRenderer extends BasicComboBoxRenderer {

		private String prompt;

		public PromptComboBoxRenderer(String prompt) {
			super();
			this.prompt = prompt;
			setHorizontalAlignment(CENTER);
		}

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

			if (value == null) {
				setText(prompt);
			}
			return this;
		}
	}

	public interface SCallback {
		public void run(String selectedItem);
	}

}
