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
import Model.Checkinout;
import Model.ClientInfo;
import Model.BookInfo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OperationsDAO {
    
    public void insert(Checkinout check){
        Session session =Utils.Libconnect.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(check);
        transaction.commit();
        session.close();
}     
  
    public List<Checkinout> select(){
      Session session =Utils.Libconnect.getSessionFactory().openSession();
      Transaction transaction= session.beginTransaction();
      String HQL = "from Checkinout";
      Query query = session.createQuery(HQL);
      
      List<Checkinout> list = query.list();

      transaction.commit();
      session.close();
      return list;
     } 
    
   
    
}
