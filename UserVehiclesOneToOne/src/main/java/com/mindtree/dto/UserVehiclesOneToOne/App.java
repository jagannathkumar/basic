package com.mindtree.dto.UserVehiclesOneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserDetails user=new UserDetails();
        Vehicle vehicle=new Vehicle();
        Vehicle vehicle1=new Vehicle();
        vehicle1.setVehicleName("Jeep");
        user.setUserName("jktis");
        vehicle.setVehicleName("car");
        vehicle.setUserDetails(user);
        vehicle1.setUserDetails(user);
		/*
		 * Movies movie = new Movies(); Language language = new Language(); Location
		 * location = new Location(); Theatre theatre = new Theatre(); RunningShows
		 * runningshows=new RunningShows();
		 */
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(vehicle);
        session.save(vehicle1);
        session.save(user);
		/*
		 * session.save(movie); session.save(language); session.save(location);
		 * session.save(theatre); session.save(runningshows);
		 */
        session.getTransaction().commit();
        session.close();
    }
}
