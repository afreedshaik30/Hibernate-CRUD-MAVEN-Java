package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.entity.Product;

public class App 
{
	public static void main( String[] args )
    {
        // Load configuration and build the session factory
        Configuration cfg = new Configuration();
        cfg.configure("/com/example/config/hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
  	    Transaction transaction = session.beginTransaction();
  	    
       try 
       {

    	  // 1.INSERTION ---- INSERT
//    	  Product addProduct = new Product();
//    	  addProduct.setPname("j phone");
//    	  addProduct.setPrice(99800);
//    	  session.persist(addProduct);
//    	  transaction.commit();
//    	  System.out.println("1. Product INSERTED");
    	   
    	  // 2.READ Product by ID ---- SELECT
//    	  Product readProduct = session.get(Product.class, 2);
//    	  if(readProduct != null)
//    	  {
//    		  System.out.println(readProduct);
//    	  }
//    	  else
//    	  {
//    		  System.out.println("NOT FOUND");
//    	  }
    	   
    	  // 3.UPDATE by ID
//    	   Product updateProduct =session.get(Product.class, 4);
//    	   if(updateProduct != null)
//    	   {
//    		   updateProduct.setPname("IPHONE");
//    		   updateProduct.setPrice(789123);
//    		   session.saveOrUpdate(updateProduct);
//    		   transaction.commit();
//    		   System.out.println("UPDATED");
//    	   }
//    	   else
//    	   {
//    		   System.out.println("NOT UPDATED");
//    	   }
    	   
    	  // 4. DELETE by ID  
//    	   Product deleteProduct = session.get(Product.class,3);
//    	   if(deleteProduct != null)
//    	   {
//    		   session.delete(deleteProduct);
//    		   transaction.commit();
//    		   System.out.println("DELETED");
//    	   }
//    	   else
//    	   {
//    		   System.out.println("NOT deleted");
//    	   }
    	   
    	   // 5. read all products ---- SELECT *
    	   List<Product> allProducts = session.createQuery("from Product",Product.class).list();
           for(Product singleProduct : allProducts)
           {
        	   System.out.println(singleProduct);
           }
       }
       catch(Exception e)
       {
    	   if(transaction != null)
    	   {
    		   transaction.rollback();
    	   }
    	   System.out.println("Failed");
    	   e.printStackTrace();
       }
       finally
       {
    	   if(session != null)
    	   {
    		   session.close();
    	   }
    	   
    	   if(sessionFactory != null)
    	   {
    		   sessionFactory.close();
    	   }
       }
       
    }
}