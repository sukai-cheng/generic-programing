package sukai.functional.caseIII;

import com.github.javafaker.Faker;
import sukai.functional.utils.FakeUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description Stream Api 使用案例
 *
 * @author chengsukai
 *
 * @create 2022-04-18 17:26
 **/
public class StreamTestApiITCase {

    /**
     * Init data for test
     * @return java.util.ArrayList<sukai.functional.caseIII.Employee>
     * @create 2022/4/18 6:13 PM
     * @author chengsukai
     */
    public ArrayList<Employee> initData() {

        Faker faker = FakeUtil.createChineseFaker();

        ArrayList<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setId((long) i);
            employee.setCareer(faker.job().title());
            employee.setName(faker.name().name());

            employeeList.add(employee);
        }

        return employeeList;
    }

    /**
     * Test Main method
     * @return void
     * @create 2022/4/18 6:13 PM
     * @author chengsukai
     */
    public void test() {
        iteratorObject(initData());
        System.out.println("============after===========");
        iteratorObjectParallel(initData());
        System.out.println("============after===========");
        toArrayStream(new int[]{1, 23, 5, 6, 7});
    }

    /**
     * Transfer ArrayList to order stream
     * @return void
     * @create 2022/4/18 6:13 PM
     * @author chengsukai
     */
    private void iteratorObject(ArrayList<Employee> employeeList) {
        employeeList.forEach(System.out::println);
    }

    /**
     * Transfer ArrayList to parallel stream
     * @return void
     * @create 2022/4/18 6:12 PM
     * @author chengsukai
     */
    private void iteratorObjectParallel(ArrayList<Employee> employeeList) {
        employeeList.parallelStream().forEach(System.out::println);
    }

    /**
     * Transfer array to stream
     * @return void
     * @create 2022/4/18 6:12 PM
     * @author chengsukai
     */
    private void toArrayStream(int[] arr) {
        Arrays.stream(arr).forEach(System.out::print);
    }


}

