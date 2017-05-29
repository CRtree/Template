import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * Created by zuoxiao
 * on 2017/5/10.
 */
public class ReflectTest {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("please enter classname:");
        String name = in.next();
        try {
            Class cl = Class.forName(name);
            String modifies = Modifier.toString(cl.getModifiers());
            if (modifies.length() > 0){
                System.out.print(modifies + " ");
            }
            System.out.print("class " + name);
            getSuperClass(cl);
            getConstructors(cl);
            getMethod(cl);
            getField(cl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private static void getSuperClass(Class cl){
        Class superClass = cl.getSuperclass();
        if (superClass != null && superClass != Object.class){
            System.out.print(" extends"+superClass.getName());
        }
    }

    private static void getConstructors(Class cl){
        Constructor[] constructors = cl.getDeclaredConstructors();
        for (Constructor con:constructors) {
            String name = con.getName();
            System.out.println();
            String modifies = Modifier.toString(con.getModifiers());
            if (modifies.length() > 0){
                System.out.print(modifies + " ");
            }
            System.out.print(name + "(");

            Class[] params = con.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                if (i > 0){
                    System.out.print(",");
                }
                System.out.print(params[i].getName());
            }
            System.out.println(")");
        }
    }

    private static void getMethod(Class cl){
        Method[] methods = cl.getDeclaredMethods();
        for (Method m :methods) {
            String name = m.getName();
            Class reType = m.getReturnType();
            String modifies = Modifier.toString(m.getModifiers());
            if (modifies.length() > 0){
                System.out.print(modifies + " ");
            }
            System.out.print(reType +" ");
            System.out.print(name + "(");
            Class[] params = m.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                if (i > 0){
                    System.out.print(",");
                }
                System.out.print(params[i].getName());
            }
            System.out.println(")");
        }

    }
    private static void getField(Class cl){
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            String name = f.getName();
            Class type = f.getType();
            String modifies = Modifier.toString(f.getModifiers());
            if (modifies.length() > 0){
                System.out.print(modifies + " ");
            }
            System.out.print(type.getName() + " ");
            System.out.println(name);
        }
    }

}
