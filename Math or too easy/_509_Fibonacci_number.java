class _509_Fibonacci_number {
    int[] Fib = new int[31];
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        if(Fib[n] != 0) return Fib[n];
        return Fib[n] = fib(n - 2) + fib(n - 1);
    }
}
