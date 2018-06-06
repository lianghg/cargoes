package cargoes;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cargoes.model.po.Department;
import cargoes.model.po.OperationLog;
import cargoes.model.po.Role;
import cargoes.model.po.SysUser;
import cargoes.service.DepartmentService;
import cargoes.service.OperationLogService;
import cargoes.service.RoleService;
import cargoes.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CargoesApplicationTests {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private OperationLogService operationLogService;
	
	private SysUser user;
	private Role role;
	private Department department;
	private OperationLog operationLog;
	
	
	@BeforeClass
	public void ready(){
		user = new SysUser();
		role = new Role();
		department = new Department();
		operationLog = new OperationLog();
	}

	@Test
	public void contextLoads() {
		
		userService.insert(user);
		userService.updateByPrimaryKey(user);
		userService.selectByPrimaryKey(user.getId());
		userService.deleteByPrimaryKey(user.getId());
		
		roleService.insert(role);
		roleService.updateByPrimaryKey(role);
		roleService.selectByPrimaryKey(role.getId());
		roleService.deleteByPrimaryKey(role.getId());
		
		departmentService.insert(department);
		departmentService.updateByPrimaryKey(department);
		departmentService.selectByPrimaryKey(department.getId());
		departmentService.deleteByPrimaryKey(department.getId());
		
		operationLogService.insert(operationLog);
		operationLogService.updateByPrimaryKey(operationLog);
		operationLogService.selectByPrimaryKey(operationLog.getId());
		userService.deleteByPrimaryKey(operationLog.getId());
		
	}

}
