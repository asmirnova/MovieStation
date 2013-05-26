package com.movie.pers.jdbc.dao.impl;

import com.movie.pers.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * @author Aloren
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/application-context.xml"})
@ActiveProfiles("test")
public class UserDaoTest extends BaseDaoTest {

    public static final User testUser1 = TestData.testUser1;
    public static final User testUser2 = TestData.testUser2;
    private static final int NUM_TEST_ROWS = 2;
    @Autowired
    private UserDao userDao;

    @Test
    public void getAll() {
        List<User> users = userDao.getAll();
        assertTrue("There must be " + NUM_TEST_ROWS + " test rows in db.", users.size() == NUM_TEST_ROWS);
        assertTrue("First user's name is not " + testUser1.getFirstName(), users.get(0).getFirstName().equals(testUser1.getFirstName()));
        assertTrue("Second user's name is not " + testUser2.getFirstName(), users.get(1).getFirstName().equals(testUser2.getFirstName()));
    }
    
    @Test
    public void isAdmin() {
        boolean isAdmin1 = userDao.isAdmin(testUser1.getId());
        assertTrue(isAdmin1);
        boolean isAdmin2 = userDao.isAdmin(testUser2.getId());
        assertFalse(isAdmin2);
        final int noSuchUserId = 5000;
        boolean isAdmin3 = userDao.isAdmin(noSuchUserId);
        assertFalse(isAdmin3);
    }
    
    @Test
    public void addAdminRights() {
        boolean addedRights = userDao.addAdminRights(testUser2.getId());
        assertTrue(addedRights);
        addedRights = userDao.addAdminRights(testUser1.getId());
        assertTrue("Rights must be added for user that is already admin.",addedRights);
    }
    
    @Test
    public void removeAdminRights() {
        boolean removedRights = userDao.removeAdminRights(testUser1.getId());
        assertTrue(removedRights);
        removedRights = userDao.removeAdminRights(testUser2.getId());
        assertTrue(removedRights);
    }

    @Test
    public void getUserById() {
        User user = userDao.getById(testUser1.getId());
        assertNotNull(user);
        assertEquals(testUser1, user);
    }

    @Test
    public void save() {
        User savedUser = saveUniqueUser("saveLogin");
        User foundUser = userDao.getById(savedUser.getId());
        assertEquals("User in DB was not saved correctly.", savedUser, foundUser);
    }

    @Test
    public void saveWithDuplicateLogin() {
        boolean saved = saveNotUniqueUser("aloren");
        assertFalse("Not unique user must not be saved to DB.", saved);
    }

    @Test
    public void delete() {
        User savedUser = saveUniqueUser("deleteLogin");
        userDao.delete(savedUser);
        User deletedUser = userDao.getById(savedUser.getId());
        assertNull("Deleted user must not reside in DB anymore.", deletedUser);
    }

    @Test
    public void findByLogin() {
        String login = testUser1.getUsername();
        User user = userDao.find(login);
        assertEquals(testUser1, user);
    }

    @Test
    public void findByLoginAndPass() {
        String login = testUser1.getUsername();
        String pass = testUser1.getPassword();
        User user = userDao.find(login, pass);
        assertEquals(testUser1, user);
    }

    @Test
    public void update() {
        User user = saveUniqueUser("updateUser");
        final String updatedLogin = "updateUser2";
        user.setUsername(updatedLogin);
        userDao.update(user);

        User found = userDao.getById(user.getId());
        assertEquals(updatedLogin, found.getUsername());
    }

    private User saveUniqueUser(String login) {
        User user = new User(null, "firstName", "lastName", login, "pass", "email");
        userDao.save(user);
        final Integer id = user.getId();
        assertNotNull("Id for saved user must be set.", id);
        return user;
    }

    private boolean saveNotUniqueUser(String login) {
        User user = new User(null, "firstName", "lastName", login, "pass", "email");
        boolean saved = userDao.save(user);
        assertNull("Id for not saved, not unique user must be NOT set.", user.getId());
        return saved;
    }
}
