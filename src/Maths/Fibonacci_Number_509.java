package Maths;



class Fibonacci {
    public  int fib(int n) {
        int a=0 , b=1;
        if (n == 0) return a;
        if (n == 1) return b;

        for(int i=2;i<=n;i++){
            int next = a+b;
            a=b;
            b=next;
        }
        return b;

    }

    public static void main(String[] args) {
        Fibonacci sol = new Fibonacci();
        int N=10;
        System.out.println("The fibonacci of "+N+" are : "+ sol.fib(N));

    }
}

// The fibonacci of 10 are : 55.