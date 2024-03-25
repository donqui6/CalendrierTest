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
    @DisplayName("test date du lendemain")
    void EstBissextileTest() {
        assertEquals(false, Date.estBissextile(2013));
        assertEquals(false, Date.estBissextile(1581));
        assertEquals(true, Date.estBissextile(2024));
        assertEquals(false, Date.estBissextile(1900));
        assertEquals(true, Date.estBissextile(2000));



    }