package hibernateControllers;

import model.Cargo;
import model.Truck;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class TruckHibernate {
    private EntityManagerFactory emf;

    public TruckHibernate(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Truck> getAllItems(){
        EntityManager em = getEntityManager();
        List<Truck> resultList = null;
        try {
            TypedQuery<Truck> query = em.createQuery("SELECT i FROM Truck i", Truck.class);
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

    public void createTruck(Truck truck) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(truck);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deleteTruck(Truck truck) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(truck);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public void updateTruck(Truck truck) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(truck);
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
