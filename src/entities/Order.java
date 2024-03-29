package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderitem = new ArrayList<>();
	
	public Order(){
	}

	public Order(Date moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderitem() {
		return orderitem;
	}

	public void addItem(OrderItem item) {
		orderitem.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderitem.remove(item);
	}
	
	public double total() {
		double sum = 0 ;
		for(OrderItem c : orderitem) {
			sum += c.subtotal();
		}
		return sum;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY: " + "\n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: "  + status + "\n");
		sb.append("Client: "+ getClient().getName() + " " + "("+ sdf2.format(getClient().getBirthDate())+")" + " - " + getClient().getEmail() + "\n");
		sb.append("Order items: " + "\n");
		for(OrderItem o : orderitem) {
			sb.append(o.getProduct().getName() + ", $" + String.format("%.2f",  o.getProduct().getPrice()) + ", " + "Quantity: " + o.getQuantity()+", "+ "Subtotal: $"+ String.format("%.2f", o.subtotal()) + "\n");	
		}
		sb.append("Total price: $" + String.format("%.2f", total()));

		
		return sb.toString();
	}

}
