/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class RootSumⅡ {
    public int countWays(int[][] map, int x, int y) {
        // write code here
        if(x==0||y==0) return 1;
        int array[][] =new int[x][y];
        if(map[0][0]==0||map[x-1][y-1]==0)
            return 0;
        array[0][0]=1;//一旦array[i][0]中有某个障碍物，那其后面均应该是0，而不是1
        for(int i=1;i<x;i++){//这里第一行和第一列的值要和后面的二维遍历分开设定，不然在二维数组的遍历中会存在数组越界
            if(map[i][0]==1) {
                array[i][0] = array[i - 1][0];//也可以用break的方式
            } else {
                array[i][0]=0;
            }
        }
        for(int j=1;j<y;j++){
            if(map[0][j]==1) {
                array[0][j]=array[0][j-1];
            } else{
                array[0][j]=0;
            }
        }

        for(int i=1;i<x;i++){
            for(int j=1;j<y;j++){
                array[i][j] =((map[i-1][j]==0?0:array[i-1][j])+(map[i][j-1]==0?0:array[i][j-1]))%1000000007;
            }
        }
        return array[x-1][y-1];
    }


    public static void main(String[] args) {
        int[][] arr = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,0,1,1},{0,1,1,1},{1,1,1,1},{1,1,1,1}};
        RootSumⅡ rootSumⅡ = new RootSumⅡ();
        int n = rootSumⅡ.countWays(arr,11,4);
        System.out.println(n);
    }
}
