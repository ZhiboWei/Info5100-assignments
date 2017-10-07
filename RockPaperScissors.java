package com.company;

class Tool {
    private int strength;
    private char type;

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setType(char type) {
        this.type = type;
    }

    public char getType() {
        return type;
    }

    public boolean fight(Tool a){
        System.out.println("Tool");
        return false;
   }
}

class Rock extends Tool{
    int strength;
    char type;
    @Override
    public void setStrength(int strength) {
        this.strength=strength;
    }

    @Override
    public void setType(char type) {
        this.type=type;
    }

    @Override
    public char getType() {
        return type;
    }

    @Override
    public boolean fight(Tool t) {
        Rock rock = new Rock();
        int temp;
        temp=rock.strength;
        if(t.getType()=='s'){
            temp=temp*2;
            System.out.println("Rock meets scissor! True");
        }
        if(t.getType()=='p'){
            temp=temp/2;
            System.out.println("Rock meets paper! False");
            return false;
        }
        return true;
    }
}
class Paper extends Tool{
    int strength;
    char type;
    @Override
    public void setStrength(int strength) {
        super.setStrength(strength);
    }

    @Override
    public void setType(char type) {
        this.type=type;
    }

    @Override
    public char getType() {
        return type;
    }

    @Override
    public boolean fight(Tool t) {
        Paper p = new Paper();
        int temp;
        temp=p.strength;
        if(t.getType()=='s'){
            temp=temp/2;
            System.out.println("Paper meets scissor! False");
            return false;
        }
        if(t.getType()=='r'){
            temp=temp*2;
            System.out.println("Paper meets rock! True");
        }
        return true;
    }
}
class Scissors extends Tool {
    int strength;
    char type;

    @Override
    public void setStrength(int strength) {
        super.setStrength(strength);
    }

    @Override
    public void setType(char type) {
        this.type=type;
    }

    @Override
    public char getType() {
        return type;
    }

    @Override
    public boolean fight(Tool t) {
        Scissors s = new Scissors();
        int temp;
        temp = s.strength;
        if (t.getType() == 'r') {
            temp = temp / 2;
            System.out.println("Scissor meets rock! False");
            return false;
        }
        if (t.getType() == 'p') {
            temp = temp * 2;
            System.out.println("Scissor meets paper! True");
        }
        return true;
    }

}
public class RockPaperScissors{
    public static void main(String[]args){
        Tool a=new Rock();
        a.setType('r');
        Tool b=new Paper();
        b.setType('p');
        Tool c=new Scissors();
        c.setType('s');
        a.fight(b);
        a.fight(c);
        b.fight(a);
        b.fight(c);
        c.fight(b);
        c.fight(a);
        }

}

