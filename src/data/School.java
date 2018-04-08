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
public class School {

    private String nameSchool;
    private Student[] student;
    private Student[] deletedStudent;
    private int count = 0, deletedCount = 0, deleteIndex = 0;

    public School(String nameSchool, int size) {
        this.nameSchool = nameSchool;
        student = new Student[size];
        deletedStudent = new Student[size];
    }

    public void addStudentProfile() {
        String choice;
        if (deletedCount == count)
            count = 0;
        if (count >= student.length) {
            System.out.println("Sorry, the student list is empty");
            return;
        }
        do {
            String id = MyToys.inputAString("Input id: ");
            String name = MyToys.inputAString("Input name: ");
            int yob = MyToys.inputAnPositiveInteger("Input yob: ");
            int phone = MyToys.inputAnIntegerMinMax("Input phone number: ", 0, 1000000000);
            int course = MyToys.inputAnPositiveInteger("Input course: ");
            Student s = new Student(id, name, yob, phone, course);
            student[count] = s;
            count++;
            if (count == student.length) {
                System.out.println("Sorry, the student list is full !");
                break;
            }
            choice = MyToys.inputAString("Continue ? (y/n): ");
        } while ("y".equals(choice));
    }

    public void showStudentList() {
        if (count < 1) {
            System.out.println("Sorry, the student list is empty");
            return;
        }
        System.out.println("School: " + nameSchool);
        for (int i = 0; i < count; i++) {
            System.out.println(student[i]);
        }
    }

    public void searchStudentById() {
        if (count < 1) {
            System.out.println("Sorry, the student list is empty");
            return;
        }
        int i;
        String choice;
        do {
            boolean flag = false;
            String idSearch = MyToys.inputAString("Input an Id you want to search: ");
            for (i = 0; i < count; i++) {
                if (idSearch.equals(student[i].getId())) {
                    System.out.println("Here is your student's information: " + student[i]);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("Sorry, That Id is not exist !");
                choice = MyToys.inputAString("Do you want to search in recycle ? (y/n): ");
                if ("y".equals(choice)) {
                    for (i = 0; i < deletedCount; i++) {
                        if (idSearch.equals(deletedStudent[i].getId())) {
                            System.out.println("Successful, Here is your student's information: " + deletedStudent[i]);
                            break;
                        }else
                            System.out.println("In here too...");
                    }

                }
            }
            choice = MyToys.inputAString("Continue ? (y/n): ");
        } while ("y".equals(choice));
    }

    public void deleteStudentById() {
        if (count < 1) {
            System.out.println("Sorry, the student list is empty");
            return;
        }
        int i;
        String choice;
        Student empty = new Student("empty", "empty", 0, 0, 0);
        do {
            boolean flag = false;
            String idSearch = MyToys.inputAString("Input an Id you want to delete: ");
            for (i = 0; i < count - deletedCount; i++) {
                if (idSearch.equals(student[i].getId())) {
                    deletedStudent[deletedCount] = student[i];
                    flag = true;
                    deletedCount++;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("Sorry, That Id is not exist !");
            } else {
                for (i = i; i <= count - deletedCount; i++) {
                    if (i == count - deletedCount) {
                        student[i] = empty;
                        break;
                    }
                    Student emp = student[i];
                    student[i] = student[i + 1];
                    student[i + 1] = emp;
                }
                for (i = 0; i < count - deletedCount; i++) {
                    System.out.println(student[i]);
                }
            }
            choice = MyToys.inputAString("Continue ? (y/n): ");
        } while ("y".equals(choice));
    }

    public void updateStudentById() {
        String choice;
        do {
            int i;
            boolean flag = false;
            String idSearch = MyToys.inputAString("Input an Id you want to update: ");
            for (i = 0; i < count - deletedCount; i++) {
                if (idSearch.equals(student[i].getId())) {
                    flag = true;
                    break;
                }
            }
            if (flag == true) 
                inputKindOfInformation(i);
            else
                System.out.println("Sorry, That Id is not exist !");
            
            choice = MyToys.inputAString("Continue ? (y/n): ");
        } while ("y".equals(choice));
    }

    public void inputKindOfInformation(int i) {
        String choice;
        do {
            choice = MyToys.inputAString("So what is kind of information do you want to update ?(id,name,yob,phone,course): ");
            String newInfor;
            int newInfor2;
            switch (choice) {
                case "id":
                    newInfor = MyToys.inputAString("New Id: ");
                    student[i].setId(newInfor);
                    break;
                case "name":
                    newInfor = MyToys.inputAString("New name: ");
                    student[i].setName(newInfor);
                    break;
                case "yob":
                    newInfor2 = MyToys.inputAnPositiveInteger("New yob: ");
                    student[i].setYob(newInfor2);
                    break;
                case "phone":
                    newInfor2 = MyToys.inputAnPositiveInteger("New phone number: ");
                    student[i].setPhone(newInfor2);
                    break;
                case "course":
                    newInfor2 = MyToys.inputAnPositiveInteger("New course : ");
                    student[i].setCourse(newInfor2);
                    break;
                default:
                    System.out.println("Sorry, that information is not exist.");
            }
            choice = MyToys.inputAString("Continue change information ? (y/n): ");
        } while ("y".equals(choice));
    }
    
    public void sortStudentByIdAscending () {
        for (int i = 0; i < (count - deletedCount) - 1; i++)
            for (int j = i+1; j < count - deletedCount; j++)
                if ((student[j].getId()).compareTo(student[i].getId()) < 0){
                    Student tmp = student[i];
                    student[i] = student[i+1];
                    student[i+1] = tmp;
                }   
        System.out.println("successful !");
    }
    
    public void sortStudentByNameAscending () {
        for (int i = 0; i < (count - deletedCount) - 1; i++)
            for (int j = i+1; j < count - deletedCount; j++){
                System.out.println((student[j].getName()).compareTo(student[i].getName()));
                if ((student[j].getName()).compareTo(student[i].getName()) < 0){
                    Student tmp = student[i];
                    student[i] = student[i+1];
                    student[i+1] = tmp;                   
                }
            }
        System.out.println("successful !");
    }
}
