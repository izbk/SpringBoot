package cn.mldn.microboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication	// 启动SpringBoot程序，而后自带子包扫描
@EnableTransactionManagement
public class StartConsumerMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(StartConsumerMain.class, args);
    }
}
