import org.datagen.generator.PassportGenerator;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PassportGeneratorTests {
    PassportGenerator passportGenerator = new PassportGenerator();
    String years19 = "27-04-2004";
    String years20 = "27-04-2002";
    String years21 = "27-04-2003";
    String years40 = "27-04-1982";
    String years45 = "27-04-1987";
    String years46 = "27-04-1977";

    @Test
    void testIsUpper14() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = PassportGenerator.class.getDeclaredMethod("isUpper14", String.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(passportGenerator, "27-04-1996"));
    }

    @Test
    void testIsUpper20() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PassportGenerator.class.getDeclaredMethod("isUpper20", String.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(passportGenerator, "27-04-1996"));
    }
    @Test
    void testIsUpper45Negative() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PassportGenerator.class.getDeclaredMethod("isUpper45", String.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(passportGenerator, "27-04-1996"));
    }

    @Test
    void testIsUpper14andYounger20Negative() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PassportGenerator.class.getDeclaredMethod("isUpper14andYounger20", String.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(passportGenerator, "27-04-1996"));
    }
    @Test
    void testIsUpper14Negative() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PassportGenerator.class.getDeclaredMethod("isUpper14andYounger20", String.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(passportGenerator, "27-04-2010"));
    }
    @Test
    void testIsUpper20Negative() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PassportGenerator.class.getDeclaredMethod("isUpper20", String.class);
        method.setAccessible(true);
        assertFalse((Boolean) method.invoke(passportGenerator, years19));
    }
    @Test
    void testIsUpper45() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException  {
        Method method = PassportGenerator.class.getDeclaredMethod("isUpper45", String.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(passportGenerator, years46));
    }
    @Test
    void testIsUpper14andYounger() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException  {
        Method method = PassportGenerator.class.getDeclaredMethod("isUpper14andYounger20", String.class);
        method.setAccessible(true);
        assertTrue((Boolean) method.invoke(passportGenerator, "27-04-2006"));
    }
   @Test
   void testGenerateBirthDate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
       Method method = PassportGenerator.class.getDeclaredMethod("generateBirthDate");
       method.setAccessible(true);
       String dateBirth = (String) method.invoke(passportGenerator);
       System.out.println(dateBirth);
       assertInstanceOf(String.class,method.invoke(passportGenerator));
   }

}
