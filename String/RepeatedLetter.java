/*
 * problem description:-
 * Given string "hak[2r]de[3a]k"
 * then return hakrrdeaaak 
 */

 package String;

 class RepeatedLetter{
    static String solution(String A){
        String ans = "";

        for(int i=0; i<A.length(); i++){
            String num = "";
            if(A.charAt(i) == '['){
                int j;
                for( j=i+1; j<A.length(); j++){
                    if(A.charAt(j) >= 'A'){
                        break;
                    }
                    else{
                        num += A.charAt(j);
                    }
                }

                for(int k=1; k<=Integer.parseInt(num); k++){
                    ans += A.charAt(j);
                    i++;
                }
            }
            else if(A.charAt(i) == ']'){
                continue;
            }
            else{
                ans += A.charAt(i);
            }
           
        }

        return ans;
    }

    public static void main(String[] args) {
        String A = "hak[2r]de[3a]k";

        System.out.println(solution(A));
    }
 }