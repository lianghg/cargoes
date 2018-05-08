package cargoes.plugin.paging;

public class PagePlugin<E> {

	/**
     * 页码
     */
    private int pageNum;
    /**
     * 单页记录数量
     */
    private int pageSize;
    
    /**
     * 总记录数量
     */
    private long total;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 数据
     */
    private E data;
    
    
	public PagePlugin() {
		super();
	}
	
	public PagePlugin(int pageNum, int pageSize, long total, E data) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.total = total;
		this.data = data;
		if (pageSize > 0) {
            pages = (int) (total / pageSize + ((total % pageSize == 0) ? 0 : 1));
        } else {
            pages = 0;
        }
	}

	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public int getPages() {
		if (pageSize > 0) {
            pages = (int) (total / pageSize + ((total % pageSize == 0) ? 0 : 1));
        } else {
            pages = 0;
        }
		return pages;
	}
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
    
}
