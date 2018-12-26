package org.hibernate.firstapplication;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

/**
 * Hello world!
 *
 */
//Session save or session.begin and get and commit (Only from Both Works)
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        System.out.println("Session Files Loaded");
        session.beginTransaction();
        System.out.println("Trans Begin");
        Contacts contact = new Contacts();
        contact.setFname("Shit");
        contact.setLname("Mit");
        contact.setId(5);
        session.save(contact);
        session.getTransaction().commit();
        Query q = session.createQuery("from contacts");
        List<Contacts> resultList = q.list();
        System.out.println("num of employees:");
        for (Contacts next: resultList)
        	System.out.println(next.getId());
        //Fetching a record with ID
        q = session.createQuery("FROM contacts where id = 1");
        resultList = q.list();
        session.beginTransaction(); //If you want to update;
        for (Contacts next: resultList)
        {	System.out.println(next.getId());
        	next.setFname("Google1");
        	//session.save(next); //If This is used then we don't need beginTransaction / getTransaction/ Commit;
        }
        session.getTransaction().commit();
        //Transaction Commit only required in case session is used to save. The session's transmissions need getTransaction and commit.
        
        //Inserting A Record
        String hql = "INSERT INTO contacts(lname,fname) values"+" (\'First\',\'Last\')";
        Query query = session.createQuery(hql);
        int result;// = query.executeUpdate();
        
        //Both Query and Session.createQuery can be used.
        //Updating A Record
        hql = "UPDATE contacts SET fname = \'Boy\' where id = 1";
        //query = session.createQuery(hql);
        //query.setParameter("fname", "Great");
        //query.setParameter("id", 1);
        //query.executeUpdate();
        query = session.createQuery(hql);
        //query.executeUpdate();
        
        
        //Deleting A Record
        hql = "DELETE FROM contacts "  + 
                "WHERE id = :employee_id";
        query = session.createQuery(hql);
        query.setParameter("employee_id", 10);
        result = query.executeUpdate();
        System.out.println("Rows affected: " + result);
        
    }
}
