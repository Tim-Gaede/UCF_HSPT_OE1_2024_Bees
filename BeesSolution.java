import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.math.BigInteger.*;
public class BeesSolution {
    public static void main(String[] args) throws FileNotFoundException {
        File dir = new File("../bees");
        File[] directoryListing = dir.listFiles();
        String path = "bees";
        int counter = 1;
        if(directoryListing!=null){
            for (File child:directoryListing){
                if(!child.getName().endsWith(".in"))continue;
                PrintWriter out = new PrintWriter(new File(path+threeDigit(counter)+".out"));
                Scanner scan = new Scanner(child);
                int n = scan.nextInt();
                int[] arr =new int[n];
                for(int i = 0;i<n;i++){
                    arr[i] = scan.nextInt();
                }
                boolean[] freq =new boolean[10001];
                for(int i = 0;i<n;i++){
                    int[] occ =new int[101];
                    for(int j = 2;j<=100;j++){
                        while(arr[i]%j==0){
                            occ[j]++;
                            arr[i]/=j;
                        }
                    }
                    if(arr[i]<101)
                        occ[arr[i]]++;
                    int num = 1;
                    if(arr[i]>100){
                        num = arr[i];
                    }
                    for(int j = 2;j<occ.length;j++){
                        if(occ[j]%2==1){
                            
                            num*=j;   
                        }
                    }
                    
                    freq[num] = true;
                }
                int ans = 0;
                for(int i = 0;i<freq.length;i++){
                    if(freq[i])ans++;
                }
                out.println(ans);
                counter++;
                out.flush();
                out.close();
            }
        }else{
            System.out.println("it's alright try again!");
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
