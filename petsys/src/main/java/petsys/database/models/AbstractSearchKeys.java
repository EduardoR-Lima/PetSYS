package petsys.database.models;

public abstract class AbstractSearchKeys<T extends Model> {
	protected String name;
	protected String[] keys;
	
	public AbstractSearchKeys(String[] keys, String name) {
		this.name = name;
		this.keys = keys;
	}
	
	public String[] getKey() {
		return keys;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
