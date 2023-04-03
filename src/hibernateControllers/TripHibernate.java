package hibernateControllers;

import model.Cargo;
import model.Trip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class TripHibernate {
    private EntityManagerFactory emf;

    public TripHibernate(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


    public List<Trip> getAllItems(){
        EntityManager em = getEntityManager();
        List<Trip> resultList = null;
        try {
            TypedQuery<Trip> query = em.createQuery("SELECT i FROM Trip i", Trip.class);
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
    public void createTrip(Trip trip) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(trip);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }



    public void deleteTrip(Trip trip) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(trip);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public void updateTrip(Trip trip) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(trip);
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
