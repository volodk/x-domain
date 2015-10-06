package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class JPATestSuite extends JPATest{
    
    @Test
    public void findCustomerById() throws Exception {
        Customer c = em.find(Customer.class, 2001);
        assertNotNull(c);
        assertEquals("Hoffman", c.getName());
    }
}
