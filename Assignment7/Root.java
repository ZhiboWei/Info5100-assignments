package assignment7;

class Device{ // score 2
    public void startup(){
        System.out.println("The device is starting.");
    }
    public void shutdown(){
        System.out.println("The device is shutting down.");
        System.exit(0);
    }

}

class Sensor extends Thread{
        private final Device device;
        private double value;

        public Sensor(Device device){
            this.device = device;
        }
        public double getValue(){
            return value;
        }
        public void updateValue(){
            this.value = this.value + 0.001;
        }
        public void run() {
            while (true) {
                synchronized (device) {
                    this.updateValue();
                    device.notify();
                }
            }
        }
}

class Controller extends Thread{
    private Device device;
    private Sensor heat;
    private Sensor pressure;

    public Controller(Device device, Sensor heat, Sensor pressure){
        this.device = device;
        this.heat = heat;
        this.pressure = pressure;
    }

    public void run(){
        device.startup();
        synchronized (device){
            while(true){
                try{
                    device.wait();
                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
                System.out.println("Heat:" + heat.getValue());
                System.out.println("Pressure:" + pressure.getValue());
                if(heat.getValue() > 70 || pressure.getValue() > 100){
                    device.shutdown();
                    break;
                }
            }
        }
    }
}

public class Root {
    public static void main(String[] args){
        Device device = new Device();
        Sensor heat = new Sensor(device);
        Sensor pressure = new Sensor(device);

        Controller controller = new Controller(device,heat,pressure);

        controller.start();
        heat.start();
        pressure.start();

    }
}
