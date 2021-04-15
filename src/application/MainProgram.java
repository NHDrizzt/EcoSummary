package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class MainProgram {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat a = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date date = a.parse(sc.next());
		System.out.println();
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		sc.nextLine();
		Order o = new Order(new Date(), status, new Client(name, email, date));
		System.out.print("How many items to this order? ");
		int items = sc.nextInt();
		for(int i=1; i<=items;i++) {
			sc.nextLine();
			System.out.println("Enter #"+i+" item data: ");
			System.out.print("Product name: ");
			String Pname = sc.nextLine();
			System.out.print("Product price: ");
			double Pprice = sc.nextDouble();
			System.out.print("Quantity: ");
			int qt = sc.nextInt();
			OrderItem oi = new OrderItem(qt, Pprice, new Product(Pname, Pprice));
			o.addItem(oi);
		}

		System.out.println(o);

		
	}

}
