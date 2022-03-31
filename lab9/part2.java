package lab9;

public class part2 {
    static int digitMatch(int a, int b){
        if(a/10==0||b/10==0)return a%10==b%10?1:0;
        return  (a%10==b%10?1:0) + digitMatch(a/10, b/10);
    }

    public static void main(String[] args){
        System.out.println(digitMatch(1072503891, 62530841));
        System.out.println(digitMatch(941, 94));
        System.out.println(digitMatch(111, 111));
    }
}
