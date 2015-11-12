package networkmi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.networkmi.model.Usuario;

public class UsuarioTeste {
	public static void testApp() {
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
 
		Usuario user = new Usuario("firstuser");
		session.save(user);
 
		session.getTransaction().commit();
		session.close();
	}
	
	
	public static void main(String[] args){
		testApp();
	}
}
