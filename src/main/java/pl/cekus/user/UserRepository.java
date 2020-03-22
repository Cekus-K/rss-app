package pl.cekus.user;import pl.cekus.HibernateUtil;import java.util.List;public class UserRepository {    List<User> findAll() {        var session = HibernateUtil.getSessionFactory().openSession();        var transaction = session.beginTransaction();        var result = session.createQuery("from User", User.class).list();        transaction.commit();        session.close();        return result;    }    User addUser(User newUser) {        var session = HibernateUtil.getSessionFactory().openSession();        var transaction = session.beginTransaction();        session.persist(newUser);        transaction.commit();        session.close();        return newUser;    }}