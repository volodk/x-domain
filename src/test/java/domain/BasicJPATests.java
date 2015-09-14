package domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.h2.tools.Server;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// volodymyr_krasnikov1 <vkrasnikov@gmail.com> 6:14:55 PM 

public class BasicJPATests {
    
    private static Server h2server;
    private static EntityManagerFactory emf;
    private EntityManager em;
    
    @BeforeClass
    public static void initEMF() throws Exception{
        String[] args = { "-trace" };
        h2server = Server.createTcpServer(args).start();
        
        emf = Persistence.createEntityManagerFactory("x-domain");
    }
    
    @Before
    public void initEM(){
        em = emf.createEntityManager();
    }

    @Test
    public void test() {
        em.find(Customer.class, 0);
    }
    
    @After
    public void closeEM(){
        em.close();
    }
    
    @AfterClass
    public static void closeEMF(){
        emf.close();
        h2server.stop();
    }

}
