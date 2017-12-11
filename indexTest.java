package assignment6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

class MyIndexOutOfBoundException extends IndexOutOfBoundsException{ // score 2
    int lowerBound;
    int upperBound;
    int index;
    MyIndexOutOfBoundException(int lowerBound,int upperBound,int index){
        String message = "Error Message: Index: " +index+",but Lower Bound: "+lowerBound+",Upper bound: "+upperBound;
        throw new MyIndexOutOfBoundException(message);
    }
    MyIndexOutOfBoundException(String message){
        super(message);
    }
}

public class indexTest {
    public static void printArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int i = 6;
        arr[i]= 4;
                throw new MyIndexOutOfBoundException(0, arr.length-1, i);
        }
    //2.modify the parse() method
    public static void parse(File file)throws IOException{ // score 1
        RandomAccessFile input = null;
        String line = null;
        try{
            input = new RandomAccessFile(file,"r");
            while((line=input.readLine())!=null){
                System.out.println(line);
            }
            return;
        }finally{
            if(input!=null){
                input.close();
            }
        }
    }


    public static void main(String[] args){
        //1.create an exception
        try {
            printArray();
        }catch(IndexOutOfBoundsException ie){
            System.out.println(ie.getMessage());
        }
    }

}


