import src.model.Client;
import src.model.ItemOrder;
import src.model.Order;
import src.model.Product;
import java.util.List;
import java.util.Optional;

import src.service.OrderService;
import src.functional.DiscountCalculator;

public class Main{
    

    public static void main(String[] args){
        Client client = new Client(1L, "Leandro", "leandro@email.com");
        Client client2 = new Client(3L, "Joao", "joao@email.com");
        //System.out.println(client);

        Product tv = new Product(1L, "Television", 2000.0);
        Product notebook = new Product(2L, "Notebook", 1500.0);
        //System.out.println(tv);

        ItemOrder item = new ItemOrder(tv, 2);
        ItemOrder item2 = new ItemOrder(notebook, 1);
        ItemOrder item3 = new ItemOrder(notebook, 2);
        //System.out.println(item);

        Order order1 = new Order(1L, client, List.of(item, item2), true);
        Order order2 = new Order(2L, client, List.of(item), false);
        Order order3 = new Order(3L, client2, List.of(item3), true);

        List<Order> orders = List.of(order1, order2, order3);
        OrderService orderService = new OrderService(orders);
        
        System.out.println(order1.calculateTotal());

        Optional<Order> result = orderService.searchForId(3L);

        if(result.isPresent()){
            System.out.println("Pedido encontrado ");
        }else{
            System.out.println("Pedido nao encontrado");
        }

        System.out.println("===== Paid Orders =====");   
        orderService.listPaidOrders().forEach(order -> System.out.println("Pedido " + order.getId() + " Pago")); 
        orderService.listPaidOrders().forEach(order -> System.out.println("Pedido " + order.getId() + " Pendente"));   
        
        System.out.println(orderService.searchForClient("Joao"));

        DiscountCalculator discount10 = value -> value * 0.9;
        double total = discount10.apply(order1.calculateTotal());
        System.out.println("Total com desconto: " + total);
        //orderService.generateReport();
    }
}