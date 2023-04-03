package hibernateControllers;

import model.Cargo;
import model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CommentHibernate {
    private EntityManagerFactory emf;

    public CommentHibernate(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void updateComment(Comment comment) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(comment);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public void createComment(Comment comment) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(comment);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public void deleteComment(Comment comment) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(comment);
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
