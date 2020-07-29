/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */

//一个整型数组里除了两个数字之外，其他的数字都出现了两次。
// 请写程序找出这两个只出现一次的数字。

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class TwoOnlyOne {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || num1 == null || num2 == null || array.length == 0) {
            return;
        }
        //1、整体异或
        int result = array[0];
        for(int i = 1; i < array.length; i++) {
            result ^= array[i];
        }
        if(result == 0)
            return;
        //2、找比特位，从低到高
        int length = Integer.SIZE; //获取int有多少比特位
        int flag = 1;
        while(length >= 0){
            length -= 1;
            if(((flag<<length) & result) != 0){
                flag <<= length;
                break;
            }
        }
        //第三步，分组
        for(int i = 0; i < array.length; i++){
            if((array[i] & flag) == 0){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }
}