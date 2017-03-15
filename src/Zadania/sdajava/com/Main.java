package Zadania.sdajava.com;

public class Main {

    public static void main(String[] args) {

        ParabolicFunction parabolicFunction = new ParabolicFunction();

        //wrzucam wykres funkcji paraboli
       parabolicFunction.parabol();

       //określam zakres prostokąta
        parabolicFunction.giveRange();

        //wrzucam punkty losowe i zliczam punkty niebiesikie i czerwone

        parabolicFunction.monteCarlo();

    }
}
