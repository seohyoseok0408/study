package com.newlecture.web.entity;

import java.sql.Date;

public class NoticeView extends Notice{
    private int cmtCount;

    public int getCmtCount() {
        return cmtCount;
    }

    public void setCmtCount(int cmtCount) {
        this.cmtCount = cmtCount;
    }

    public NoticeView() {

    }
    public NoticeView(int id, String title, String writerId, Date regdate, int hit, String files, boolean pub, int cmtCount) {
        super(id, title, writerId, regdate, hit, files, "", pub);
        this.cmtCount = cmtCount;
    }
}
