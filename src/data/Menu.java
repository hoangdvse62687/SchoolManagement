/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author USER
 */
public class Menu {
       
    public int showMenu (){
        System.out.println("1.Add new student profile.");
        System.out.println("2.Show the student list.");
        System.out.println("3.Search a student by ID.");
        System.out.println("4.Delete a student by ID.");
        System.out.println("5.Update a student by ID.");
        System.out.println("6.Sort the student list by ID ascending.");
        System.out.println("7.Sort the student list by NAME ascending.");
        System.out.println("8.Exit program.");
        int choice = MyToys.inputAnIntegerMinMax("Input your choice: ", 1, 8);
        return choice;
    }
       
    
}
