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
import techquizapp.pojo.ExamPojo;

/**
 *
 * @author Aftab
 */
public class ExamDao {
    public static String getExamId()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet result=st.executeQuery("select count(*) as record from exam");
        int count=0;
        if(result.next())
         count=result.getInt(1);
        String newId="EX-"+(count+1);
        return newId;
        
    }
    
    public static void addExam(ExamPojo newExam)throws SQLException{
 String qry="Insert into Exam values(?,?,?)";
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, newExam.getExamId());
        ps.setString(2, newExam.getLanguage());
        ps.setInt(3,newExam.getTotalQuestions());
        ps.executeUpdate();
      }
    
    public static ArrayList<String> getLanguage()throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select distinct language from exam");
        ArrayList<String> language=new ArrayList<>();
        while(rs.next())
        {
            language.add(rs.getString(1));
        }
        return language;
    }
    
    public static ArrayList<String> getExamId(String language)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select distinct examid from exam where language=?");
        ps.setString(1, language);
        ArrayList<String> examid=new ArrayList<>();
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
            examid.add(rs.getString(1));
        }
        return examid;
    }

    public static int getQuestionCountByExam(String examid)throws SQLException{
        Connection conn=DBConnection.getConnection();
        String qry="select total_question from exam where examId=?";
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1, examid);
        ResultSet rs=ps.executeQuery();
        rs.next();
        int rowCount=rs.getInt(1);
        return rowCount;
    }
    
    public static boolean isPaperSet(String subject)throws SQLException{
       String qry="Select examid from Exam where language=? ";       
           Connection conn=DBConnection.getConnection();
           PreparedStatement ps=conn.prepareStatement(qry);
           ps.setString(1,subject);
           ResultSet rs=ps.executeQuery();
           return rs.next();
        
    }
    
 /*   public static int getQuestionCountByExam(String examId)throws SQLException{
        String qry="select total_question from Exam where examid=?";
        Connection conn=DBConnection.getConnection();
          PreparedStatement ps=conn.prepareStatement(qry);
          ps.setString(1,examId);
          ResultSet rs=ps.executeQuery();
	    rs.next();
          int rowCount=rs.getInt(1);
          return rowCount;
        }*/
    
    public static ArrayList<String> getExamIdBySubject(String userid,String subject)throws SQLException{
       String qry="Select examid from Exam where language=? minus Select examid from performance where userid=?";
       ArrayList<String> examList=new ArrayList<>();
       Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement(qry);
        ps.setString(1,subject);
        ps.setString(2,userid);
        ResultSet rs=ps.executeQuery();
       while(rs.next()){
               examList.add(rs.getString(1));
           }
         return examList;        
    }


}
