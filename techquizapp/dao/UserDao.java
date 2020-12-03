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
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.UserPojo;

/**
 *
 * @author Aftab
 */
public class UserDao {
    
    public static boolean validateUser(UserPojo user)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select userid from users where userid=? and password=? and usertype=?");
        ps.setString(1, user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet rs=ps.executeQuery();
        return rs.next();
           
        
    }
  public static boolean addUser(UserPojo user)throws SQLException
  {
      boolean result=true;
      Connection conn=DBConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("select * from users where userid=?");
      ps.setString(1, user.getUserId());
      ResultSet rs=ps.executeQuery();
      if(rs.next())
          result=false;
      else
      {
          ps=conn.prepareStatement("insert into users values(?,?,?)");
          ps.setString(1, user.getUserId());
          ps.setString(2, user.getPassword());
          ps.setString(3, user.getUserType());
          int count=ps.executeUpdate();
      }
      return result;
    
  }
  
  
  public static boolean changePassword(String userid,String password)throws SQLException
  {
      Connection conn=DBConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("update users set password=? where userid=?");
      ps.setString(1, password);
      ps.setString(2, userid);
      int count=ps.executeUpdate();
      return (count!=0);
  }
}
