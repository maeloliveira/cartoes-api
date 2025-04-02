package cartoes_api.com;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ImportAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
class CartoesApplicationTests {

	@Test
	void contextLoads() {
	}

}
