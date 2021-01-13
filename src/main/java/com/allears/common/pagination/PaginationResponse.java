package com.allears.common.pagination;

import java.util.List;

public class PaginationResponse<T>  {

    private List<T> rows;

    private int totalPages;

    private int totalRecords;

    private int page;

    private int reqRows;
    
    private String pageId;

    /**
     * PaginationResponse 생성자
     * @param rows 목록
     * @param totalRecords 전체 목록 개수
     * @param page 요청 페이지
     * @param reqRows 요청 페이지 당 항목 개수
     */
    public PaginationResponse(List<T> rows, int totalRecords, int page, int reqRows) {
        this.rows = rows;
        this.totalRecords = totalRecords;
        this.reqRows = reqRows;
        this.page = page;
        this.totalPages = calculateTotalPages();  // 전체 페이지 수를 계산한다
    }
    
    /**
     * PaginationResponse 생성자
     * @param rows 목록
     * @param totalRecords 전체 목록 개수
     * @param page 요청 페이지
     * @param reqRows 요청 페이지 당 항목 개수
     * @param pageId 페이지처리를 위한 고유 아이디
     */
    public PaginationResponse(List<T> rows, int totalRecords, int page, int reqRows,String pageId) {
        this.rows = rows;
        this.totalRecords = totalRecords;
        this.reqRows = reqRows;
        this.page = page;
        this.pageId = pageId;
        this.totalPages = calculateTotalPages();  // 전체 페이지 수를 계산한다
    }

    /**
     * @param rows the rows to set
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    /**
     * @return the rows
     */
    public List<T> getRows() {
        return rows;
    }
    /**
     * @param totalPages the totalPages to set
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    /**
     * 
     */
    public int calculateTotalPages() {
        return (totalRecords / reqRows) + (totalRecords % reqRows == 0 ? 0 : 1);
    }
    /**
     * @return the totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }
    /**
     * @param totalRecords the totalRecords to set
     */
    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }
    /**
     * @return the totalRecords
     */
    public int getTotalRecords() {
        return totalRecords;
    }
    /**
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }
    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }
    /**
     * @param reqRows the reqRows to set
     */
    public void setReqRows(int reqRows) {
        this.reqRows = reqRows;
    }
    /**
     * @return the reqRows
     */
    public int getReqRows() {
        return reqRows;
    }

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
}