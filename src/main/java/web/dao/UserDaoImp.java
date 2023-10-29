package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public void update(User user) {
        User userForUpdate = em.find(User.class, user.getId());
        userForUpdate.setName(user.getName());
        userForUpdate.setLastname(user.getLastname());
        userForUpdate.setAge(user.getAge());
    }

    @Override
    public void delete(int id) {
        User userForDelete = em.find(User.class, id);
        em.remove(userForDelete);
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getAllUser() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }
}
