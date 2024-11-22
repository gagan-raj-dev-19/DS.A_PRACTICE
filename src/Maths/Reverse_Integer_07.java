package Maths;

class ReverseInteger {
    public int reverse(int x) {
        int rev = 0;

        while(x!=0){
            int ld = x%10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && ld > 7)) {
                return 0; // Overflow for positive number
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && ld < -8)) {
                return 0; // Overflow for negative number
            }
            rev = rev*10 +ld;
            x=x/10;
        }
        return rev;
    }

    public static void main(String[] args) {
        ReverseInteger obj = new ReverseInteger();
        int N = 1234;
        System.out.println(obj.reverse(N));

    }
}


