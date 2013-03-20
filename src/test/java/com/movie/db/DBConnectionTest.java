package com.movie.db;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aloren
 */
public class DBConnectionTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;

    @BeforeClass
    public static void initEntityManager() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("movie_db");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void closeEntityManager() throws SQLException {
        entityManager.close();
        entityManagerFactory.close();
    }

    @Before
    public void initTransaction() {
        entityTransaction = entityManager.getTransaction();
    }

    @Test
    public void shouldCreateABook() throws Exception {
        
        User expectedUser = new User();
        expectedUser.setFirstName("aaa");
        expectedUser.setLastName("bbb");
        expectedUser.setLogin("login");
        expectedUser.setPass("pass");
        
        entityTransaction.begin();
        entityManager.persist(expectedUser);
        entityTransaction.commit();
        
        assertNotNull("ID must NOT be null", expectedUser.getId());
        
        List<User> users = entityManager.createNamedQuery("findAllUsers").getResultList();
        for(User userI : users) {
            System.out.println(userI);
        }
        
        assertEquals(1, users.size());
        
        User actualUser = users.get(0);
        assertTrue(actualUser.equals(expectedUser));
    }
}
