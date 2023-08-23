package com.takeo.main;

import com.takeo.model.Address;
import com.takeo.model.Customer;

import java.util.*;

public class CustomerManagementModule {

    public static Map<Integer, Customer> customerList = new HashMap<>();


    public void addCustomer(Customer customer) {
        customerList.put(customer.getCustomerId(), customer);
        System.out.println("Name : "+customer.getFullName() + ", Customer ID : "+customer.getCustomerId());
    }

    public Customer customerInput() {
        CustomerManagementModule custom = new CustomerManagementModule();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[4mPersonal information:\u001B[0m ");
        System.out.print("Enter full name:");
        String name = scanner.nextLine();
        System.out.print("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter date of birth(DDMMYYYY):");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter email address:");
        String emailAddress = scanner.nextLine();
        Address address = custom.addressInput();
        return new Customer(name, phoneNumber, dateOfBirth, address);

    }

    public Address addressInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("********************************************");
        System.out.println("\u001B[4mAddress:\u001B[0m ");
        System.out.print("Building number:");
        int buildingNum = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Street:");
        String street = scanner.nextLine();
        System.out.print("zip code:");
        int zipCode = scanner.nextInt();
        scanner.nextLine();
        System.out.print("city:");
        String city = scanner.nextLine();
        System.out.print("state:");
        String state = scanner.nextLine();
        System.out.print("country:");
        String country = scanner.nextLine();
        Address address = new Address(buildingNum, street, state, zipCode, city, country);
        return address;
    }

    public void removeCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer Id:");
        int input = scanner.nextInt();
        if(verifyCustomer(input)){
            Customer selectedCustomer = customerList.get(input);
            customerList.remove(input);
            System.out.println(selectedCustomer.getFullName() + " has been removed from the list!!");
        } else{
            System.out.println("Customer ID not found");
        }

    }

    public void modifyCustomerInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Customer ID:");
        int input = scanner.nextInt();
        Customer selectClient = customerList.get(input);
        scanner.nextLine();
        System.out.println("\u001B[4mChange Of Information\u001B[0m ");
        System.out.print("Enter full name:");
        String name = scanner.nextLine();
        selectClient.setFullName(name);
        System.out.print("Enter phone number:");
        String phoneNumber = scanner.nextLine();
        selectClient.setPhoneNumber(phoneNumber);
        System.out.print("Enter date of birth(DDMMYYYY):");
        String dateOfBirth = scanner.nextLine();
        selectClient.setDateOfBirth(dateOfBirth);
        System.out.print("Enter email address:");
        String emailAddress = scanner.nextLine();
        selectClient.setEmailAddress(emailAddress);
        Address address = addressInput();
        selectClient.setAddress(address);
    }

    public void listOfCustomer() {
        int num = 1;
        System.out.println("\u001B[4mlists of Customer:\u001B[0m ");
        for (Map.Entry<Integer,Customer> map : customerList.entrySet()) {
            Customer customer = map.getValue();
            System.out.println(num + "." + customer.getFullName());
            num++;
        }
    }

    public Boolean verifyCustomer(int id) {
        boolean check = false;
        if(customerList.containsKey(id)){
            return true;
        }
        return check;
    }

}
