package ca.bc.gov.metabaseviewer.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
    @Test
    public void dashJson() {
        Assert.assertEquals("{\"resource\": {\"dashboard\": 2}, \"params\": {}}", UserService.dashJson(2));
    }
}
