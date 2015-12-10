package domain0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.TemporalType;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.h2.tools.RunScript;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

import base.BaseJPATest;

public class Queries extends BaseJPATest {

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

        protected void after() {
        };
    };

    // (*) 1. Напишите команду SELECT которая бы вывела номер порядка, сумму, и
    // дату для всех строк из таблицы Порядков.
    @Test
    public void selectOrder_Id_sum_date() throws Exception {
        TypedQuery<Order> q = em.createQuery("select o from Order o", Order.class);
        List<Order> results = q.getResultList();
        assertNotNull(results);
        assertEquals(10, results.size());
        results.forEach(o -> System.out.format("id: %d \t sum: %f \t date: %s\n", o.getId(), o.getAmount(),
                o.getOrderDate()));
        
        System.out.println();
        TypedQuery<Tuple> qe = em.createQuery("select o.amount, o.orderDate from Order o", Tuple.class);
        List<Tuple> results1 = qe.getResultList();
        assertEquals(10, results1.size());
        
        // with criteria querys
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> orders = cq.from(Order.class);
        cq.select(orders);
        
        List<Order> results2 = em.createQuery(cq).getResultList();
        assertEquals(10, results2.size());
        
        
        CriteriaBuilder cb2 = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq2 = cb2.createQuery(Tuple.class);
        Root<Order> orders2 = cq2.from(Order.class);
        cq2.select(cb2.tuple(orders2.get("amount"), orders2.get("orderDate")));
        
        List<Tuple> results3 = em.createQuery(cq2).getResultList();
        assertEquals(10, results3.size());
        results3.forEach( t -> System.out.println(t.get(0) + "\t" + t.get(1)) );
    }

    // (*) 2. Напишите запрос который вывел бы все строки из таблицы Заказчиков
    // для которых номер продавца = 1001.
    @Test
    public void selectCustomer_where_snum_eq_1001() throws Exception {
        TypedQuery<Customer> q = em.createQuery("select c from Customer c where c.salepeople.id = :snum", Customer.class);
        q.setParameter("snum", 1001);
        List<Customer> results = q.getResultList();
        assertNotNull(results);
        assertEquals(2, results.size());
        results.forEach(c -> System.out.format("id: %d \t name: %s\n", c.getId(), c.getName()));
        
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customers = cq.from(Customer.class);
        cq.select(customers).where(cb.equal(customers.get("salepeople"), 1001));
        
        List<Customer> results2 = em.createQuery(cq).getResultList();
        assertEquals(2, results2.size());
    }

    // (*) 3 Напишите запрос который вывел бы таблицу со столбцами в следующем
    // порядке: city, sname, snum, comm.
    @Test
    public void selectSalespeople() throws Exception {
        TypedQuery<Salespeople> q = em.createQuery("select s from Salespeople s", Salespeople.class);
        List<Salespeople> result = q.getResultList();
        assertEquals(5, result.size());
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        Root<Salespeople> sales = cq.from(Salespeople.class);
        cq.select(cb.tuple(sales.get("city"), sales.get("name"), sales.get("id"), sales.get("commision")));
        
        em.createQuery(cq).getResultList()
            .forEach(t -> System.out.format("city: %s \n", t.get(0)));
    }

    // (*) 4. Напишите команду SELECT которая вывела бы оценку(rating),
    // сопровождаемую именем каждого заказчика в San Jose.
    @Test
    public void query4() throws Exception {
        TypedQuery<Customer> q = em.createQuery("select c from Customer c where c.city = :city", Customer.class);
        q.setParameter("city", "SanJose");
        List<Customer> resultList = q.getResultList();
        assertEquals(2, resultList.size());
        resultList.forEach( c -> System.out.format("rating: %d \t name: %s\n", c.getRating(), c.getName() ) );
    }

    // (*) 5. Напишите запрос который вывел бы значения snum всех продавцов в
    // текущем порядке из таблицы Порядков без каких бы то ни было повторений.
    @Test
    public void query5() throws Exception {
        TypedQuery<Integer> q = em.createQuery("select distinct o.sales.id from Order o", Integer.class);
        List<Integer> ans = q.getResultList();
        assertEquals(5, ans.size());
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
        Root<Order> root = cq.from(Order.class);
        cq.select(root.get("sales"));
        cq.distinct(true);
        
        List<Integer> ans2 = em.createQuery(cq).getResultList();
        assertEquals(5, ans2.size());
        
    }

    // (*) 1. Напишите запрос который может дать вам все порядки со значениями
    // суммы выше чем $1,000.
    @Test
    public void query6() throws Exception {
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> orders = cq.from(Order.class);
        cq.where(cb.gt(orders.get("amount"), 1000));
        
        List<Order> results = em.createQuery(cq).getResultList();
        assertEquals(7, results.size());
    }

    // (*) 2. Напишите запрос который может выдать вам полe sname и city для всех
    // продавцов в Лондоне с комиссионными выше .10 .
    @Test
    public void query7() throws Exception {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createTupleQuery();
        Root<Salespeople> sales = cq.from(Salespeople.class);
        cq.select(cb.tuple(sales.get("name"), sales.get("city")))
        .where(cb.and (
                    cb.equal(sales.get("city"), "London"),
                    cb.gt(sales.get("commision"), 0.10)
                )
            );
        
        List<Tuple> results = em.createQuery(cq).getResultList();
        assertEquals(2, results.size());
    }

    // (*) 3. Напишите запрос к таблице Заказчиков чей вывод может включить всех
    // заказчиков с оценкой =< 100, если они не находятся в Риме.
    @Test
    public void query8() throws Exception {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
        Root<Customer> customers = cq.from(Customer.class);
        cq.where(cb.and(cb.le(customers.get("rating"), 100), cb.notEqual(customers.get("city"), "Rome")));
        
        List<Customer> results = em.createQuery(cq).getResultList();
        assertEquals(2, results.size());
    }

    // (*)1. Напишите два запроса которые могли бы вывести все порядки на 3 или
    // 4 Октября 1990
    @Test
    public void query9() throws Exception {
        
        Calendar c1 = Calendar.getInstance();
        c1.set(1990, Calendar.OCTOBER, 3, 0, 0, 0);
        
        Calendar c2 = Calendar.getInstance();
        c2.set(1990, Calendar.OCTOBER, 4, 0, 0, 0);
        
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> orders = cq.from(Order.class);
        cq.where(cb.or(cb.equal(orders.<Timestamp>get("orderDate"), c1.getTime()), cb.equal(orders.<Timestamp>get("orderDate"), c2.getTime())));
        
        
        List<Order> results = em.createQuery(cq).getResultList();
        assertEquals(5, results.size());
    }

    // (*) 2. Напишите запрос который выберет всех заказчиков обслуживаемых
    // продавцами Peel или Motika. ( Подсказка: из наших типовых таблиц, поле
    // snum связывает вторую таблицу с первой )
    @Test
    public void query10() throws Exception {

    }

    // (*) 3. Напишите запрос, который может вывести всех заказчиков чьи имена
    // начинаются с буквы попадающей в диапазон от A до G.
    @Test
    public void query11() throws Exception {

    }

    // (*) 4. Напишите запрос который выберет всех пользователей чьи имена
    // начинаются с буквы C.
    @Test
    public void query12() throws Exception {

    }

    // (*) 5. Напишите запрос который выберет все порядки имеющие нулевые
    // значения или NULL в поле amt(сумма).
    @Test
    public void query13() throws Exception {

    }

    // (*) 1. Напишите запрос который сосчитал бы все суммы приобретений на 3
    // Октября.
    @Test
    public void query14() throws Exception {
        
        Calendar c = Calendar.getInstance();
        c.set(1990, Calendar.OCTOBER, 3, 0, 0, 0);
        
        TypedQuery<Long> q = em.createQuery("select count(o.amount) from Order o where o.orderDate = :date", Long.class);
        q.setParameter("date", c.getTime(), TemporalType.TIMESTAMP);
        
        Long value = q.getSingleResult();
        System.out.println(value);

    }

    // (*) 2. Напишите запрос который сосчитал бы число различных не-NULL
    // значений пол city в таблице Заказчиков.
    @Test
    public void query15() throws Exception {

    }

    // (*) 3. Напишите запрос который выбрал бы наименьшую сумму для каждого
    // заказчика.
    @Test
    public void query16() throws Exception {

    }

    // (*)4. Напишите запрос который бы выбирал заказчиков в алфавитном порядке,
    // чьи имена начинаются с буквы G.
    @Test
    public void query17() throws Exception {

    }

    // (*)5. Напишите запрос который выбрал бы высшую оценку в каждом городе.
    @Test
    public void query18() throws Exception {

    }

    // (*) 6. Напишите запрос который сосчитал бы число заказчиков
    // регистрирующих каждый день свои порядки. (Если продавец имел более одного
    // порядка в данный день, он должен учитываться только один раз.)
    @Test
    public void query19() throws Exception {

    }
}
