import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Volodymyr_Krasnikov1 <vkrasnikov@gmail.com> 3:51:17 PM 

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-domain");
        try {
            EntityManager em = emf.createEntityManager();
            try {
                
                
                
            } finally {
                em.close();
            }
        } finally {
            emf.close();
        }
    }
}
