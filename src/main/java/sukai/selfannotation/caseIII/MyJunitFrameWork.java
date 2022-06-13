package sukai.selfannotation.caseIII;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class MyJunitFrameWork {
    public static void main(String[] args) throws Exception {
        Class<EmployeeDAOTest> clazz = EmployeeDAOTest.class;
        Object obj = clazz.getDeclaredConstructor().newInstance();

        Method[] methods = clazz.getMethods();

        List<Method> myBeforeList = new ArrayList<>();
        List<Method> myAfterList = new ArrayList<>();
        List<Method> myTestList = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(MyBefore.class)) {
                myBeforeList.add(method);
            } else if (method.isAnnotationPresent(MyTest.class)) {
                myTestList.add(method);
            } else if (method.isAnnotationPresent(MyAfter.class)) {
                myAfterList.add(method);
            }
        }

        for (Method testMethod : myTestList) {
            for (Method beforeMethod : myBeforeList) {
                beforeMethod.invoke(obj);
            }
            testMethod.invoke(obj);
            for (Method afterMethod : myAfterList) {
                afterMethod.invoke(obj);
            }
        }
    }
}
