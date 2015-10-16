package com.onlinemarketplace.dataentity.dto;

import java.util.List;

public class Pagenation<T> {

	private List<T> Result;
	private int iCount;
	private int iPageNo;
	private int iPageSize;
	private int iStart;
	private int iEnd;
	public Pagenation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<T> getResult() {
		return Result;
	}
	public void setResult(List<T> result) {
		Result = result;
	}
	public int getiCount() {
		return iCount;
	}
	public void setiCount(int iCount) {
		this.iCount = iCount;
	}
	public int getiPageNo() {
		return iPageNo;
	}
	public void setiPageNo(int iPageNo) {
		this.iPageNo = iPageNo;
	}
	public int getiPageSize() {
		return iPageSize;
	}
	public void setiPageSize(int iPageSize) {
		this.iPageSize = iPageSize;
	}
	
	public int getiStart() {
		return iStart;
	}
	public void setiStart(int iStart) {
		this.iStart = iStart;
	}
	public int getiEnd() {
		return iEnd;
	}
	public void setiEnd(int iEnd) {
		this.iEnd = iEnd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Result == null) ? 0 : Result.hashCode());
		result = prime * result + iCount;
		result = prime * result + iEnd;
		result = prime * result + iPageNo;
		result = prime * result + iPageSize;
		result = prime * result + iStart;
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
		Pagenation other = (Pagenation) obj;
		if (Result == null) {
			if (other.Result != null)
				return false;
		} else if (!Result.equals(other.Result))
			return false;
		if (iCount != other.iCount)
			return false;
		if (iEnd != other.iEnd)
			return false;
		if (iPageNo != other.iPageNo)
			return false;
		if (iPageSize != other.iPageSize)
			return false;
		if (iStart != other.iStart)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Pagenation [Result=" + Result + ", iCount=" + iCount + ", iPageNo=" + iPageNo + ", iPageSize="
				+ iPageSize + ", iStart=" + iStart + ", iEnd=" + iEnd + "]";
	}
	public Pagenation(List<T> result, int iCount, int iPageNo, int iPageSize, int iStart, int iEnd) {
		super();
		Result = result;
		this.iCount = iCount;
		this.iPageNo = iPageNo;
		this.iPageSize = iPageSize;
		this.iStart = iStart;
		this.iEnd = iEnd;
	}
	public Pagenation(List<T> result) {
		super();
		Result = result;
		this.iStart = 0;
		this.iEnd = result.size();
		this.iCount = result.size();
	}
	
	 

}
