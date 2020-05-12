/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

/**
 *
 * @author AAAA
 */
import Model.BookInfo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class BookDAO {
    
    public void insert(BookInfo book){
        Session session =Utils.Libconnect.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
}
   
    
    public List<BookInfo> select(){
      Session session =Utils.Libconnect.getSessionFactory().openSession();
      Transaction transaction= session.beginTransaction();
      String HQL = "from BookInfo";
      Query query = session.createQuery(HQL);
      
      List<BookInfo> list = query.list();

      transaction.commit();
      session.close();
      return list;
     } 
   
    
}
