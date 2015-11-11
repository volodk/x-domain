package domain0;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

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
        
        // with criteria querys
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> orders = cq.from(Order.class);
        cq.select(orders);
        
        List<Order> results2 = em.createQuery(cq).getResultList();
        assertEquals(10, results2.size());
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
    }

    // (*) 3 Напишите запрос который вывел бы таблицу со столбцами в следующем
    // порядке: city, sname, snum, comm.
    @Test
    public void selectSalespeople() throws Exception {
        TypedQuery<Salespeople> q = em.createQuery("select s from Salespeople s", Salespeople.class);
        List<Salespeople> result = q.getResultList();
        assertEquals(5, result.size());
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
        TypedQuery<Order> q = em.createQuery("select o from Order o", Order.class);
    }

    // (*) 1. Напишите запрос который может дать вам все порядки со значениями
    // суммы выше чем $1,000.
    @Test
    public void query6() throws Exception {

    }

    // (*) 2. Напишите запрос который может выдать вам пол sname и city для всех
    // продавцов в Лондоне с комиссионными выше .10 .
    @Test
    public void query7() throws Exception {

    }

    // (*) 3. Напишите запрос к таблице Заказчиков чей вывод может включить всех
    // заказчиков с оценкой =< 100, если они не находятся в Риме.
    @Test
    public void query8() throws Exception {

    }

    // (*)1. Напишите два запроса которые могли бы вывести все порядки на 3 или
    // 4 Октября 1990
    @Test
    public void query9() throws Exception {

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
