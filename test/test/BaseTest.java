package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class BaseTest {
    
    private static EntityManagerFactory emf;
    
    protected EntityManager em;
    
    @BeforeClass
    public static void initEMF(){
        emf = Persistence.createEntityManagerFactory("x-domain");
    }
    
    @Before
    public void setUp(){
        em = emf.createEntityManager();
    }
     
    @After
    public void tearDown(){
        em.close();
    }
    
    @AfterClass
    public static void closeEMF(){
        emf.close();
    }

}
