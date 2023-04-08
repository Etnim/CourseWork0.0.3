package hibernateControllers;

import model.Driver;
import model.Manager;
import model.User;

import javax.persistence.*;
import java.util.List;

public class UserHibernate {
    private EntityManagerFactory emf;

    public UserHibernate(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public User validateUser(String login, String password) {
        EntityManager em = getEntityManager();
        Driver driver = null;
        Manager manager = null;

        TypedQuery<Driver> queryD = em.createQuery(
                "SELECT u FROM Driver u WHERE u.login = :login AND u.password = :password", Driver.class);
        queryD.setParameter("login", login);
        queryD.setParameter("password", password);
        try {
            driver = queryD.getSingleResult();
        } catch (NoResultException | NonUniqueResultException ex) {}

        if (driver == null) {
            TypedQuery<Manager> queryM = em.createQuery(
                    "SELECT u FROM Manager u WHERE u.login = :login AND u.password = :password", Manager.class);
            queryM.setParameter("login", login);
            queryM.setParameter("password", password);
            try {
                manager = queryM.getSingleResult();
            }catch (NoResultException | NonUniqueResultException ex) {}
        }
        if (driver != null) {
            return driver;
        } else if (manager != null) {
            return manager;
        } else {
            return null;
        }
    }


    public List<Manager> getAllManagers() {
        EntityManager em = getEntityManager();
        List<Manager> resultList = null;
        try {
            TypedQuery<Manager> query = em.createQuery("SELECT i FROM Manager i", Manager.class);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return resultList;
    }

    public List<Driver> getAllDrivers() {
        EntityManager em = getEntityManager();
        List<Driver> resultList = null;
        try {
            TypedQuery<Driver> query = em.createQuery("SELECT i FROM Driver i", Driver.class);
            resultList = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return resultList;
    }

    public void createDiver(Driver driver) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(driver);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void updateDiver(Driver driver) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(driver);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deleteDiver(Driver driver) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(driver);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void createManager(Manager manager) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(manager);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void updateManager(Manager manager) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(manager);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deleteManager(Manager manager) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(manager);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
