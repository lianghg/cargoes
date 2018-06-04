package cargoes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CargoesApplicationTests {

	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() {

		ValueOperations<String, String> svalue = stringRedisTemplate.opsForValue();
		svalue.set("test", System.currentTimeMillis()+"-");
		
	}
	
	@Test
	public void contextLoads2() {


		ValueOperations<String, String> svalue = stringRedisTemplate.opsForValue();
		String text = svalue.get("test");
		System.out.println(text);
		
	}

}
