package petsys.database.models;

import java.util.Arrays;
import java.util.Objects;

public abstract class AbstractSearchKey<T extends Model> {
	protected String name;
	protected String[] keys;
	
	public AbstractSearchKey(String[] keys, String name) {
		this.name = name;
		this.keys = keys;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(keys);
		result = prime * result + Objects.hash(name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractSearchKey other = (AbstractSearchKey) obj;
		return Arrays.equals(keys, other.keys) && Objects.equals(name, other.name);
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
