package sukai.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chengsukai
 * @since 2022-10-10 22:43
 */
public class GroupTest {

    private void balabala(){
    }

    public static void main(String[] args) {
        User user1 = User.builder()
                .name("blues")
                .sex("man")
                .age(20)
                .build();
        User user2 = User.builder()
                .name("blues")
                .sex("woman")
                .age(19)
                .build();
        User user3 = User.builder()
                .name("blues")
                .sex("woman")
                .age(18)
                .build();
        User user4 = User.builder()
                .name("blues")
                .sex("woman")
                .age(17)
                .build();

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        Map<String, List<String>> collect = users.parallelStream()
                .collect(Collectors.groupingBy(User::getSex, Collectors.mapping(User::getName, Collectors.toList())));


        for (Map.Entry<String, List<String>> r :
                collect.entrySet()) {
            System.out.println("key:" + r.getKey() + " value:" + r.getValue());
        }
    }


}
