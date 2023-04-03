package hibernateControllers;

import model.Cargo;
import model.CheckPoint;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CheckpointHibernate {
    private EntityManagerFactory emf;

    public CheckpointHibernate(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<CheckPoint> getAllItems(){
        EntityManager em = getEntityManager();
        List<CheckPoint> resultList = null;
        try {
            TypedQuery<CheckPoint> query = em.createQuery("SELECT i FROM CheckPoint i", CheckPoint.class);
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

    public void updateCheckPoint(CheckPoint checkPoint) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(checkPoint);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void createCheckPoint(CheckPoint checkPoint) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(checkPoint);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deleteCheckPoint(CheckPoint checkPoint) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(checkPoint);
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
