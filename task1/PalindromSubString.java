import java.util.Scanner;

class Runner{
 public static void main(String[] args) {
    //getting a input value from user
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string value");
        //casting a string value
       String str=sc.next();
    getstring(str);
       
    }
        public static void getstring(String str){
            
        for(int i=0;i<=str.length()-1;i++){
            for(int j=i+1;j<=str.length();j++){
              String substring=str.substring(i, j);
              if(Ispalindrome(substring)==true){
                System.out.println(substring);
              }
            }
        }
    }
        private static boolean Ispalindrome(String str) {
        int i=0;
        int j=str.length()-1;
while(i<=j){
    char ch1=str.charAt(i);
   char ch2=str.charAt(j);

    if(ch1!=ch2){
        return false;

    }
    else{
        i++;
        j--;
    }

}
return true;

        }


}