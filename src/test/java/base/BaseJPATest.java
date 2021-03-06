package base;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.h2.tools.Server;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.ExternalResource;

public class BaseJPATest {
    
    private static Server h2server;
    protected static EntityManagerFactory emf;
    protected EntityManager em;
    
    @ClassRule
    public static ExternalResource inMemoryDatabase = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            String[] args = { "-trace" };
            h2server = Server.createTcpServer(args).start();
        }
        protected void after() {
            h2server.stop();
        };
    };
    
    @ClassRule
    public static ExternalResource entityManagerFactory = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            emf = Persistence.createEntityManagerFactory("x-domain");
        }
        protected void after() {
            emf.close();
        };
    };
    
    @Rule
    public ExternalResource entityManager = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            em = emf.createEntityManager();
        }
        protected void after() {
            em.close();
        };
    };
    
    @Rule
    public ExternalResource whitespace = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            System.out.println(">>>");
        }
        protected void after() {
            System.out.println("<<<");
        };
    };

}
