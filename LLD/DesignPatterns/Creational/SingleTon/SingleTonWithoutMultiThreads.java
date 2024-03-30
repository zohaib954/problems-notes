package LLD.DesignPatterns.Creational.SingleTon;

public class SingleTonWithoutMultiThreads {
    private static SingleTonWithoutMultiThreads instance;

    private SingleTonWithoutMultiThreads(){}

    public static SingleTonWithoutMultiThreads getSingleTon(){
        if(instance == null){
            instance = new SingleTonWithoutMultiThreads();
        }
        return instance;
    }
}
