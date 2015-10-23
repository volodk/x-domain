package domain1;

import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;

import org.h2.tools.RunScript;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import base.BaseJPATest;

public class Queries extends BaseJPATest{
    
    @ClassRule
    public static ExternalResource schema = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:jpatestdb", "sa", "");
            Reader schema = new InputStreamReader(getClass().getResourceAsStream("schema.sql"));
            Reader data = new InputStreamReader(getClass().getResourceAsStream("data.sql"));
            RunScript.execute(conn, schema);
            RunScript.execute(conn, data);
        }
        protected void after() {};
    };
    
    @Test
    public void findCustomerById() throws Exception {
       
    }
}
