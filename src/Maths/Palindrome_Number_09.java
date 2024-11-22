package Maths;

class Palindrome {
    public boolean isPalindrome(int x) {
        int rev = 0;
        int og = x;
        if(x<0){
            return false;
        }
        while(x>0){
            int ld = x%10;
            rev = rev*10+ld;
            x=x/10;
        }
        return og == rev;
    }

    public static void main(String[] args) {
        Palindrome sol = new Palindrome();
        int N = 121;
        if (sol.isPalindrome(N)){
            System.out.println("The Number "+N+" is Palindrome");
        }
        else {
            System.out.println("The Number "+N+" is Not Palindrome");
        }

    }
}

// The Number 121 is Palindrome.