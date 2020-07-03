package web.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("FROM User").list();
    }

    @Override
    public User findById(Long id) {
        Query<User> query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User getUserByName(String name) {
        Query<User> query = sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE login = :name");
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
