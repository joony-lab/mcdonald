
package newmcdonaldapp.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="orderBurger", url="http://orderBurger:8080")
public interface OrderService {

    @RequestMapping(method= RequestMethod.GET, path="/orders")
    public void orderBranchReg(@RequestBody Order order);

}