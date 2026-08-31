package src.model;

import java.time.LocalDateTime;
import java.util.List;
public class Order{

    private Long id;
    private Client Client;
    private List<ItemOrder> itens;
    private boolean paid;
    private LocalDateTime creationDate;

    public Order(Long id, Client client, List<ItemOrder> itens, boolean paid){
        this.id = id;
        this.Client = client;
        this.itens = itens;
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + Client +
                ", paid=" + paid +
                '}';
    }

    public Double calculateTotal(){
        return itens.stream().map(item -> item.Product().price() * item.Quantity()).reduce(0.0, Double::sum);
    }

    public boolean isPaid(){
        return paid;
    }

    public Long getId(){
        return id;
    }

    public Client getClient(){
        return Client;
    }

    public List<ItemOrder> getItemOrders(){
        return itens;
    }
}
