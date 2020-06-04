import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {
    public static final String PHONE_NUMBER =  "^[0-9]{4}[-][0-9]{3}[-][0-9]{3}$" ;
    public static final String EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean checkPhoneNumber(String phone){
        pattern = Pattern.compile(PHONE_NUMBER);
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }
    public static boolean checkEmail(String mail){
        pattern = Pattern.compile(EMAIL);
        matcher = pattern.matcher(mail);
        return matcher.matches();
    }
}
