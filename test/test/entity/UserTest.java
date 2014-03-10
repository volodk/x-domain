package test.entity;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;

import org.junit.Test;

import test.BaseTest;
import test.entity.User;
import test.entity.UserProfile;

public class UserTest extends BaseTest {

    @Test
    public void create() {
        
        User u = null;

        EntityTransaction tx = em.getTransaction();

        try {
            
            tx.begin();

            UserProfile up = new UserProfile();
            up.setAge((byte) 18);
            up.setEmail("email@email.com");
            up.setName("test user");

            u = new User();
            u.setId(101L);
            u.setProfile(up);
            
//            em.merge(u);

            em.persist(u);

            tx.commit();
            
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }

        User u2 = em.find(User.class, 101L);

        assertEquals(u, u2);

    }

    @Test
    public void merge() {

    }

    @Test
    public void detachAttach() {

    }

}
