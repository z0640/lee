package DAO;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConnection {
   static Connection conn=null;
   
   public static Connection connect() {
      try {   
         // JNDI(���̹�) ���񽺸� ���� DataSource ��ü�� lookup()
         Context initContext = new InitialContext(); // ���ؽ�Ʈ ��ü�� ����
         String path="java:/comp/env/";
         String dePath="jdbc/mysql"; // JNDI ����� �̸���
         DataSource ds = (DataSource) initContext.lookup(path+dePath);
         conn = ds.getConnection();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return conn;
   }
}
