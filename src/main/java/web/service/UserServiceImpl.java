package web.service;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleRepository;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.Role;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, RoleRepository {

    @Autowired
    private UserDaoImpl userDao;

    @Autowired
    private RoleRepository roleRepository;



    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    public User findUserByUserName(String userName) {
        return userDao.getUserByName(userName);
    }

    @Override
    public Role findByRole(String role) {
        return roleRepository.findByRole(role);
    }
}
