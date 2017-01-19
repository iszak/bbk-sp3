import java.lang.Class;
import java.lang.reflect.*;

/**
 * Write a Java program that reads the name of a class from the command line and emits the
 * interface of the class in Java syntax (interface or class, modifiers, constructors, methods,
 * fields; no method bodies).
 *
 * TODO: Print annotations (class and methods)
 * TODO: Print generics
 * TODO: Print superclass
 * TODO: Exclude synthetics (methods)
 */
class Reflection
{
    public static void main(String[] args)
    {
        if (args.length == 0) {
            System.out.println("You must provide at least one class to look up");
            System.exit(1);
        }

        String className = args[0];

        try {
            Class klass = Class.forName(className);

            printPackage(klass);
            printInterfaces(klass);
            printClass(klass);
            printConstructors(klass);
            printMethods(klass);
            printFields(klass);
        } catch (ClassNotFoundException exception) {
            System.out.println("The requested class " + className + " is not found");
        }
    }

    private static void printPackage(Class klass) {
        System.out.println("Package:");
        System.out.println("package " + klass.getPackage().getName() + ";");
        System.out.println();
    }

    private static void printClass(Class klass) {
        System.out.println("Class:");
        printModifiers(klass.getModifiers());
        System.out.print("class ");
        System.out.println(klass.getSimpleName());
        System.out.println();
    }

    private static void printFields(Class klass) {
        Field[] fields = klass.getFields();

        if (fields.length > 0) {
            System.out.println("Fields: ");
        }

        for (Integer index = 0; index < fields.length; index++) {
            Field field = fields[index];

            printModifiers(field.getModifiers());
            System.out.println(field.getName());
        }

        System.out.println();
    }

    private static void printMethods(Class klass) {
        Method[] methods = klass.getMethods();

        if (methods.length > 0) {
            System.out.println("Methods:");
        }

        for (Integer index = 0; index < methods.length; index++) {
            Method method = methods[index];

            printModifiers(method.getModifiers());
            System.out.print(method.getReturnType().getName() + " ");
            System.out.print(method.getName());
            System.out.print("(");
            printParameters(method);
            System.out.print(")");
            System.out.println();
        }

        System.out.println();
    }

    private static void printConstructors(Class klass) {
        Constructor[] constructors = klass.getConstructors();

        if (constructors.length > 0) {
            System.out.println("Constructors: ");
        }

        for (Integer index = 0; index < constructors.length; index++) {
            Constructor constructor = constructors[index];

            printModifiers(constructor.getModifiers());
            System.out.print(klass.getName() + " ");
            System.out.print(constructor.getName());
            System.out.print("(");
            printParameters(constructor);
            System.out.print(")");
            System.out.println();

            index++;
        }

        System.out.println();
    }

    private static void printInterfaces(Class klass) {
        Class[] interfaces = klass.getInterfaces();

        if (interfaces.length > 0) {
            System.out.println("Interfaces: ");
        }

        for (Integer index = 0; index < interfaces.length; index++) {
            Class interfac = interfaces[index];

            printModifiers(interfac.getModifiers());

            System.out.println(interfac.getName());

            index++;
        }

        System.out.println();
    }



    private static void printModifiers(int currentModifiers) {
        System.out.print(Modifier.toString(currentModifiers) + " ");
    }

    private static void printParameters(Executable executable) {
        Parameter[] parameters = executable.getParameters();

        for (Integer index = 0; index < parameters.length; index++) {
            Parameter parameter = parameters[index];
            System.out.print(parameter.getClass().getName() + " " + parameter.getName());
            if (index != parameters.length - 1) {
                System.out.print(", ");
            }
        }
    }
}
