package fsad_skill_02;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Configuration config = new Configuration();
        config.configure("hibernate.cfg.xml");

        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

        Product p1 = new Product();
        p1.setName("Mobile");
        p1.setDescription("Electronics");
        p1.setPrice(30000);
        p1.setQuantity(10);
        session.persist(p1);

        Product p2 = new Product();
        p2.setName("Mobile Case");
        p2.setDescription("Accessories");
        p2.setPrice(500);
        p2.setQuantity(30);
        session.persist(p2);

        Product p3 = new Product();
        p3.setName("Charger");
        p3.setDescription("Accessories");
        p3.setPrice(1200);
        p3.setQuantity(25);
        session.persist(p3);

        Product p4 = new Product();
        p4.setName("Power Bank");
        p4.setDescription("Accessories");
        p4.setPrice(2000);
        p4.setQuantity(12);
        session.persist(p4);

        Product p5 = new Product();
        p5.setName("Earbuds");
        p5.setDescription("Accessories");
        p5.setPrice(3500);
        p5.setQuantity(5);
        session.persist(p5);

        tx.commit();

        List<Product> list = session.createQuery("from Product", Product.class).list();

        System.out.println("PRODUCT LIST");
        for(Product p : list) {
            System.out.println(p.getId()+" "+p.getName()+" "+p.getPrice());
        }

        session.close();
        factory.close();
    }
}