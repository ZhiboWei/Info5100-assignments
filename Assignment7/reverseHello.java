package assignment7;

class ThreadList extends Thread { // score 2
    int num;

    public ThreadList(int num) {
        this.num = num;
    }

    public void run() {
        if (num == 50) {
            System.out.println("Hello from Thread " + this.num);
            return;
        }
        ThreadList tl = new ThreadList(num + 1);
        tl.start();
        try {
            tl.join();
        }catch(InterruptedException ie){
            System.out.println("Error");
        }
        System.out.println("Hello from Thread " + this.num);
    }
}

    public class reverseHello {
        public static void main(String[] args) {
            ThreadList tl = new ThreadList(1);
            tl.start();
        }
    }
