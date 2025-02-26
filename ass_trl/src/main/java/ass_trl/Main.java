package ass_trl;



import org.hibernate.Session;

import org.hibernate.Transaction;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

 
public class Main {
 
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        HibernateTemplate hibernateTemplate = (HibernateTemplate) context.getBean("hibernateTemplate");

        Session session = hibernateTemplate.getSessionFactory().openSession();

        Transaction transaction = null;
 
        try {

            transaction = session.beginTransaction();
 
            // Create Customer, Item, Order, LiveOrder

            Customer customer = new Customer();

            customer.setName("Alice");

            customer.setAge(30);

            customer.setAddress("123 Main Street");

            customer.setPermanentAddress("456 Elm Street");

            session.save(customer);
 
            Item item = new Item();

            item.setName("Laptop");

            item.setDescription("Dell XPS 13");

            item.setQuantity(50);  // Starting inventory quantity

            item.setReorderQuantity(10); // Reorder threshold

            item.setMaxQuantity(100);   // Max inventory capacity

            session.save(item);
 
            Order order = new Order();

            order.setCustomer(customer);

            order.setStatus("Processing");

            session.save(order);
 
            LiveOrder liveOrder = new LiveOrder();

            liveOrder.setItem(item);

            liveOrder.setQty(50);

            liveOrder.setOrder(order);

            session.save(liveOrder);
 
            // Create Inventory Manager

            Inventory inventory = new Inventory(session);
 
            // Check and reorder items if required

            inventory.checkAndReorderItems();  // This will reorder the item if quantity < reorderQuantity
 
            // Place a new order for items

            inventory.placeOrder(item, 30);  // Attempting to place an order of 30 units
 
            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();

            }

            e.printStackTrace();

        } finally {

            session.close();

        }
 
        ((ClassPathXmlApplicationContext) context).close();

    }

}

 
