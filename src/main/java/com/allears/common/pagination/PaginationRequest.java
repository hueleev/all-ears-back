package com.allears.common.pagination;

import com.fasterxml.jackson.annotation.JsonInclude;

public class PaginationRequest {

    /**
     * 요청 페이지
     */
    @JsonInclude(value= JsonInclude.Include.NON_DEFAULT)
    private int page;

    /**
     * 한 페이지 항목 수
     */
    @JsonInclude(value= JsonInclude.Include.NON_DEFAULT)
    private int rows;

    /**
     * 정렬 컬럼
     */
    @JsonInclude(value= JsonInclude.Include.NON_EMPTY)
    private String sidx;

    /**
     * 정렬 방향
     */
    @JsonInclude(value= JsonInclude.Include.NON_EMPTY)
    private String sord;
    
    /**
     * 페이지 아이디
     */
    @JsonInclude(value= JsonInclude.Include.NON_EMPTY)
    private String pageId;

    /**
     * 검색어
     */
    @JsonInclude(value= JsonInclude.Include.NON_EMPTY)
    private String searchWord;



    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }
    /**
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }
    /**
     * @return the rows
     */
    public int getRows() {
        return rows;
    }
    /**
     * @param rows the rows to set
     */
    public void setRows(int rows) {
        this.rows = rows;
    }
    public int getFirstIndex() {
        return (page - 1) * rows;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }
}