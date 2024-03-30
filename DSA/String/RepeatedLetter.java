/*
 *An encoded string (s) is given, and the task is to decode it. The encoding pattern is that the occurrence of the string is given at the starting of the string and each string is enclosed by square brackets.
Note: The occurance of a single string is less than 1000.

Example 1:

Input: s = 1[b]
Output: b
Explaination: 'b' is present only one time.
Example 2:

Input: s = 3[b2[ca]]
Output: bcacabcacabcaca
Explaination: 2[ca] means 'ca' is repeated 
twice which is 'caca' which concatenated with 
'b' becomes 'bcaca'. This string repeated 
thrice becomes the output.
Your Task:
You do not need to read input or print anything. Your task is to complete the function decodedString() which takes s as the input parameter and returns the decoded string.

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(|s|)

Constraints:
1 ≤ |s| ≤ 103 


 */

 package String;

import java.util.Stack;

class RepeatedLetter{
    

    //Optimised solution using stack
    static String decodedString(String s){
        // code here
        Stack<Integer> s1=new Stack<>();
        Stack<String> s2=new Stack<>();
        String str="";
        String ans="";
        int mul=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
               mul=mul*10+(ch-'0');
            }
            else if(ch=='['){
                s1.push(mul);
                mul=0;
                s2.push(Character.toString(ch));
            }
            else if(ch!=']'){
                    s2.push(Character.toString(ch));
                }
            else{
                String c="";
                while(s2.isEmpty()==false && !s2.peek().equals("[")){
                     c=s2.pop()+c;
                     }
                    str=c;
                      s2.pop();
                    int x=s1.pop();
                    ans="";
                    while(x>0){
                        ans+=str;
                        x--;
                    }
                    s2.push(ans);
                }
            }
            ans="";
    while(s2.isEmpty()==false){
        ans=s2.pop()+ans;
    }
        return ans;
    }

    public static void main(String[] args) {
        String A = "3[b2[ca]]";

        //System.out.println(solution(A));
        System.out.println(decodedString(A));
    }
 }