package modele;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DateTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("test date du lendemain")
    void dernierJourDuMoisTest() {
        assertEquals(28, Date.dernierJourDuMois(2,2023));
        assertEquals(29, Date.dernierJourDuMois(2,2024));
        assertEquals(31, Date.dernierJourDuMois(3,2023));
        assertEquals(31, Date.dernierJourDuMois(3,2024));

    }
    @Test
    @DisplayName("date de la veille")
    void CompareToTest() {
        Date date1 = new Date(20,2,2024);
        Date date2 = new Date(21,2,2024);
        assertEquals(-100, date1.compareTo(date2));
        assertEquals(100, date2.compareTo(date1));
        assertEquals(0, date2.compareTo(date2));
    }
    @Test
    @DisplayName("test date du lendemain")
    void dateDuLendemainTest() {
        Date date1 = new Date(20,2,2024);
        Date date2 = new Date(21, 2, 2024);
        assertEquals(0, date1.dateDuLendemain().compareTo(date2));
    }
    @Test
    @DisplayName("date de la veille")
    void dateDeLaVeilleTest() {
        Date date1 = new Date(20,2,2024);
        Date date2 = new Date(21, 2, 2024);
        assertEquals(0, date2.dateDeLaVeille().compareTo(date1));
    }
    @Test
    @DisplayName("date de la veille")
    void EstValideTest() {
        Date date1 = new Date(20,2,2020);
        Date date2 = new Date(32,2,2020);
        Date date3 = new Date(20,13,2020);
        assertEquals(true, date1.estValide());
        assertEquals(false, date2.estValide());
        assertEquals(false, date3.estValide());
    }

}