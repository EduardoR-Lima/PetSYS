package petsys.gui;

import petsys.database.models.Model;

public interface Populateable<T extends Model> {
	public void setPopulateEntryHandler(EntryHandler<T> handler);

	public void populate(T[] values);

	public interface EntryHandler<T> {
		public String handle(T model);
	}
}
