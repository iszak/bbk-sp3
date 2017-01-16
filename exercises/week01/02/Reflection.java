import java.lang.Class;
import java.lang.reflect.*;

/**
 * Write a Java program that reads the name of a class from the command line and emits the
 * interface of the class in Java syntax (interface or class, modifiers, constructors, methods,
 * fields; no method bodies).
 *
 * TODO: Print package
 * TODO: Print annotations (class and methods)
 * TODO: Print generics
 * TODO: Print superclass
 * TODO: Print return types
 * TODO: Print parameters
 * TODO: Exclude synthetics (methods)
 */
class Reflection
{
    public static void main(String[] args)
    {
        try {
            Class klass = Class.forName(args[0]);

            printInterfaces(klass);
            System.out.println();

            printClassModifiers(klass);
            System.out.print("class ");
            System.out.print(klass.getName());
            System.out.println();

//            printConstructors(klass);
//            printMethods(klass);
//            printFields(klass);
        } catch (ClassNotFoundException exception) {
            System.out.println(exception.toString());
        }
    }

    private static void printFields(Class klass) {
        Field[] fields = klass.getFields();

        for (Integer index = 0; index < fields.length; index++) {
            Field field = fields[index];

            printModifiers(field.getModifiers());
            System.out.println(field.getName());
        }
    }

    private static void printMethods(Class klass) {
        Method[] methods = klass.getMethods();

        for (Integer index = 0; index < methods.length; index++) {
            Method method = methods[index];

            printModifiers(method.getModifiers());
            System.out.print(method.getReturnType().getName());
            System.out.print(method.getName());
        }
    }

    private static void printConstructors(Class klass) {
        Constructor[] constructors = klass.getConstructors();

        System.out.println("Constructors: ");
        for (Integer index = 0; index < constructors.length; index++) {
            Constructor constructor = constructors[index];

            printModifiers(constructor.getModifiers());
            printParameters(constructor);

            index++;
        }
    }

    private static void printReturnType(Method executable) {
        executable.getReturnType();
    }

    private static void printClassModifiers(Class klass) {
        System.out.println("Class modifiers: ");

        printModifiers(klass.getModifiers());
    }

    private static void printModifiers(int currentModifiers) {
        System.out.print(Modifier.toString(currentModifiers) + " ");
    }

    private static void printParameters(Executable executable) {
    }

    private static void printInterfaces(Class klass) {
        Class[] interfaces = klass.getInterfaces();

        System.out.println("Interfaces: ");
        for (Integer index = 0; index < interfaces.length; index++) {
            Class interfac = interfaces[index];

            printModifiers(interfac.getModifiers());

            System.out.println(interfac.getName());

            index++;
        }
    }
}
