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
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.QuestionPojo;
import techquizapp.pojo.QuestionStore;

/**
 *
 * @author Aftab
 */
public class QuestionDao {
    public static void addQuestions(QuestionStore qstore)throws SQLException{
       String qry="Insert into questions values(?,?,?,?,?,?,?,?,?)";
       ArrayList <QuestionPojo> questionList=qstore.getAllQuestions();
        Connection conn=DBConnection.getConnection();
           PreparedStatement ps=conn.prepareStatement(qry);
          for(QuestionPojo obj:questionList){
           ps.setString(1, obj.getExamid());
           ps.setInt(2, obj.getQno());
           ps.setString(3,obj.getQuestion());
           ps.setString(4, obj.getAnswer4());
           ps.setString(5,obj.getAnswer2());
           ps.setString(6,obj.getAnswer3());
           ps.setString(7,obj.getAnswer4());
           ps.setString(8,obj.getCorrectAnswer());
           ps.setString(9, obj.getLanguage());
           ps.executeUpdate();
           }
      }
    
    public static ArrayList<QuestionPojo> getQuestionByExamId(String examid)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from questions where examid=? order by qno");
        ps.setString(1, examid);
        ResultSet rs=ps.executeQuery();
        ArrayList<QuestionPojo> allQuestions=new ArrayList<>();
        while(rs.next())
        {
            QuestionPojo question=new QuestionPojo();
            question.setExamid(rs.getString(1));
            question.setQno(rs.getInt(2));
            question.setQuestion(rs.getString(3));
            question.setAnswer1(rs.getString(4));
            question.setAnswer2(rs.getString(5));
            question.setAnswer3(rs.getString(6));
            question.setAnswer4(rs.getString(7));
            question.setCorrectAnswer(rs.getString(8));
            question.setLanguage(rs.getString(9));
            allQuestions.add(question);
            
        }
        return allQuestions;
        
    }
    
    public static ArrayList<QuestionPojo> getQuestionsForEdit(String language,String examId)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from questions where language=? and examid=?");
        ps.setString(1, language);
        ps.setString(2, examId);
        ResultSet rs=ps.executeQuery();
        ArrayList<QuestionPojo> questions=new ArrayList<>();
        while(rs.next())
        {
            QuestionPojo question=new QuestionPojo();
             question.setExamid(rs.getString(1));
            question.setQno(rs.getInt(2));
            question.setQuestion(rs.getString(3));
            question.setAnswer1(rs.getString(4));
            question.setAnswer2(rs.getString(5));
            question.setAnswer3(rs.getString(6));
            question.setAnswer4(rs.getString(7));
            question.setCorrectAnswer(rs.getString(8));
            question.setLanguage(rs.getString(9));
            questions.add(question);
        }
        return questions;
    }
    
    public static void updateQuestions(QuestionStore qstore)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update questions set question=?,answer1=?,answer2=?,answer3=?,answer4=?,correct_answer=? where language=? and examid=? and qno=?");
         ArrayList <QuestionPojo> questionList=qstore.getAllQuestions();
        for(QuestionPojo obj:questionList){
           ps.setString(1, obj.getQuestion());
           ps.setString(2, obj.getAnswer1());
           ps.setString(3, obj.getAnswer2());
           ps.setString(4, obj.getAnswer3());
           ps.setString(5, obj.getAnswer4());
           ps.setString(6, obj.getCorrectAnswer());
           ps.setString(7, obj.getLanguage());
           ps.setString(8, obj.getExamid());
           ps.setInt(9, obj.getQno());
           ps.executeUpdate();
           }
    }

    
}
