import java.util.NoSuchElementException;

public class determinant {
    public static int determinantFinder(int [][] arr){
       
        if(isSquareMatrix(arr)){
            return deter(arr,0);
        } else {
            throw new NoSuchElementException("It must be square matrix");
        }
    }
    private static boolean isSquareMatrix(int [][] arr){
        if(arr == null) 
            return false;
        for(int [] subArr : arr ){
            if(arr.length != subArr.length){
                return false;
            } 
        }
        return true;
    } 
    private static int deter(int [][] arr,int startIndex){
        if(startIndex == arr.length -1 ){
            return arr[startIndex][startIndex]; // 1x1 matrix's determinant
        }
        int determinant = 0;
        for(int i=startIndex;i<arr.length;i++){
            determinant += (arr[startIndex][i]* cofactor(arr,startIndex,i));
        }
        return determinant;
    }
    private static int cofactor(int [][] arr,int row,int column){
        int degreeOfMinusOne = row+column;
        int negativeOrPositive =(int) Math.pow(-1.0,degreeOfMinusOne);
        int sizeOfArr = arr.length-row-1;
        int [][] temp = new int[sizeOfArr][sizeOfArr];
        int x=0,y=0;
        for(int i = row+1;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(j == column){
                    continue;
                }else{
                    temp[x][y] = arr[i][j];
                    y++;
                    if(y == temp.length){
                        x++;
                        y = 0;
                    }
                }

            }
        }
        int deterOfSub = deter(temp,0);
        return negativeOrPositive * deterOfSub;
    }
    //test
    public static void main(String[] args) {
        int [][] arr = {{1,2,2,13},{1,3,3,23},{4,1,2,-5},{23,-21,34,-12}};
        System.out.println(determinant.determinantFinder(arr));
    }
}
