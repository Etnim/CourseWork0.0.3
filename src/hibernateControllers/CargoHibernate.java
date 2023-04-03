package hibernateControllers;

import model.Cargo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CargoHibernate {
    private EntityManagerFactory emf;

    public CargoHibernate(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void updateCargo(Cargo cargo) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(cargo);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void createCargo(Cargo cargo) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cargo);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public void deleteCargo(Cargo cargo) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(cargo);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cargo> getAllItems(){
        EntityManager em = getEntityManager();
        List<Cargo> resultList = null;
        try {
            TypedQuery<Cargo> query = em.createQuery("SELECT i FROM Cargo i", Cargo.class);
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
}
