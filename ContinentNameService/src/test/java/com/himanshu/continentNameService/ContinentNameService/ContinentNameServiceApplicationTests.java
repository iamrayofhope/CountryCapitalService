package com.himanshu.continentNameService.ContinentNameService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.himanshu.continentNameService.ContinentNameService.Service.ContinentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContinentNameServiceApplicationTests {
	
	@Autowired
	ContinentService continentService;
	

	@Test
	public void contextLoads() {
		
	}
	
}
