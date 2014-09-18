package pl.kacper.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.kacper.spring.model.Person;

@Repository
public class PersonRepository {

	@Autowired
	private SessionFactory sessionFactory;

//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
    @SuppressWarnings("unchecked")
    public List<Person> listPersons() {
		List<Person> personsList = getCurrentSession().createQuery("from Person").list();
        for(Person p : personsList){
            System.out.println("Person List::"+p);
        }
        return personsList;
    }
 
    public Person getPersonById(int id) {    
        Person p = (Person) getCurrentSession().get(Person.class, new Integer(id));
        System.out.println("Person loaded successfully, Person details="+p);
        return p;
    }
}
