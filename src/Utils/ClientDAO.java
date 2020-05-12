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
import Model.ClientInfo;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class ClientDAO {
  public void insert(ClientInfo person){
        Session session =Utils.Libconnect.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
}     
    
 public List<ClientInfo> select(){
      Session session =Utils.Libconnect.getSessionFactory().openSession();
      Transaction transaction= session.beginTransaction();
      String HQL = "from ClientInfo";
      Query query = session.createQuery(HQL);
      
      List<ClientInfo> list = query.list();

      transaction.commit();
      session.close();
      return list;
     } 
  
}
