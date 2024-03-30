package LLD.DesignPatterns.Creational.SingleTon;

public class Main {
    public static void main(String[] args) {
        //Example of Singleton design pattern without multi Threading
        SingleTonWithoutMultiThreads singleton = SingleTonWithoutMultiThreads.getSingleTon();
        SingleTonWithoutMultiThreads s1 = SingleTonWithoutMultiThreads.getSingleTon();
        SingleTonWithoutMultiThreads s2 = SingleTonWithoutMultiThreads.getSingleTon();
        SingleTonWithoutMultiThreads s3 = SingleTonWithoutMultiThreads.getSingleTon();
        SingleTonWithoutMultiThreads s4 = SingleTonWithoutMultiThreads.getSingleTon();
        System.out.println(singleton);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        System.out.println();
        //Example of Singeton With multi threading;
        SingleTonWithMultiThreads s5 = SingleTonWithMultiThreads.getInstance();
        SingleTonWithMultiThreads s6 = SingleTonWithMultiThreads.getInstance();
        SingleTonWithMultiThreads s7 = SingleTonWithMultiThreads.getInstance();
        SingleTonWithMultiThreads s8 = SingleTonWithMultiThreads.getInstance();
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
        System.out.println(s8);
        
    }
}
