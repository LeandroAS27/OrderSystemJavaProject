import src.model.Client;
import src.model.ItemOrder;
import src.model.Order;
import src.model.Product;
import java.util.List;
import java.util.Optional;

import src.service.OrderService;

public class Main{
    

    public static void main(String[] args){
        Client client = new Client(1L, "Leandro", "leandro@email.com");
        //System.out.println(client);

        Product tv = new Product(1L, "Television", 2000.0);
        Product notebook = new Product(2L, "Notebook", 1500.0);
        //System.out.println(tv);

        ItemOrder item = new ItemOrder(tv, 2);
        ItemOrder item2 = new ItemOrder(notebook, 1);
        //System.out.println(item);

        Order order1 = new Order(1L, client, List.of(item, item2), false);

        List<Order> orders = List.of(order1);
        System.out.println(order1.calculateTotal());

        OrderService orderService = new OrderService(orders);
        Optional<Order> result = orderService.searchForId(1L);

        if(result.isPresent()){
            System.out.println("Encontrado: ");
            System.out.println(result.get());
        }else{
            System.out.println("Pedido não encontroado");
        }

        System.out.println(orderService.searchForClient("Leandro"));
        orderService.generateReport();
    }
}