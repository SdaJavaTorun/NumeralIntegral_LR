package Zadania.sdajava.com;

import java.util.Random;
import java.util.Scanner;

public class ParabolicFunction {
    public double x, y, a, b, c, x1, x2, delta;
    public int xp, xk, yk, yp, P;

    public ParabolicFunction() {
        this.x = x;
        this.y = y;
        this.a = a;
        this.b = b;
        this.c = c;
        this.xk = xk;

    }

    public void parabol() {
        //tworzymy wykres paraboliczny funkcji kwadratowej
        System.out.println("Podaj a: ");
        Scanner aa = new Scanner(System.in);
        a = aa.nextDouble();
        System.out.println("Podaj b: ");
        b = aa.nextDouble();
        System.out.println("Podaj c: ");
        c = aa.nextDouble();

        delta = b * b - 4 * a * c;

        if (delta == 0) {
            x1 = (-b) / (2 * a);
            System.out.printf("Jedno miejce zerowe: %10.3f%n", +x1);
        }
        if (delta < 0) {
            x1 = (-b) / (2 * a);
            System.out.printf("Brak miejsc zerowych!!! \nWierzchołek X: %10.3f%n", +x1);
        }
        if (delta > 0) {
            x1 = (-b + Math.sqrt(delta)) / (2 * a);
            x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.printf("Dwa miejsca zerowe, X1: %10.3f%n", +x1);
            System.out.printf("Dwa miejsca zerowe, X1: %10.3f%n", +x2);
        }
    }

    public void giveRange() {

        //Wybieramy zakres obliczeń
        System.out.println("Xp < Xk i Yp < Yk!!!");
        System.out.println("Podaj zakres obliczeń Xp: ");
        Scanner xx1 = new Scanner(System.in);
        xp = xx1.nextInt();
        System.out.println("Podaj zakres obliczeń Xk: ");
        xk = xx1.nextInt();
        System.out.println("Podaj zakres obliczeń Yp: ");
        yp = xx1.nextInt();
        System.out.println("Podaj zakres obliczeń Yk: ");
        yk = xx1.nextInt();

        P = (Math.abs(xk - xp)) * (Math.abs(yk - yp));

        System.out.println("\nPole kwadratu: " + P + "\n");
    }

    public void monteCarlo() {
        int i = 50;
        float czerwone = 0, niebieskie = 0;
        double l, calka;
        System.out.println("Losujemy!!!");


        while (i >= 0) {
            Random rand = new Random(); // tworze generator liczb losowych
            int PunktX = rand.nextInt(xk - xp + 1) + xp;
            int PunktY = rand.nextInt(yk - yp + 1) + yp;

            l = a * a * PunktX + b * PunktX + c;  // według tej funkcji będziemy sprawdzać położenie punktu
            System.out.println("Punkt nr: " + i + " X: " + PunktX + " Y: " + PunktY); //wypluwa punkty

            if ((l > PunktY) && (PunktY > 0)) {
                System.out.println("Ponad osią x i pod wykresem!!!");
                niebieskie++;
                // i--;
            }
            if ((l < PunktY) && (PunktY < 0)) {
                System.out.println("Pod osią x i nad wykresem!!!");
                czerwone++;
                // i--;
            }
            if (l == PunktY) {
                System.out.println("Punkt leży na funkcji!!!");
                //  i--;
            }
            else{
                System.out.println("Punkt poza zakresem obliczeń!!!");
            }
            i--;
        }
        System.out.println("Czerwone: " + czerwone + " Niebieskie: " + niebieskie);
        float stos = czerwone / niebieskie;
        System.out.println("Czerwone/Niebieskie: " + stos);
        calka = P * (czerwone / niebieskie);
        System.out.println("Całka:" + calka);

    }


}
