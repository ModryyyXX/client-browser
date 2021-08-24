package TaskForJob.db;
import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import TaskForJob.model.Client;

public class DBConnector {

	 private SessionFactory factory = new Configuration().configure().buildSessionFactory();
	 
	private Matcher matcher;
	private Pattern pattern;
	private final String regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
	
public ArrayList<Client> getListOfAllClients(){
	
	Session session = factory.openSession();
	 ArrayList<Client> arClients = (ArrayList<Client>) session.createQuery("from TaskForJob.model.Client").getResultList();
     session.close();

	return arClients; 
}

public boolean validateEmail(String mail) {
	pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	matcher = pattern.matcher(mail);
	return matcher.matches();
	
}

public  boolean validatePhone(String phoneNumber) {
    int length =9;
 
    String phone1 = phoneNumber.replaceAll("\\D+", "");

    if (phoneNumber.length() != length || phone1.length() != length){
        return false;
    }
    else
    try{
        int number = Integer.parseInt(phone1.trim());
        
    } catch (NumberFormatException e) { //it's unnecessary
        e.printStackTrace();
        System.out.println("This isn't number, try again"); 

    }



    return true;
}

public void addClient(Client client){
	
	
	if(validateEmail(client.getMail()) == true 
			&& validatePhone(client.getPhone()) == true  
			&& client.getName().length() >0
			&& client.getSurname().length() >0
			&& client.getAddress().length() >0) {
	
    Session session = factory.openSession();
    Transaction tx = null;
    try {
        tx = session.beginTransaction();
        session.save(client);
        
        tx.commit();	
    } catch (HibernateException e) {
        if (tx != null) tx.rollback();
    } finally {
        session.close();
    }
	}
	else
		
		System.out.println("the data isn't correct");
	
}

public void removeClient(int id){
	
	 Session session = factory.openSession();

	 if(ClientExist(id) ==true) {
	 Client client;
     Transaction tx = null;
     try {
         tx = session.beginTransaction();
         client = (Client) session.load(Client.class,id);
         session.delete(client);
         session.flush();

         tx.commit();
     } catch (HibernateException e) {
         if (tx != null) tx.rollback();
     } finally {
         session.close();
     }
	 }
	 else
		 System.out.println("THIS Client with this ID:" + id+ " doesn't exist");
	
}
public Client detailsOfClient(int ID) {
	
	 Client client2 = new Client(ID, 
			 "WARNING!!",
			 "THIS Client with this ID: " + ID+ " doesn't exist, TRY AGAIN",
			 "THIS Client with this ID: " + ID+ " doesn't exist, TRY AGAIN",
			 "THIS Client with this ID: " + ID+ " doesn't exist, TRY AGAIN",
			 "THIS Client with this ID: " + ID+ " doesn't exist, TRY AGAIN",
			 "THIS Client with this ID: " + ID+ " doesn't exist, TRY AGAIN");
	 
	 System.out.println(client2);
	 
	if(ClientExist(ID) ==true  ) {
	
	Session session = factory.openSession();
	Client client = (Client) session.createQuery("from TaskForJob.model.Client where ID = "+ID).uniqueResult();
	session.close();

	
	return client;
	 }
	 else

	
		 return client2;
}
public boolean ClientExist(int ID) {
	Session session = factory.openSession();
	Client client = (Client) session.createQuery("from TaskForJob.model.Client where ID = "+ID).uniqueResult();
	return Optional.ofNullable(client).isPresent();
}
}
