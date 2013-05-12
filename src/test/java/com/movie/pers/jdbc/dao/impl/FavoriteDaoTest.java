package com.movie.pers.jdbc.dao.impl;

import com.movie.pers.entities.Favorite;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

/**
 *
 * @author Aloren
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/resources/web/application-context.xml"})
@ActiveProfiles("test")
public class FavoriteDaoTest extends BaseDaoTest {
    
    public static final Favorite testFavorite1 = TestData.testFavorite1;//1 - 1
    public static final Favorite testFavorite2 = TestData.testFavorite2;// 1 -  2
    public static final Favorite testFavorite3 = TestData.testFavorite3;// 2 - 2
    private static final int NUM_TEST_ROWS = 3;
    @Autowired
    private FavoriteDao favoriteDao;

    @Test
    public void getAll() {
        List<Favorite> favorites = favoriteDao.getAll();
        assertTrue("There must be " + NUM_TEST_ROWS
                + " test rows in db, but was " + favorites.size(), favorites.size() == NUM_TEST_ROWS);
        assertEquals("First favorite was not read correctly.", testFavorite1, favorites.get(0));
        assertEquals("Second favorite was not read correctly.", testFavorite2, favorites.get(1));
        assertEquals("Third favorite was not read correctly.", testFavorite3, favorites.get(2));
    }

    @Test
    public void saveNotDuplicate() {
        Favorite fav = new Favorite(2, TestData.testMovie1);
        boolean saved = favoriteDao.save(fav);
        assertTrue(saved);
        Favorite foundFavorite = favoriteDao.getById(fav.getUserId(), fav.getMovie().getId());
        assertEquals("Favorite in DB was not saved correctly.", fav, foundFavorite);
    }

    @Test
    public void saveDuplicate() {
        Favorite duplicate = new Favorite(2, TestData.testMovie2);
        Favorite foundFavorite = favoriteDao.getById(duplicate.getUserId(), duplicate.getMovie().getId());
        assertNotNull("First entry for test duplicate must exist", foundFavorite);
        boolean saved = favoriteDao.save(duplicate);
        assertFalse("Duplicate must not be saved to DB.", saved);

    }

    @Test
    public void deleteExisting() {
        Favorite fav = new Favorite(2, TestData.testMovie2);
        favoriteDao.delete(fav);
        Favorite deletedFav = favoriteDao.getById(fav.getUserId(), fav.getMovie().getId());
        assertNull("Deleted favorite must not reside in DB anymore.", deletedFav);
    }
    
    @Test
    public void deleteNotExisting() {
        Favorite fav = new Favorite(2, TestData.testMovie1);
        Favorite deletedFav = favoriteDao.getById(fav.getUserId(), fav.getMovie().getId());
        assertNull("This favorite must not reside in DB for this test.", deletedFav);
        favoriteDao.delete(fav);
    }

    @Test
    public void getAllForUser() {
        List<Favorite> list = favoriteDao.getAll(1);
        assertEquals(2, list.size());
    }
}
