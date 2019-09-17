package com.himanshu.capitalNameService.CapitalNameService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.himanshu.capitalNameService.CapitalNameService.Service.CapitalService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CapitalNameServiceApplicationTests {

	@Autowired
	CapitalService capitalService;
	
	@MockBean
	RestTemplate restTemplate;
	
	
	@Test
	public void contextLoads() {
		
		
		
	}

}
