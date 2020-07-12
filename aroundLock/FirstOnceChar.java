/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */

public class FirstOnceChar {
    //Insert one char from stringstream
     int[] count = new int[256];
     int index = 1;

    public  void Insert(char ch)
    {
        if(count[ch] == 0) {
            count[ch] = index++;
        }else {
            count[ch] = -1;
        }
    }
    //return the first appearence once char in current stringstream
    public  char FirstAppearingOnce()
    {
        char ch = '#';
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if(count[i] != 0 && count[i] != -1 && min > count[i]){
                min = count[i];
                ch = (char)i;
            }
        }
        return ch;
    }

}