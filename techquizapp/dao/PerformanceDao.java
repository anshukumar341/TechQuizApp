/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.PerformancePojo;
import techquizapp.pojo.StudentScore;

/**
 *
 * @author Aftab
 */
public class PerformanceDao {
    
    public static ArrayList<String> getAllStudentId()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ArrayList<String> id=new ArrayList<>();
        ResultSet rs=st.executeQuery("select distinct userid from performance");
        while(rs.next())
            id.add(rs.getString(1));
        return id;
    }
    
    public static ArrayList<String> getAllExamId(String id)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select examid from performance where userid=?");
        ps.setString(1, id);
        ResultSet rs=ps.executeQuery();
        ArrayList<String> examid=new ArrayList<>();
        while(rs.next())
        {
            examid.add(rs.getString(1));
        }
        return examid;
    }
    
    public static StudentScore getStudentDetails(String id,String examId)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select language,per from performance where userid=? and examid=?");
        ps.setString(1, id);
        ps.setString(2, examId);
        ResultSet rs=ps.executeQuery();
        StudentScore score=new StudentScore();
        if(rs.next())
        {
            score.setLanguage(rs.getString(1));
            score.setPer(rs.getDouble(2));
        }
        
        return score;
    }
    
    public static ArrayList<PerformancePojo> getPerformance()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select * from performance");
        ArrayList<PerformancePojo> details=new ArrayList<>();
        while(rs.next())
        {
            PerformancePojo record=new PerformancePojo();
            record.setUserId(rs.getString(1));
            record.setExamId(rs.getString(2));
            record.setRight(rs.getInt(3));
            record.setWrong(rs.getInt(4));
            record.setUnattempted(rs.getInt(5));
            record.setPer(rs.getDouble(6));
            record.setLanguage(rs.getString(7));
            details.add(record);
        }  
        return details;
        
    }
    
    public static void addPerformance(PerformancePojo performance)throws SQLException
    {
        String qry="insert into performance values(?,?,?,?,?,?,?)";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, performance.getUserId());
        ps.setString(2, performance.getExamId());
        ps.setInt(3, performance.getRight());
        ps.setInt(4, performance.getWrong());
        ps.setInt(5, performance.getUnattempted());
        ps.setDouble(6, performance.getPer());
        ps.setString(7, performance.getLanguage());
        ps.executeUpdate();
    }
    
    public static StudentScore getScore(String studentId,String examId)throws SQLException{
       String qry="Select language,per from Performance where userid=? and examid=?";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,studentId);
        ps.setString(2,examId);
        ResultSet rs=ps.executeQuery();
        
        rs.next();
        StudentScore scoreObj=new StudentScore();
        scoreObj.setLanguage(rs.getString(1));
        scoreObj.setPer(rs.getDouble(2));
        return scoreObj;
        }

    
}
