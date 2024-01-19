package com.example.daopattern.dao.impl;

import com.example.daopattern.dao.UserDaoHibernate;
import com.example.daopattern.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImplHibernate implements UserDaoHibernate {
    @Setter(onMethod = @__(@Autowired))
    private EntityManagerFactory emf;

    @Override
    public User findById(Long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class, id);
    }

    @Override
    public Boolean save(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.flush();
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public Boolean deleteById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(User.class, id));
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public List<User> findByFIO(String surname, String name, String patronymic) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.surname = :surname AND u.name = :name AND u.patronymic = :patronymic",
                User.class
        );
        query.setParameter("surname", surname);
        query.setParameter("name", name);
        query.setParameter("patronymic", patronymic);
        return query.getResultList();
    }


    @Override
    public Integer updateById(User user) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.flush();
            em.getTransaction().commit();
            return Math.toIntExact(user.getId());
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return -1;
    }
}
