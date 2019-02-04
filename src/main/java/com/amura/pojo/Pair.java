package com.amura.pojo;

/**
 * 
 * @author sushil
 * 
 * This class is used to store index(start, end) as Pair 
 * of the subarray with largest sum
 */
public class Pair {
	int start, end;

	public Pair() {
	}

	public Pair(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + end;
		result = prime * result + start;
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
		Pair other = (Pair) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pair [start=" + start + ", end=" + end + "]";
	}
}
