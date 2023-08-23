package sorting;



class InversionCount{
     
    public static void main(String[] args) {
        int A = 10;
        int count = 0;
        for(int i=1; (i*i)<=A; i++){
           
            if(i== Math.sqrt(A)){
                 System.out.println(Math.sqrt(A));
                count ++;
            }
            else if(A%i == 0){
                count += 2;
            }
        }
        System.out.println("count is "+count);
    }
}