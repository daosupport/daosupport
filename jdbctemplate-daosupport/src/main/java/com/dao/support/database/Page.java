package com.dao.support.database;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 分页对象. 包含当前页数据及分页信息如总记录数.
 */
@SuppressWarnings("serial")
public class Page<T>  implements Serializable {

	private static int DEFAULT_PAGE_SIZE = 20;

	private int pageSize = DEFAULT_PAGE_SIZE; // 每页的记录数

	
	private List<T> data; // 当前页中存放的记录,类型一般为List

	@JsonProperty("recordsTotal")  
	private long totalCount; // 总记录数
	
	
	private long  currentPageNo=1;
	 
	
	/**
	 * 构造方法，只构造空页.
	 */
	public Page() {
		this(0, 0, DEFAULT_PAGE_SIZE, new ArrayList<T>());
	}

	
	public int getRecordsFiltered(){
		
		return Integer.valueOf(""+ this.totalCount);
	}
	
	/**
	 * 默认构造方法.
	 * 
	 * @param currentPageNo
	 *           当前页码
	 * @param totalSize
	 *            数据库中总记录条数
	 * @param pageSize
	 *            本页容量
	 * @param data
	 *            本页包含的数据
	 */
	public Page(long currentPageNo, long totalSize, int pageSize, List<T> data) {
		setParam(currentPageNo, totalSize, pageSize, data);
	}

	public void setParam(long currentPageNo, long totalSize, int pageSize, List<T> data) {
		this.pageSize = pageSize;
		this.currentPageNo = currentPageNo;
		this.totalCount = totalSize;
		this.data = data;
	}

	/**
	 * 取总记录数.
	 */
	public long getTotalCount() {
		return this.totalCount;
	}

	/**
	 * 取总页数.
	 */
	public long getTotalPageCount() {
		if (totalCount % pageSize == 0)
			return totalCount / pageSize;
		else
			return totalCount / pageSize + 1;
	}

	/**
	 * 取每页数据容量.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 取当前页中的记录.
	 */
	@JsonProperty("data")  
	public List<T> getResult() {
		return data;
	}

	/**
	 * 取该页当前页码,页码从1开始.
	 */
	public long getCurrentPageNo() {
		return this.currentPageNo;
	}

	/**
	 * 该页是否有下一页.
	 */
	public boolean hasNextPage() {
		return this.getCurrentPageNo() < this.getTotalPageCount() - 1;
	}

	/**
	 * 该页是否有上一页.
	 */
	public boolean hasPreviousPage() {
		return this.getCurrentPageNo() > 1;
	}
 
	public void setCurrentPageNo(long pageNo){
		this.currentPageNo = pageNo;
	}
}