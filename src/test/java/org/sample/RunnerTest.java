package org.sample;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Testcontainers;



@SpringBootTest
@Testcontainers
public class RunnerTest {


    public static GenericContainer container = new GenericContainer<>("docker.io/library/sl-wb:1.0-SNAPSHOT")
            .withExposedPorts(8000);



    @Test
    public void test() {

        container.start();
        // test container

        container.stop();

    }
}
