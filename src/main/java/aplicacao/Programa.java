package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import dominio.Pessoa;



public class Programa {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(null, "dinho", "dinho@gmail.com");
		Pessoa p2 = new Pessoa(null, "gordinho", "gordinho@gmail.com");
		Pessoa p3 = new Pessoa(null, "dog", "dog@gmail.com");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em =   emf.createEntityManager();
		
		//test insert like jdbc insert
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		
		System.out.println("ready!");
		
		
		// test select by id like jdbc selectById
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		em.close();
		emf.close();
	}

}
