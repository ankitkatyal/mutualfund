package com.practice.rest.webservices.restfulwebservices;



import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.practice.rest.controller.RequestController;
import com.practice.rest.dao.DaoImpl;
import com.practice.rest.domains.MutualFund;
import com.practice.rest.domains.MutualFundNotFound;
import com.practice.rest.domains.ShareDetails;
 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
@WebMvcTest(value = RequestController.class, secure = false)
public class MutualFundControllerTest {
 
	@Autowired
    private static MockMvc mockMvc;
 
    @Mock
    private static DaoImpl daoServiceMock;
 
    @Autowired
    private WebApplicationContext ctx;
    
    private  static Map<String,MutualFund>  mutualsFundsMap = new HashMap<String, MutualFund>();

    private static MutualFund mf = new MutualFund();
    //Add WebApplicationContext field here.
 
    //The setUp() method is omitted.
    
    static {
		ShareDetails s1 = new ShareDetails();
		s1.setShareName("Tcs");
		s1.setQuantity("10");
		s1.setPrice("1000");


		ShareDetails s2 = new ShareDetails();
		s2.setShareName("Infosys");
		s2.setQuantity("20");
		s2.setPrice("2000");

		List<ShareDetails> shareList = new ArrayList<ShareDetails>();
		shareList.add(s1);
		shareList.add(s2);
		mf.setName("BlueChip");
		mf.setTotalShares(shareList);

		mutualsFundsMap.put("BlueChip",mf);

	}
 
    @Before
    public void init() {
    	daoServiceMock = org.mockito.Mockito.mock(DaoImpl.class);
    	mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    	
    	
    	}
    @Test
    public void findByName_TodoEntryNotFound_ShouldReturnHttpStatusCode404() throws Exception {
        when(daoServiceMock.getMutualFundDetails("XYZS")).thenThrow(new MutualFundNotFound(""));
 
        mockMvc.perform(get("/mutualfunds/{name}", "XYZS"))
                .andExpect(status().isNotFound());
 
        verifyNoMoreInteractions(daoServiceMock);
    }
    
    @Test
    public void findMutualFundShouldReturnFoundEntries() throws Exception {
        
    	Mockito.when(
    			daoServiceMock.getMutualFundDetails(Mockito.anyString())).thenReturn(mf);


		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"mutualfunds/BlueChip").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
        verifyNoMoreInteractions(daoServiceMock);
    }
}