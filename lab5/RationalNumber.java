package lab5;

public class RationalNumber{
    int denom;
    int numer;

    public RationalNumber(int numer, int denom) throws IllegalArgumentException{
        if(denom==0){System.out.println("Cannot pass 0 as denominator of a fraction");throw new IllegalArgumentException();}
        this.numer = numer;
        this.denom = denom;
    }

    public int gcd(int a, int b){
        if(b==0){return a;}
        return gcd(b, a%b);
    }
    //  factoring algorithm is from google, not mine

    public int getDenom(){
        return this.denom;
    }
    public int getNumer(){
        return this.numer;
    }
    public String toString(){
        if(this.denom<0){this.denom*=-1;this.numer*=-1;}

        double ratio = this.numer/this.denom;
        if(ratio==numer){return "" + this.numer;}
        
        int div = gcd(this.numer, this.denom);

        return "" + this.numer/div + "/" + this.denom/div;
    }
}

































