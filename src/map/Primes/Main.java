package map.Primes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Random;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Set;



public class Main {

    public static <integer> int[] appendToArray(int[] elements, int element)
    {
        int[] newArray = Arrays.copyOf(elements, elements.length + 1);
        newArray[elements.length] = element;

        return newArray;
    }

    public static void main(String[] args) {

        //zapis cisiel do suboru

        Random rand = new Random();

        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter("cisla.txt"));
            for (int i = 0; i < 1000; ++i) {
                //toString
                writer.write((rand.nextInt(100) + 1) + " ");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nepodarilo sa vytvorit subor!");
        } catch (IOException e) {
            System.out.println("Nepodarilo sa zapisat do suboru!");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Subor sa nepodarilo zatvorit!");
            }

        }

//vyberprvocisel

        BufferedReader br = null;
        String[] slova = new String[0];
        try {
            br = new BufferedReader(new FileReader("cisla.txt"));
            String riadok;
            slova = null;
            while ((riadok = br.readLine()) != null)
            {
                slova = riadok.split(" ");
//                for (String slovo : slova)
//                {
//                    System.out.println(slovo);
//                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Subor sa nepodarilo otvorit!");
        } catch (IOException e) {
            System.out.println("Chyba pri citani dat!");
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Chyba pri uzatvarani suboru!");
            }
        }

        int []prvocisla = new int[0];

        try {
            writer = new BufferedWriter(new FileWriter("prvocisla.txt"));

            for(String slovo:slova)
            {
                int cislo = Integer.parseInt(slovo);
                for (int i = 2; i <= cislo; ++i )
                {
                    if(cislo == 2)
                    {
                        prvocisla = appendToArray(prvocisla,2);
                    }
                    else if (i == cislo - 1)
                    {
                        prvocisla = appendToArray(prvocisla,cislo);
                        break;
                    }
                    else if(cislo % i == 0)
                    {
                        break;
                    }

                }
            }
//      CHECK, CO TO VYPISUJE
//            for(int i = 0; i < prvocisla.length; ++i)
//            {
//                System.out.printf("%d ",prvocisla[i]);
//            }

            for(int i = 0; i < prvocisla.length; ++i)
            {
                writer.write(prvocisla[i] + " ");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Nepodarilo sa vytvorit subor!");
        } catch (IOException e) {
            System.out.println("Nepodarilo sa zapisat do suboru!");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Subor sa nepodarilo zatvorit!");
            }
        }


//pocitanie prvocisiel, primes je zoznam prvocisel od 1-100
        try {
            writer = new BufferedWriter(new FileWriter("pocetnost.txt"));
            int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};


            int[] pocetnost = new int[primes.length];

            for(int i = 0; i < primes.length; ++i)
            {
                pocetnost[i] = 0;
            }

            for(int i = 0; i < prvocisla.length; ++i)
            {
               for(int j = 0; j < primes.length; ++j)
               {
                   if(prvocisla[i] == primes[j])
                   {
                       pocetnost[j] += 1;
                   }
               }
            }

            for(int i = 0; i < primes.length; ++i)
            {
                writer.write(primes[i]+" "+pocetnost[i]+"\r\n");
            }

//            for(int i = 0; i < primes.length; ++i)
//            {
//                System.out.printf("\n%d ",primes[i]);
//            }

        } catch (FileNotFoundException e) {
            System.out.println("Nepodarilo sa vytvorit subor!");
        } catch (IOException e) {
            System.out.println("Nepodarilo sa zapisat do suboru!");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Subor sa nepodarilo zatvorit!");
            }
        }





    }
}

