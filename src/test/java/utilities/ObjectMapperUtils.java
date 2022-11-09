package utilities;




import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ObjectMapperUtils {
    private  static ObjectMapper mapper;

    static {
        mapper=new ObjectMapper();
    }// *** Not : static{} oldugu zaman cons. bile once calisacagi icin her seferinde obje olusturmadan
    // class'da ilk once calisir ve daha clean bir kod olur




public static <T> T convertJsonToJava(String json,Class<T> cls){
        T javaResult=null;
    try {
        javaResult=mapper.readValue(json,cls);
    } catch (IOException e) {
        System.out.println("Json dosyasi donusturulemedi");
    }
    return javaResult;
}

}
//biz convertToJava cagırdıgımızda ılk olarak mapper objesinin olusması gerektıgı ıcın static blok kullandık.
// *** Not : Bu method json'i javaya cevirecek. Ayrica bu methodu exception firlatmamasi icin yaptik
// *** Not : <T> herhangi bir data tipi demek. T -> Type demek
