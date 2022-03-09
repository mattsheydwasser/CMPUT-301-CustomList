import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;


import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void testHasCity() {

        City city = new City("Edmonton", "Alberta");

        // passes if city can be put into the list (does not contain city)
        assertTrue(list.hasCity(city));
    }

    @Test
    public void testDelete() {

        City city = new City("Edmonton", "AB");
        City notInList = new City("Vancouver", "BC");
        list.addCity(city);

        // passes if city is not in list
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(notInList);
        });

        list.delete(city);
        assertEquals(0, list.getCount());
    }
}
