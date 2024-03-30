package LLD.DesignPatterns.Creational.SingleTon;

public class SingleTonWithMultiThreads {
    private static SingleTonWithMultiThreads instance;

    private SingleTonWithMultiThreads(){}

    public static SingleTonWithMultiThreads getInstance(){
        if(instance == null){
            synchronized (SingleTonWithMultiThreads.class){

                if(instance == null){
                    instance = new SingleTonWithMultiThreads();
                }
            }
        }
        return instance;
    }
}
