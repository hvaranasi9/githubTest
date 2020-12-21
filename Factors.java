import java.util.*;
public class Factors
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        int userNum = 1;
        // block to take user input to determine factors
        System.out.println("Enter a number");
        userNum = console.nextInt();
        while (userNum != 0)
        {
            factors(userNum, true);
            System.out.println("Enter a number");
            userNum = console.nextInt();
        }

        // block to take user input to determine prime factors
        System.out.println("Enter another number for prime factorization");
        userNum = console.nextInt();
        while (userNum != 0)
        {
            primeFactorization(userNum);
            System.out.println("Enter a number  for prime factorization");
            userNum = console.nextInt();
        }
    }

    //factors method
    //prints prime factors based on boolean parameter to this method
    public static int factors(int num, boolean printFactors)
    {
        int numFactors = 0;
        int[] listOfFactors = new int[num];
        for (int i = 2; i < num; i++)
        {
            if (num % i == 0)
            {  
                listOfFactors[numFactors] = i;
                numFactors++;
            }
        }
        if (printFactors)
        {
            printFactors(num, numFactors, listOfFactors);
        }
        return numFactors;
    }
    
    //prime factorization method
    //prints prime factors based on boolean parameter to this method
    public static void primeFactorization(int num)
    {
        int j = 0;
        int userInput = num;
        int[] primeFactors = new int[num];
        for (int i = 2; i <= num;)
        {
            if ((isPrime(i)) && (num % i == 0))
            {
                primeFactors[j] = i;
                j++;
                if ((isPrime(num)) && (num > i))
                {
                    primeFactors[j] = num;
                    j++;
                }
  
                num = num / i;
            }
            else
                i++;
        }
        System.out.print("The prime factorization for "+userInput+" is: ");
        for (int i = 0; i < j; i++)
        {
            if (i == j - 1 || j == 0)
            {
                System.out.println(primeFactors[i] + " ");
            }
            else
            {
                System.out.print(primeFactors[i] + " ");
            }
        }
    }
    
    // method to print the factors array
    public static void printFactors(int num, int numFactors, int[] listOfFactors)
    {
        System.out.print("There are " + numFactors + " factors for the number " + num + ": ");
        for (int i = 0; i < numFactors; i++)
        {
            if (i == numFactors - 1 || numFactors == 0)
            {
                System.out.println(listOfFactors[i] + " ");
            }
            else
            {
                System.out.print(listOfFactors[i] + " ");
            }
        }
    }

    
    // to determine if a given number is prime
    //returns true if prime number
    public static boolean isPrime(int num)
    {
        boolean isPrime = false;
        if (factors(num, false) == 0)
        {
            isPrime = true;
        }
        return isPrime;
    }
    
    }