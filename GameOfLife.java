

import java.util.Arrays;

public class GameOfLife{
  public static void main(String[] args){
    
  }
  //2a
  public static boolean isValidUniverse(int[][] a){//write a method to check if array is a matrix
    int r;//row
    int c;//column, length can differ per row
    for(r=0; r< a.length; r++){
      if((r< a.length-1)&&(a[r].length != a[r+1].length)){
        return false;
      }else {//only if column sizes are the same will come to else if
        for(c=0; c<a[0].length; c++){//check if all the element of sub array r either 1 or 0
          if(!((a[r][c]==1)||(a[r][c]==0))){
            return false;
          }
        }
      }
    }return true;
  }
  
  //2b
  public static void displayUniverse(int[][] a){//method to display universe
    int r;//row
    int c;//column
    int z;//index to draw border
    System.out.print("+");//draw upper border
    for(z=0; z< a[0].length; z++){//valid universe has same column in every row
      System.out.print("-");
    }
    System.out.println("+");
    
    for(r=0; r< a.length; r++){//use for loop to create the pattern
      System.out.print("|"); //draw left side border
      for(c=0; c< a[0].length; c++){
        if(a[r][c]==1){
          System.out.print('*');//use * to indicate live cells
        }else{
          System.out.print(' ');
        }     
      }
      System.out.print("|");//draw right side border and change line
      System.out.println();   
    }
    
    System.out.print("+");//draw bottom bother 
    for(z=0; z< a[0].length; z++){
      System.out.print("-");
    }
    System.out.println("+");
  }
  //2c
  //method to get cell from next generations 
  public static int getNextGenCell(int[][] a, int x, int y){
    int count=0;//number of neibour are alive
    //condition for neibouring cell
    if((x-1>=0)&&(y-1>=0)){
      if(a[x-1][y-1]==1){//NorthWest
        count++;
      }
    }

    if(y-1>=0){
      if(a[x][y-1]==1){//W
        count++;
      }
    }
    
    if((x+1<a.length)&&(y-1>=0)){
      if(a[x+1][y-1]==1){//SW
        count++;
      }
    }

    if(x-1>=0){
      if(a[x-1][y]==1){//N
        count++;
      }
    }

    if(x+1<a.length){
      if(a[x+1][y]==1){//S
        count++;
      }
    }
    
    if((x-1>=0)&&(y+1<a[0].length)){
      if(a[x-1][y+1]==1){//NE
        count++;
      }
    }
    
    if(y+1<a[0].length){
      if(a[x][y+1]==1){//E
        count++;
      }
    }

    if((x+1<a.length)&&(y+1<a[0].length)){
      if(a[x+1][y+1]==1){//SE
        count++;
      }
    }
    //check condition to see cell live or not  
    if((a[x][y]==1) && count< 2 || count>3){//alive cell die if neibour >3 or <2
      return 0;
    } else if ((a[x][y]==0) && count==3){//dead cell will be alive if neibour is==3
      return 1;     
    } return a[x][y];//Any live cell with two or three live neighbors lives on to the next generation.
  }
  
  //2d
  //method to create next generation universe
  public static int[][] getNextGenUniverse(int[][] a){
    int[][] nextGenUniverse= new int[a.length][a[0].length];//new generation should have same size for row n col
    
    for(int i=0; i<a.length; i++){
      for(int j=0; j<a[0].length; j++){
        nextGenUniverse[i][j]= getNextGenCell(a, i, j);
      }
    }return nextGenUniverse;
  }
  
  //2e
  public static void simulateNGenerations(int[][]a, int n){
    
    if(!isValidUniverse(a)){
      throw new IllegalArgumentException("The universe needs to be a matrix");
    }//verify if it is a valid universe
    
    int[][] nextGeneration= a;//create new array to update next generation      
    System.out.println("Original Seed");
    displayUniverse(a);//display the original universe
    
    for(int i=1; i<=n; i++){//i is index of the generation
      System.out.println("Generation " + i);
      nextGeneration= getNextGenUniverse(nextGeneration);//update the generation
      displayUniverse(nextGeneration);
    }
    
  } 
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
