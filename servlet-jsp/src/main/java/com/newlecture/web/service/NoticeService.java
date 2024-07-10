package com.newlecture.web.service;

import com.newlecture.web.entity.Notice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoticeService {
    public List<Notice> getNoticeList() {
        return getNoticeList("title", "", 1);
    }

    public List<Notice> getNoticeList(int page) {
        return getNoticeList("title", "", page);
    }

    public List<Notice> getNoticeList(String field/*TITLE, WRITER_ID*/, String query/*A*/, int page) {
        List<Notice> list = new ArrayList<>();

        String sql = "SELECT * FROM (" +
                "    SELECT ROWNUM NUM, N.* " +
                "    FROM (SELECT * FROM NOTICE WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N" +
                ") " +
                "WHERE NUM BETWEEN ? AND ?";

        // 1, 11, 21, 31 -> an = a1 + (page-1)*10
        // 10, 20, 30, 40 -> page*10
        String url = "jdbc:oracle:thin:@192.168.219.106:1521/ORCLPDB";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, "NEWLEC", "newlec");
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, "%"+query+"%");
            st.setInt(2, 1+(page-1)*10);
            st.setInt(3, page*10);

            ResultSet rs = st.executeQuery();

            while (rs.next()){
                int id = rs.getInt("ID");
                System.out.println(id);
                String title = rs.getString("TITLE");
                String writerId = rs.getString("WRITER_ID");
                Date regdate = rs.getDate("REGDATE");
                int hit = rs.getInt("HIT");
                String files = rs.getString("FILES");
                String content = rs.getString("CONTENT");

                Notice notice = new Notice(
                        id,
                        title,
                        writerId,
                        regdate,
                        hit,
                        files,
                        content
                );
                list.add(notice);
            }

            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public int getNoticeCount() {
        return getNoticeCount("title", "");
    }

    public int getNoticeCount(String field, String query) {

        int count = 0;


        String sql = "SELECT COUNT(ID) COUNT FROM (" +
                "    SELECT ROWNUM NUM, N.* " +
                "    FROM (SELECT * FROM NOTICE WHERE "+field+" LIKE ? ORDER BY REGDATE DESC) N" +
                ") ";

        String url = "jdbc:oracle:thin:@192.168.219.106:1521/ORCLPDB";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, "NEWLEC", "newlec");
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, "%"+query+"%");

            ResultSet rs = st.executeQuery();

            count = rs.getInt("count");

            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public Notice getNotice(int id){
        Notice notice = null;

        String sql = "SELECT * FROM NOTICE WHERE ID=?";

        String url = "jdbc:oracle:thin:@192.168.219.106:1521/ORCLPDB";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, "NEWLEC", "newlec");
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()){
                int nid = rs.getInt("ID");
                System.out.println(id);
                String title = rs.getString("TITLE");
                String writerId = rs.getString("WRITER_ID");
                Date regdate = rs.getDate("REGDATE");
                int hit = rs.getInt("HIT");
                String files = rs.getString("FILES");
                String content = rs.getString("CONTENT");

                notice = new Notice(
                        nid,
                        title,
                        writerId,
                        regdate,
                        hit,
                        files,
                        content
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return notice;
    }

    public Notice getNextNotice(int id){
        Notice notice = null;

        String sql = "SELECT * FROM NOTICE" +
                "WHERE ID = (" +
                "    SELECT ID FROM NOTICE" +
                "    WHERE REGDATE > (SELECT REGDATE FROM NOTICE WHERE ID = ?)" +
                "    AND ROWNUM = 1" +
                ")";

        String url = "jdbc:oracle:thin:@192.168.219.106:1521/ORCLPDB";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, "NEWLEC", "newlec");
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()){
                int nid = rs.getInt("ID");
                System.out.println(id);
                String title = rs.getString("TITLE");
                String writerId = rs.getString("WRITER_ID");
                Date regdate = rs.getDate("REGDATE");
                int hit = rs.getInt("HIT");
                String files = rs.getString("FILES");
                String content = rs.getString("CONTENT");

                notice = new Notice(
                        nid,
                        title,
                        writerId,
                        regdate,
                        hit,
                        files,
                        content
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return notice;
    }

    public Notice getPrevNotice(int id) {
        Notice notice = null;

        String sql = "SELECT * FROM NOTICE" +
                "WHERE ID = (" +
                "    SELECT ID FROM (SELECT * FROM NOTICE ORDER BY REGDATE DESC)" +
                "    WHERE REGDATE < (SELECT REGDATE FROM NOTICE WHERE ID = ?)" +
                "    AND ROWNUM = 1" +
                ")";

        String url = "jdbc:oracle:thin:@192.168.219.106:1521/ORCLPDB";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, "NEWLEC", "newlec");
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()){
                int nid = rs.getInt("ID");
                System.out.println(id);
                String title = rs.getString("TITLE");
                String writerId = rs.getString("WRITER_ID");
                Date regdate = rs.getDate("REGDATE");
                int hit = rs.getInt("HIT");
                String files = rs.getString("FILES");
                String content = rs.getString("CONTENT");

                notice = new Notice(
                        nid,
                        title,
                        writerId,
                        regdate,
                        hit,
                        files,
                        content
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return notice;
    }
}