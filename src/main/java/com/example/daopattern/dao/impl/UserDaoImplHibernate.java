package com.example.daopattern.dao.impl;

import com.example.daopattern.dao.UserDaoHibernate;
import com.example.daopattern.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDaoImplHibernate implements UserDaoHibernate {
    @Setter(onMethod = @__(@Autowired))
    private EntityManagerFactory emf;

    @Override
    public User findById(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(User.class, id);
        }
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
    public List<User> findByFIO(String surname, String name, String patronymic, Pageable pageable) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<User> query = em.createNamedQuery(
                    "get_all_by_surname_name_and_patronymic",
                    User.class
            );
            query.setParameter("surname", surname);
            query.setParameter("name", name);
            query.setParameter("patronymic", patronymic);

            query.setMaxResults(pageable.getPageSize()); // setMaxResults pageSize
            query.setFirstResult((int) pageable.getOffset()); // offset = pageable.getPageSize() * pageable.getPageNumber()
            return query.getResultList();
        }
    }

    @Override
    public List<User> findBySurnameWithCriteria(String surname) {
        try (EntityManager em = emf.createEntityManager()) {
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            ParameterExpression<String> paramSurname = criteriaBuilder.parameter(String.class);
            Predicate surnamePredicate = criteriaBuilder.equal(root.get("surname"), paramSurname);
            query.select(root).where(surnamePredicate);
            TypedQuery<User> typedQuery = em.createQuery(query);
            typedQuery.setParameter(paramSurname, surname);
            return typedQuery.getResultList();
        }
    }

    @Override
    public List<User> findBySurnameWithoutCriteria(String surname) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<User> typedQuery = em.createNamedQuery("get_all_by_surname", User.class);
            typedQuery.setParameter("surname", surname);
            return typedQuery.getResultList();
        }
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
