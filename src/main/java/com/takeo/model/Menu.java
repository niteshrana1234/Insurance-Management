package com.takeo.model;

public class Menu {

    public static void adminMenu(){

        System.out.println("\n1.Create customer \n2.Delete customer \n3.Delete policy \n4.Set claim status \n5.Go to main menu");
        System.out.print("Enter your choice:");
    }

    public static void clientMenu(){
        System.out.println("\n1.Edit customer information \n2.Show customer's details\n3.Buy policy \n4.Edit policy " +
                "\n5.File a claim \n6.Check claim status \n7.View policy details \n8.Go to main menu");
        System.out.print("Enter your choice:");
    }


}
