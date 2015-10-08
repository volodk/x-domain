package queries;

import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.h2.tools.RunScript;
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
            System.out.println("H2 started >>>>> ");
        }
        protected void after() {
            h2server.stop();
            System.out.println("<<<<< H2 stopped");
        };
    };
    
    @ClassRule
    public static ExternalResource schema = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:jpatestdb", "sa", "");
            Reader schema = new InputStreamReader(BaseJPATest.class.getResourceAsStream("/schema.sql"));
            RunScript.execute(conn, schema);
        }
        protected void after() {
            // do nothing
        };
    };
    
    @ClassRule
    public static ExternalResource data = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:jpatestdb", "sa", "");
            Reader data = new InputStreamReader(BaseJPATest.class.getResourceAsStream("/data.sql"));
            RunScript.execute(conn, data);
        }
        protected void after() {
            // do nothing
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

}
