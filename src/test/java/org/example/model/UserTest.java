package org.example.model;

import org.example.model.oneToOne.Profile;
import org.example.model.oneToOne.User;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void persistUser(){
        User newUser = new User();
        newUser.setName("Princesa de Carrión");

        Profile newProfile = new Profile();
        newProfile.setBio("Del mismísimo Carrión");

        newUser.setProfile(newProfile);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.persist(newUser);

        session.getTransaction().commit();

        assertNotNull(newUser.getId());
        assertNotNull(newProfile.getId());

    }
}
