package src.service;
import java.util.Comparator;
import java.util.List;
import src.model.Order;
import java.util.Optional;
import src.functional.DiscountCalculator;
public class OrderService implements DiscountCalculator {

    private List<Order> orders;

    public OrderService(List<Order> orders){
        this.orders = orders;
    }

    @Override
    public double apply(double value) {
        return value * 0.9;
    }

    public List<Order> listPaidOrders(){
        if(orders.stream().filter(order -> order.isPaid()).findFirst().isPresent()){
            List<Order> paidOrders = orders.stream().filter(order -> order.isPaid()).toList();
            return paidOrders;
        }else{
            List<Order> paidOrders = orders.stream().filter(order -> !order.isPaid()).toList();
            return paidOrders;
        }
        
    }

    public Optional<Order> searchForId(Long id){
        return orders.stream().filter(order -> order.getId().equals(id)).findFirst();
    }

    //melhorar o retorno do pedido que o cliente pediu
    public List<Order> searchForClient(String name){
        return orders.stream().filter(order -> order.getClient().name().equalsIgnoreCase(name)).toList();
    }

    public Optional<Order> searchForExpensiveItem(){
        return orders.stream().max(Comparator.comparing(order -> order.calculateTotal()));
    }

    public void generateReport(){
        long totalOrders = orders.stream().count();

        long paidOrders = orders.stream().filter(order -> order.isPaid()).count();

        long pendingOrders = orders.stream().filter(order -> !order.isPaid()).count();

        double totalRevenue = orders.stream().map(order -> order.calculateTotal()).reduce(0.0, Double::sum);

        double averageTicket = orders.stream().mapToDouble(order -> order.calculateTotal()).average().orElse(0.0);

        System.out.println("===== REPORT =====");
        System.out.println("Total Orders: " + totalOrders);
        System.out.println("Paid Orders: " + paidOrders);
        System.out.println("Pending Orders: " + pendingOrders);
        System.out.println("Revenue: " + totalRevenue);
        System.out.println("Average Ticket: " + averageTicket);

    }
}
