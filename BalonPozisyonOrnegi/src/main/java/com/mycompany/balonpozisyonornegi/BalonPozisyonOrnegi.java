/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.balonpozisyonornegi;

/**
 *
 * @author ekink
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class BalonPozisyonOrnegi {

    private static class Node {
        int data;
        Node next; // bağlı listedeki sonraki düğümü temsil eder.
        
        public Node(int d) {
            data = d;
            next = null;
        }
    }
    
    private static void printList(Node head) {
        Node current = head;
        while (true) {
            System.out.print(current.data + " ");
            current = current.next;
            if (current == head) {
                break;
        }
    }
    }
    
    
    public static void balonPozisyonuBul(int n, int m) {
        // N adet balondan oluşacak dairesel bağlı listeyi oluşturma
        if (n <= 0 || m <= 0) 
        { // n veya m 0 veya daha küçükse hata mesajı yazdır ve fonksiyondan çık
            System.out.println("N ve M değerleri pozitif tam sayı olmalıdır.");
            return;
        }
        Node head = new Node(1);
        Node prev = head;
        for (int i = 2; i <= n; i++) {
            Node current = new Node(i);
            prev.next = current;
            prev = current;
        }
        prev.next = head;
        
        printList(head);
        // Problem metninde anlatıldığı şekilde son kalan balonu bulma
        Node current = head;
        Node onceki = head;
        while (current.next != current) {
            // M-1 kadar balon atlamak
            for (int i = 1; i < m; i++) {
                onceki = current;
                current = current.next;
            }
            // M. pozisyondaki balonu patlatmak
            System.out.println("\nPatlatilan balonun pozisyonu: " + current.data);
            onceki.next = current.next;
            current = current.next;
            
             printList(onceki);
        }
        
        // Son kalan balonun pozisyonunu yazdırma
        System.out.println("\nSon kalan balonun pozisyonu: " + current.data);
    }
    
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0, m = 0;

        while (true) {
            try {
                System.out.print("N değerini giriniz: ");
                n = scanner.nextInt();
                System.out.print("M değerini giriniz: ");
                m = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Hatalı giriş! Sadece sayı giriniz.");
                scanner.nextLine(); // hatalı girdiyi tüketmek için
            }
        }

        balonPozisyonuBul(n, m);
    }
}