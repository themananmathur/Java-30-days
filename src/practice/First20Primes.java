package practice;

public class First20Primes {
    public static void main(String[] args) {
        int count = 0;
        int number =2;

        while(count < 1000000){
            if(isPrime(number)){
                System.out.println(number + " ");
                count++;
            }
            number++;
        }
    }

    public static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
