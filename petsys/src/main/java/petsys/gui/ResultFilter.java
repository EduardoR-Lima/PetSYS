package petsys.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import petsys.database.models.Model;
import petsys.gui.Populateable.EntryHandler;

public class ResultFilter<T extends Model> implements CustomComponent<JComboBox<String>>, Populateable<T> {

	private JComboBox<String> comboBox;
	private EntryHandler<T> eHandler;

	public ResultFilter(String nome) {
		comboBox = new JComboBox<>();
		comboBox.setRenderer(new PromptComboBoxRenderer("[ %s ]".formatted(nome)));
		comboBox.setPreferredSize(new Dimension(130, 30));

	}

	public void setPopulateEntryHandler(EntryHandler<T> handler) {
		this.eHandler = handler;
	}

	public void setSelectionCallBack(SCallback callback) {

		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.DESELECTED) {
					return;
				}

				String item = (String) e.getItem();

				if (item == null) {
					return;
				}

				callback.run(item);
			}
		});
	}

	public void populate(T[] values) {
		for (T value : values) {
			String filterLine = eHandler.handle(value);
			if (filterLine != null) {
				comboBox.addItem(filterLine);
			}
		}
	}
	
	public void clearItems() {
		comboBox.removeAllItems();
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
