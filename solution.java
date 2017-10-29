// extra credit 5
package midterm;

import java.util.ArrayList;

class Cell{
    int x;
    int y;
    Cell(int x,int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "["+x+","+y+"]";
    }
}

class map{
    int[][] maze;
    Cell end;

    public map(int[][] maze,Cell end){
        this.maze=maze;
        this.end=end;
    }
    public boolean isArrived(){
        return maze[end.x][end.y]==2;
    }
    public boolean isEmpty(Cell c){
        return maze[c.x][c.y]==1;
    }
    public void empty(Cell c){
        maze[c.x][c.y]=1;
    }
    public void step(Cell c){
        maze[c.x][c.y]=2;
    }
    public void print(){
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[i].length;j++){
                if(maze[i][j]==2){
                    System.out.print("["+i+","+j+"]");
                }
            }
            System.out.println();
        }
    }

}

public class solution {

    public static void go(map m, Cell c){
        m.step(c);
        if(c.y<m.maze[0].length-1){
            test(m,new Cell(c.x,c.y+1));
        }
        if(c.x<m.maze.length-1){
            test(m,new Cell(c.x+1,c.y));
        }
        if(!m.isArrived()){
            m.empty(c);
        }
    }
    public static void test(map m,Cell c){
        if(!m.isArrived()&&m.isEmpty(c)){
            go(m,c);
        }
    }
    public static void main(String[] args){
        //result should be [[0,0],[1,0],[2,0],[3,0],[3,1],[4,1],[4,2],[4,3],[4,4]]
        // your result is [[0,0],[1,0],[2,0],[3,0],[3,1],[4,1],[4,2]]

        int[][] maze={
                {1,1,0,0,1},
                {1,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {0,1,1,1,1}
        };
        map m = new map(maze,new Cell(4,2));
        solution.go(m,new Cell(0,0));
        m.print();
    }
}
