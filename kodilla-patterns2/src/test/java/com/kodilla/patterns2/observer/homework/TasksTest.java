package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TasksTest {

    @Test
    public void testUpdate() {
        Mentor mentor  = new Mentor("Michał Dolny");
        Mentor mentor1  = new Mentor("Michał Gołębiowski");

        Tasks tasks = new Tasks(7, "Wstęp do programowania funkcyjnego, " +
                "czyli wyrażenia lambda");
        Tasks tasks2 = new Tasks(3, "Wykorzystanie Stream na różnych kolekcjach");
        Tasks tasks3 = new Tasks(8, "Throw i Throws – są jakieś różnice?");
        Tasks tasks11 = new Tasks(8, "Język SQL – tworzenie i modyfikacja obiektów");
        Tasks tasks1 = new Tasks(8, "Komunikacja aplikacji z bazą danych – JDBC");
        Tasks tasks9 = new Tasks(8, "24.4. Wzorzec Obserwator");

        tasks.addMentor(mentor);
        tasks2.addMentor(mentor);
        tasks3.addMentor(mentor1);
        tasks1.addMentor(mentor1);
        tasks11.addMentor(mentor1);
        tasks9.addMentor(mentor1);

        assertEquals(2, mentor.getNotificationCount());
        assertEquals(4, mentor1.getNotificationCount());
    }
}