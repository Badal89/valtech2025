package ass_trl;


import org.hibernate.Session;
 
import java.util.List;
 
public class Inventory {
 
    private Session session;
 
    public Inventory(Session session) {

        this.session = session;

    }
 
    // Method to check and reorder items if their quantity goes below reorder threshold

    public void checkAndReorderItems() {

        List<Item> items = session.createQuery("FROM Item", Item.class).list();

        for (Item item : items) {

            if (item.getQuantity() < item.getReorderQuantity()) {

                // Reorder items to maintain max quantity

                reorderItem(item);

            }

        }

    }
 
    // Method to reorder an item if stock is low

    public void reorderItem(Item item) {

        // Check if item quantity is below reorder quantity

        if (item.getQuantity() < item.getReorderQuantity()) {

            int qtyToOrder = item.getMaxQuantity() - item.getQuantity();

            // Reorder to maintain maximum quantity

            System.out.println("Reordering " + qtyToOrder + " units of " + item.getName());
 
            // Update item quantity

            item.setQuantity(item.getMaxQuantity());

            session.update(item);

        }

    }
 
    // Method to place an order for items

    public void placeOrder(Item item, int orderQuantity) {

        if (item.getQuantity() >= orderQuantity) {

            item.setQuantity(item.getQuantity() - orderQuantity);  // Decrease quantity in inventory

            session.update(item);

            System.out.println("Order placed for " + orderQuantity + " units of " + item.getName());

        } else {

            System.out.println("Not enough stock for " + item.getName() + ". Only " + item.getQuantity() + " available.");

        }

    }

}

 
