package com.company;
class student{
    String name;
    int id;

    public student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
class course{
    String name;
    int number;
    StringBuffer m = new StringBuffer();
    String[] a;
    int i=0;

    public course(String name) {
        this.name = name;
    }

    public String getStudent(){
        String str=m.toString();
        System.out.println(str);
        return str;
    }
    public boolean isFull(){
        if(number<=10 && number>0){
            System.out.println("The "+name+" class is not full!");
            return true;
        }else{
            System.out.println("The "+name+" class is full!");
            return false;
        }
    }
    public void registerStudent(student s){
        if(number<10 && number>=0){

            m.append(s.name+",");
            number++;
            System.out.println(s.name+" has registered the "+name+" class");
        }

    }


}

public class registrationSystem {
    public static void main(String[] args){
        student s=new student("Alice",001);
        course c=new course("Java");
        c.registerStudent(s);
        c.isFull();
        c.getStudent();

    }
}
