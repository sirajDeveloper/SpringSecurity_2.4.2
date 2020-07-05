package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;

public class UserRolesDaoImpl implements UserRolesDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addUserRoles(Long userId, String userRoles) {
        Session session = sessionFactory.getCurrentSession();
        if (userRoles.equalsIgnoreCase("admin")) {
            Query query = session.createSQLQuery(
                    "insert into user_roles values (?, 2)");
            query.setParameter(1, userId);
            query.executeUpdate();
        }
    }
}
