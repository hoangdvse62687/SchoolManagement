/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement;

import data.Menu;
import data.MyToys;
import data.School;

/**
 *
 * @author USER
 */
public class SchoolManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nameSchool = MyToys.inputAString("Input Name of School: ");
        int size = MyToys.inputAnPositiveInteger("Size of School: ");
        School fpt = new School(nameSchool, size);
        Menu menu = new Menu();
        int choice;
        do {
            choice = menu.showMenu();
            switch (choice) {
                case 1: fpt.addStudentProfile();
                    break;
                case 2: fpt.showStudentList();
                    break;
                case 3: fpt.searchStudentById();
                    break;
                case 4: fpt.deleteStudentById();
                    break;
                case 5: fpt.updateStudentById();
                    break;
                case 6: fpt.sortStudentByIdAscending();
                    break;   
                case 7: fpt.sortStudentByNameAscending();
                    break;     
            }
        } while (choice != 8);
    }

}
