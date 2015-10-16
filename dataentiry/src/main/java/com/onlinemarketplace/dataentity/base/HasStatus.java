package com.onlinemarketplace.dataentity.base;

public class HasStatus<T> extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8503241249630749847L;
	
	private T status;

	public T getStatus() {
		return status;
	}

	public void setStatus(T status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HasStatus other = (HasStatus) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StateFull [state=" + status + "]";
	}
	 
}
