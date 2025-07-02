// Create interface taxable

public interface Taxable {
    double salesTax = 0.07;
    double incomeTax = 0.105;

    double calcTax();
}


//Create class employee and implement incometax

public class Employee implements Taxable {
    private int empId;
    private String name;
    private double salary;

    public Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double calcTax() {
        double yearlySalary = salary * 12;
        return yearlySalary * incomeTax;
    }

    public void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Monthly Salary: " + salary);
        System.out.println("Income Tax (Yearly): ₹" + calcTax());
    }
}


//create class product and implements tax

public class Product implements Taxable {
    private int pid;
    private double price;
    private int quantity;

    public Product(int pid, double price, int quantity) {
        this.pid = pid;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public double calcTax() {
        return price * salesTax;
    }

    public void display() {
        System.out.println("Product ID: " + pid);
        System.out.println("Price: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Sales Tax (per unit): ₹" + calcTax());
    }
}


//get input for employee and product and print taxes.

import java.util.Scanner;

public class DriverMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("--- Enter Employee Details ---");
        System.out.print("Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double salary = scanner.nextDouble();

        Employee emp = new Employee(empId, name, salary);
        emp.display();


        System.out.println("\n--- Enter Product Details ---");
        System.out.print("Product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Price per unit: ");
        double price = scanner.nextDouble();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        Product prod = new Product(pid, price, quantity);
        prod.display();

        scanner.close();
    }
}



--- Enter Employee Details ---
Employee ID: 101
Name: Raju
Monthly Salary: 76000
Employee ID: 101
Name: Raju
Monthly Salary: 76000.0
Income Tax (Yearly): ₹95760.0

--- Enter Product Details ---
Product ID: 23
Price per unit: 55
Quantity: 10
Product ID: 23
Price: ₹55.0
Quantity: 10
Sales Tax (per unit): ₹3.8500000000000005
