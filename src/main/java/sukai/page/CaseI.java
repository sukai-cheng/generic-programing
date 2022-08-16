//package sukai.page;
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import lombok.Data;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
///**
// * @description 分页查询
// *
// * @author chengsukai
// *
// * @create 2022-04-20 20:37
// **/
//public class CaseI {
//
//    public static void main(String[] args) {
//        final IPage<Student> page = studentPage(1, 5, null);
//        System.out.println(page.getRecords()); // 每个页面的数据量
//        System.out.println(page.getTotal()); // 总数据量
//        System.out.println(page.getPages()); // 分页数量
//    }
//
//    /**
//     * @review studentList 转 map 后，再获取 studentIds，可以直接用 map.keySet() 不用再用一次流收集转 list
//     * 使用 lambda  的时候不要嵌套，复杂实现应该把 lambda 的内容抽取成一个方法
//     * 逻辑优化，可读性查
//     * @return com.baomidou.mybatisplus.core.metadata.IPage<sukai.page.CaseI.Student>
//     * @create 2022/4/20 10:01 PM
//     * @author chengsukai
//     */
//    private static IPage<Student> studentPage(Integer current, Integer pageSize, Student dto) {
//
//        final List<Student> studentList = findStudentList(dto);
//        Page<Student> page = new Page<>(current, pageSize, studentList.size());
//        if (studentList.isEmpty()) return page;
//        Map<String, Student> studentMap = studentList.stream().collect(Collectors.toMap(Student::getId, Function.identity()));
//        List<String> ids = studentList.stream().map(Student::getId).collect(Collectors.toList());
//        findCourseListByStuIds(ids).forEach(course -> {
//            studentMap.computeIfPresent(course.getStudentId(), (k, v) -> {
//                List<Course> courses = Optional.ofNullable(v.getCourses()).orElseGet(() -> {
//                    final List<Course> list = new ArrayList<>();
//                    v.setCourses(list);
//                    return list;
//                });
//                courses.add(course);
//                return v;
//            });
//        });
//        page.setRecords(studentList.stream().skip((long) (Math.max(1, current) - 1) * pageSize).limit(pageSize).collect(Collectors.toList()));
//        return page;
//    }
//
//    private static List<Student> findStudentList(Student dto) {
//        return new ArrayList<>() {
//            {
//                add(new Student("1", "1"));
//                add(new Student("2", "2"));
//                add(new Student("3", "3"));
//            }
//        };
//    }
//
//    private static List<Course> findCourseListByStuIds(List<String> ids) {
//        return new ArrayList<>() {
//            {
//                add(new Course("1", "course1"));
//                add(new Course("1", "course2"));
//                add(new Course("2", "course222"));
//                add(new Course("4", "course44"));
//            }
//        };
//
//    }
//
//    @Data
//    static class Student {
//        String id;
//        String name;
//        List<Course> courses;
//
//        public Student(String id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//    }
//
//    @Data
//    static class Course {
//        String studentId;
//        String name;
//
//        public Course(String studentId, String name) {
//            this.studentId = studentId;
//            this.name = name;
//        }
//    }
//
//
//}
