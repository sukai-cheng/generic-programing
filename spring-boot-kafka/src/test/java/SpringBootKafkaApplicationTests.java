import com.kafka.KafkaSpringBootApplication;
import com.kafka.provider.KafkaProvider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@ComponentScan(basePackages = "com.kafka")
@SpringBootTest(classes = KafkaSpringBootApplication.class)
public class SpringBootKafkaApplicationTests {

    @Resource
    private KafkaProvider kafkaProvider;

    @Test
    public void sendMessage() throws InterruptedException{
        for(int i = 0; i < 1000; i++){
            long orderId = i + 1;
            String orderNum = UUID.randomUUID().toString();
            kafkaProvider.sendMessage(orderId,orderNum, LocalDateTime.now());
        }

        TimeUnit.MINUTES.sleep(1);
    }

}
