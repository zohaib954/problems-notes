package hashing;
import java.util.HashMap;
class CountLetters{
    public static void countLetters(String A){
        HashMap<Character, Integer> hm = new HashMap<>();
        char c[] = A.toCharArray();
        int n = c.length;
        for(int i=0; i<n; i++){
           if(c[i] == 32){
            continue;
           }
           else if(hm.containsKey(c[i])){
            hm.put(c[i], hm.get(c[i])+1);
           }
           else{
            hm.put(c[i], 1);
           }
        }
      
        String temp = Character.toString(c[0]);
        for(int i=1; i<n; i++){
            if(c[i] == ' '){
                continue;
            }
            boolean a = true;
            for(int j=0; j<temp.length(); j++){
                 if(c[i] == temp.charAt(j)){
                    a = false;
                    break;
                 }
            }
            if(a){
                temp += c[i];
            }
        }
        int num[] = new int[temp.length()];

        for(int i=0; i<temp.length(); i++){
            num[i] = hm.get(temp.charAt(i));
        }

        for(int i=0; i<temp.length(); i++){
            System.out.println(temp.charAt(i)+":"+num[i]);
        }
      
        
    }

    public static void main(String[] args) {
        String s = "Hello world";
        countLetters(s);
        
    }
}