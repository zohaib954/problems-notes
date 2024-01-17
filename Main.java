public class Main {
    public static void main(String args[]) {
        System.out.println("This is main");

        Thread t1 = new Thread(new Test());
        Thread t2 = new Thread(new Test2());

        t1.start();
        try {

            t1.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            t2.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
