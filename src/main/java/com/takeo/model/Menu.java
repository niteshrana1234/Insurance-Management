package com.takeo.model;

public class Menu {

    public static void adminMenu(){

        System.out.println("1.Create customer \n2.Delete customer \n3.Delete policy 4.Set claim status \n5.Go to main menu");
        System.out.println("Enter your choice:");
    }

    public static void clientMenu(){
        System.out.println("1.Edit customer information \n2.Buy policy \n3.Edit policy \n4.File a claim \n5.Check claim status \n6.Go to main menu");
        System.out.println("Enter your choice:");
    }


}
