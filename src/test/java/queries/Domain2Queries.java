package queries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import domain0.Customer;

public class Domain2Queries extends BaseJPATest{
    
    @Test
    public void findCustomerById() throws Exception {
        Customer c = em.find(Customer.class, 2001);
        assertNotNull(c);
        assertEquals("Hoffman", c.getName());
    }
}
