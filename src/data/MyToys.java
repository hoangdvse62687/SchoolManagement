/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class MyToys {

    public static final double VAT = 0.1;
    public static final double MAX_DOG_SPEED = 40.0;
    public static final double PI = 3.14;

    //đây là 1 field bình thường của class MyToys
    //dùng chung cho các hàm
    private static Scanner sc = new Scanner(System.in);

    //Hàm trả về số nguyên đích thực,bắt lệnh cà chớn
    //và hứng lên, có thể bắt ngoài biên, hứng lên có thể
    //thông báo mesage báo lỗiđộng, tùy tình huống thông báo chính xác lỗi gì
    //hà này thì chưa giải quyết hết các requirement ở trên
    public static int inputAnInteger(String str) {
        int n;
        do {
            try {
                System.out.println(str);
                n = Integer.parseInt(sc.nextLine());
                break; //nhập ngon lành thì bị văng xuống catch, do đó mình sẽ thoát vòng lặp vô tận
            } catch (Exception e) {
                System.out.println("Do ku know what is an integer ???");
            }
        }while (true);      
        return n;
    }
    public static double inputAnPositiveDouble(String str) {
        double n;
        do {
            try {
                System.out.print(str);
                n = Double.parseDouble(sc.nextLine());
                if (n < 0)
                    System.out.println("Please input a positive double !!!");
                else
                    break;
            } catch (Exception e) {
                System.out.println("Do ku know what is an double ???");
            }
        }while (true);      
        return n;
    }
    
    public static int inputAnPositiveInteger(String str) {
        int n;
        do {
            try {
                System.out.print(str);
                n = Integer.parseInt(sc.nextLine());
                if (n < 0)
                    System.out.println("Please input a positive integer !!!");
                else
                    break;
            } catch (Exception e) {
                System.out.println("Do ku know what is an integer ???");
            }
        }while (true);      
        return n;
    }
    
    public static double inputAnDouble(String str) {
        double n;
        do{
            try {
                System.out.print(str);
                n = Double.parseDouble(sc.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Please input a real number !");
            }
        }while (true);
        return n;
    }
    
    public static int inputAnIntegerMinMax(String msg, int min, int max) {
        int n;        
        if (min > max){
            int tmp = max;
            max = min;
            min = tmp;
        }
        do{
            try {
                System.out.print(msg);
                    n = Integer.parseInt(sc.nextLine());
                    if (n < min || n > max)
                        System.out.println("Please input a number between " +min+ " and " +max+ " !!!");
                    else
                        break;
            } catch (Exception e) {
                System.out.println("Please input an integer number !");
            }          
        }while (true);
        return n;
    }
    
    public static String inputAString(String msg){
        String m;
        System.out.print(msg);
        m = sc.nextLine();
        return m;
    }
    
}
