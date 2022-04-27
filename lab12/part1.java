package lab12;

class part1{
    public static int indexOfSublist(int[] a, int[] t){
        int r = -1;
        for(int i = 0; i < (a.length - t.length); i++){
            if(a[i] == t[0]){
                boolean match = true;
                for(int j = 0; j < t.length; j++){
                    if(a[i+j] != t[j])match = false;
                }
                if(match) return i;
            }
        }
        return r;
    }
    
    public static void main(String[] args){
        int[] z = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] a = {4, 5, 6};
        int[] b = {7, 8, 9};
        int[] c = {2, 4, 6};
        System.out.println(indexOfSublist(z, a));
        System.out.println(indexOfSublist(z, b));
        System.out.println(indexOfSublist(z, c));
    }
}
