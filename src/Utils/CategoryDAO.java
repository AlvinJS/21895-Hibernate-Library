/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Model.BookCategory;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author AAAA
 */
public class CategoryDAO {
  public void insert(BookCategory category){
        Session session =Utils.Libconnect.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(category);
        transaction.commit();
        session.close();
}
  
   public List<BookCategory> select(){
      Session session =Utils.Libconnect.getSessionFactory().openSession();
      Transaction transaction= session.beginTransaction();
      String HQL = "from BookCategory";
      Query query = session.createQuery(HQL);
      
      List<BookCategory> list = query.list();

      transaction.commit();
      session.close();
      return list;
     } 
}
