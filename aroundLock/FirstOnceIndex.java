/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class FirstOnceIndex {
    //方法一
    public int FirstNotRepeatingChar1(String str) {
        //判断数组是否为空
        if("".equals(str.trim()))
            return -1;
        //因为A-z直间总共有58个元素，所以数组长度为58
        int[] count = new int[58];
        //记录每个元素出现次数
        for(int i = 0; i < str.length(); i++) {
            count[(int)str.charAt(i)-65] += 1;
        }
        //遍历字符串，第一次找到只出现一次的字符就是要找的字符
        for(int i = 0; i < str.length(); i++) {
            if(count[(int)str.charAt(i)-65] == 1) {
                return i;
            }
        }
        return -1;
    }

    //方法二
    public int FirstNotRepeatingChar2(String str) {
        if("".equals(str.trim()))
            return -1;
        char[] ch = str.toCharArray();
        int[] count = new int[58];
        int index = 1;
        for(int i = 0; i < ch.length; i++) {
            int j = ch[i] - 65;
            if(count[j] == 0) {
                count[j] = index++;
            }else{
                count[j] = -1;
            }
        }
        int min = Integer.MAX_VALUE;
        int index1 = -1;
        for(int i = 0; i < 58; i++) {
            if(count[i] != 0 && count[i] != -1 && min > count[i]) {
                min = count[i];
                index1 = i;
            }
        }
        if(index1 == -1)
            return -1;
        char cc = (char)(index1+65);
        return str.indexOf(cc);
    }

    public static void main(String[] args) {
        FirstOnceIndex f = new FirstOnceIndex();
        String str = "stttring";
        int n = f.FirstNotRepeatingChar1(str);
        System.out.println(n);
    }
}
