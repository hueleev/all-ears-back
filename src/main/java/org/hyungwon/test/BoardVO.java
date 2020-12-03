package org.hyungwon.test;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BoardVO {
    private int boardSeq;
    private String boardTitle;
    private String boardCn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+9")
    private Date cretDt;
    private String cretrId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+9")
    private Date amdDt;
    private String amdrId;

    public int getBoardSeq() {
        return boardSeq;
    }

    public void setBoardSeq(int boardSeq) {
        this.boardSeq = boardSeq;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardCn() {
        return boardCn;
    }

    public void setBoardCn(String boardCn) {
        this.boardCn = boardCn;
    }

    public Date getCretDt() {
        return cretDt;
    }

    public void setCretDt(Date cretDt) {
        this.cretDt = cretDt;
    }

    public String getCretrId() {
        return cretrId;
    }

    public void setCretrId(String cretrId) {
        this.cretrId = cretrId;
    }

    public Date getAmdDt() {
        return amdDt;
    }

    public void setAmdDt(Date amdDt) {
        this.amdDt = amdDt;
    }

    public String getAmdrId() {
        return amdrId;
    }

    public void setAmdrId(String amdrId) {
        this.amdrId = amdrId;
    }
}
