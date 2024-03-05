import java.io.*;
import java.util.*;
import java.math.*;
public class BeesGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String path = "bees";
        int counter = 9;
        
        for(int i = 0;i<8;i++){
            PrintWriter out = new PrintWriter(new File(path+threeDigit(counter)+".in"));
            int n = (int)(Math.random()*5)+99_996;
            if(i==0)n = 10000;
            if(i==0){
                out.println(n);
                for(int j = 0;j<n;j++){
                    out.print(1+" ");
                }
            }else if(i == 1){
                out.println(n);
                for(int j = 0;j<n;j++){
                    out.print(10000+" ");
                }
            }else if(i == 2){
                // only prime numbers
                ArrayList<Integer> nums = new ArrayList<>();
                for(int j = 2;j<=10000;j++){
                    BigInteger curr = BigInteger.valueOf(j);
                    if(curr.isProbablePrime(32)){
                        nums.add(j);
                    }
                }
                out.println(nums.size());
                for(Integer in:nums){
                    out.print(in+" ");
                }
            }else if(i == 3){
                // only composite numbers
                ArrayList<Integer> nums = new ArrayList<>();
                for(int j = 2;j<=10000;j++){
                    BigInteger curr = BigInteger.valueOf(j);
                    if(!curr.isProbablePrime(32)){
                        nums.add(j);
                    }
                }
                out.println(nums.size());
                for(Integer in:nums){
                    out.print(in+" ");
                }
            }else{
                out.println(n);
                for(int j = 0;j<n;j++){
                    out.print((int)(Math.random()*10000+1)+" ");
                }
            }
            
            out.println();
            out.flush();
            out.close();
            counter++;
        }
    }
    public static String threeDigit(int n){
        String s = Integer.toString(n);
        while(s.length()<3){
            s = "0"+s;
        }
        return s;
    }
}
