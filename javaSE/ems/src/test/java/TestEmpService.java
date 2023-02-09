import com.xzy.web.ems.entity.Emp;
import com.xzy.web.ems.service.IEmpService;
import com.xzy.web.ems.service.impl.EmpServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestEmpService {
    private IEmpService empService = new EmpServiceImpl();
    @Test
    public void testSelectList(){
        Emp emp = new Emp();
        emp.setEmpName("marry");
        emp.setSex(2);
        System.out.println(emp);
        String empCode = emp.getEmpCode();
        System.out.println(empCode);
        List<Emp> empList = empService.selectList(emp);
        System.out.println(empList);
    }
}
