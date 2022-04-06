import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q_3568 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    String data = sc.nextLine();
    ArrayList<String> dataNames = new ArrayList<>(); // 변수명 저장

    String pattern = "\\,|\\;$"; // 콤마(,) | 문장 끝 세미콜론(;)
    data = data.replaceAll(pattern, "");

    String[] splitArray = data.split(" "); // 공백 기준으로 자르기
    String staticType = splitArray[0]; // 데이터 타입
    Pattern p = Pattern.compile("[A-Za-z]+"); // 소대문자(변수명) 

    for (int i = 1; i < splitArray.length; i++) {
      Matcher m = p.matcher(splitArray[i]);
      while (m.find()) {
        int start = m.start();
        int end = m.end();
        String tmp = splitArray[i].substring(start, end); // 변수명 자르기 
        splitArray[i] = m.replaceAll(""); 
        dataNames.add(tmp);
      }
    }
    
    // 추가적 변수형 뒤집기
    Pattern isharp = Pattern.compile("(\\*)+|(\\[\\])+|(\\&)+");

    for (int i = 1; i < splitArray.length; i++) {
      Matcher m2 = isharp.matcher(splitArray[i]);
      ArrayList<String> defaultType = new ArrayList<>();
      while (m2.find()) {
        defaultType.add(m2.group());
      }
      Collections.reverse(defaultType);
      System.out.println(staticType + String.join("", defaultType) + " " + dataNames.get(i - 1) + ";");
    }
  }
}
