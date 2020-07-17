/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
// 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
// 有一天他向Fish借来翻看，但却读不懂它的意思。
// 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
// 正确的句子应该是“I am a student.”。
// Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
public class ReverseWord {
    public String ReverseSentence(String str) {
        if(str.trim().equals("")){
            return str;
        }
        String[] ch = str.split(" ");
        int left = 0;
        int right = ch.length-1;
        while(left < right) {
            String tmp = ch[left];
            ch[left] = ch[right];
            ch[right] = tmp;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(; i < ch.length-1; i++) {
            sb.append(ch[i] + " ");
        }
        sb.append(ch[i]);
        return sb.toString();
    }

    //方法二
    public String ReverseSentence2(String str) {
        if(str.trim().equals("")){//字符串为空
            return str;
        }
        String[] ch = str.split(" ");//以空格分割字符串。
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(i = ch.length-1; i > 0; i--) {
            sb.append(ch[i] + " ");
        }
        sb.append(ch[i]);
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWord r = new ReverseWord();
        String str = r.ReverseSentence(" ");
        System.out.println(str);
    }
}
