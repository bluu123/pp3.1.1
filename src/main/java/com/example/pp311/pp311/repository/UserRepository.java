package com.example.pp311.pp311.repository;

import org.springframework.stereotype.Component;
import com.example.pp311.pp311.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public User findOne(Long id) {
        return entityManager.find(User.class, id);
    }

    public List findAll() {
        return entityManager.createQuery("SELECT user FROM User user").getResultList();
    }

    public User save(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
            entityManager.flush();
            return user;
        } else {
            return entityManager.merge(user);
        }
    }

    public void remove(Long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
