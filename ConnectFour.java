import java.util.Scanner;
        
        
public class ConnectFour {
	/** Main method */
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] matrix = new char[6][7];
            print(matrix);
            dropDisk(matrix);
            }
        public static void print(char[][] matrix){
            for(int row=0;row<matrix.length;row++){
                for(int col=0;col<matrix[0].length;col++){
                    if(matrix[row][col]=='R' || matrix[row][col]=='Y')
                    System.out.print("|"+matrix[row][col]);
                    else
                        System.out.print("| ");
                }
                System.out.print("|");
                System.out.println("");
            }
            System.out.println("---------------");
        }
        public static void dropDisk(char[][] matrix){
            Scanner input = new Scanner(System.in);
            int i=0, index = 0, count=0;
            int[] column = new int[7];
            while(count!=42){
            if(i==0 ){
                System.out.print("Drop a red disk at column (0-6):");
                index = input.nextInt();
                matrix[5-column[index]][index]='R';
                print(matrix);
                 if(isConsecutiveFour(matrix)){
                    System.out.println("The red player won");
                    break;
                }
                column[index]++;
                i=1;
            }
            else {
                System.out.print("Drop a yellow disk at column (0-6):");
                index = input.nextInt();
                matrix[5-column[index]][index]='Y';
                print(matrix);
                if(isConsecutiveFour(matrix)){
                    System.out.println("The yellow player won");
                    break;
                }
                column[index]++;
                i=0;
            }
            count++;
        }
        }
         public static boolean isConsecutiveFour(char[][] matrix){
            for(int row=0;row<matrix.length;row++){
                int i=0;
                for(int col=0;col<matrix[row].length-1;col++){
                   if(matrix[row][col]==matrix[row][col+1] && matrix[row][col]!='\u0000')
                       i++;
                }
                if(i==3)
                    return true;
            }
            for(int row=0;row<matrix[0].length;row++){
                int i=0;
                for(int col=0;col<matrix.length-1;col++){
                   if(matrix[col][row]==matrix[col+1][row] && matrix[col][row]!='\u0000')
                       i++;
                }
                if(i==3)
                    return true;
            }
            int j=0,row;
            for(int i=3;i<matrix.length;i++){
                for(int k=0;k<matrix[0].length-3;k++){
                    row=i;
                    j=0;
                    for(int col=k;col<matrix[0].length-1 && row>0;col++,row--){
                        if(matrix[row][col]==matrix[row-1][col+1] && matrix[row][col]!='\u0000')
                            j++;
                    }
                    if(j==3)
                        return true;
            }
            }
            
            j=0;
             for(int i=0;i<matrix.length-3;i++){
                for(int k=0;k<matrix[0].length-3;k++){
                    row=i;
                    j=0;
                    for(int col=k;col<matrix[0].length-1 && row<matrix.length-1;col++,row++){
                        if(matrix[row][col]==matrix[row+1][col+1] && matrix[row][col]!='\u0000')
                            j++;
                    }
                    if(j==3)
                        return true;
            }
            }
            return false;
            }
}
