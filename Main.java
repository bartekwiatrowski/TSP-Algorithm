import java.util.Scanner;

public class Main {

    double dlugosc(int x1,int x2, int y1, int y2) //metoda
    {
        double dlugosc;
        dlugosc=Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2)); //wzór
        return dlugosc;
    }




    private static final int nieskonczonosc = 100000;

    public static void main(String[] args) {

        int n; //liczba wierzcholkow
        int A[][];
        int D[];
        String s;
        int i,j,k;
        int N;

        System.out.println("Podaj liczbę wierzcholkow");
        Scanner z = new Scanner(System.in);
        n = z.nextInt();
//n = Console.readInt();
        D = new int[n];
        A = new int[n][];
        for (j=0;j<n;j++) {
            A[j] = new int[n];
        }

        System.out.println("Podaj wagi krawędzi, * oznacza nieskonczonosc");
        for (j=0;j<n;j++)
            for (i=0;i<n;i++) {

                Scanner scanner = new Scanner(System. in);
                s = scanner.nextLine();
                System.out.println("A["+j+", "+i+"]=");
//s = Console.readString("A["+j+", "+i+"]=");
                if (s.compareTo("*")!=0)

                    A[j][i]=Integer.parseInt(s);
                else
                    A[j][i]=nieskonczonosc;
            }

        for (i=0;i<n;i++) D[i]=A[0][i];
//  Przyjmujemy, że s=1, szukamy więc najkrótszych dróg od wierzchołka 1 do pozostałych
        for (k=1;k<=n-2;k++) {
            for (i=1;i<n;i++)
                for (j=0;j<n;j++) {
                    if (D[j]+A[j][i]>nieskonczonosc)
                        N=nieskonczonosc;
                    else
                        N=D[j]+A[j][i];
                    D[i]=Math.min(D[i],N);
                }
        }
        k=nieskonczonosc;
        for (i=0;i<n;i++)
            if (D[i]<k)
                System.out.println("D["+i+"] = [" + D[i] + "]");
            else
                System.out.println("D("+i+")=*");

    }
}