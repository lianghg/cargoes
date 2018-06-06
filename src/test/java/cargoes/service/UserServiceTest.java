package cargoes.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;

import cargoes.model.po.Department;
import cargoes.model.po.Role;
import cargoes.model.po.SysUser;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	public static SysUser user;
	
	public static Department department;
	
	public static List<Role> roles;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		roles = new ArrayList<Role>();
		
		Role r1 = new Role();
		Role r2 = new Role();
		r1.setId("8a76732dabcb4d428ff16a6b740775a4");
		r2.setId("9a76732dabcb4d428ff16a6b740775a4");
		roles.add(r1);
		roles.add(r2);
		
		department = new Department();
		department.setId("6ab2d31a689e11e8b7ed107b44f33502");
		
		user = new SysUser();
		user.setCreateTime(new Date());
		user.setBirthday(new Date());
		user.setUsername("userService");
		user.setName("user");
		user.setEmail("ttest6@cargoes.com");
		user.setGender(2);
		user.setPassword("123456");
		user.setSalt("$@lt");
		user.setPhone("13713034567");
		user.setExpired(0);
		user.setLocked(0);
		user.setCredentialsExpired(0);
		user.setStatus(0);
		user.setDepartment(department);
		user.setRoles(roles);
	}
	
	@Test
	public void test001Insert() {
		int i = userService.insert(user);
		assertEquals(1, i);
		
	}
	
	@Test
	public void test002UpdateByPrimaryKey() {
		user.setPassword("112233445566");
		user.setModifyTime(new Date());
		int i = userService.updateByPrimaryKey(user);
		assertEquals(1, i);
	}
	
	@Test
	public void test003DeleteByPrimaryKey() {
		
		int i = userService.deleteByPrimaryKey(user.getId());
		assertEquals(1, i);
	}

	@Test
	public void test004InsertSelective() {
		int i = userService.insert(user);
		assertEquals(1, i);
	}

	@Test
	public void test005UpdateByPrimaryKeySelective() {
		user.setGender(1);
		user.setModifyTime(new Date());
		int i = userService.updateByPrimaryKey(user);
		assertEquals(1, i);
	}

	@Test
	public void test006SelectByPrimaryKey() {
		SysUser u = userService.selectByPrimaryKey("1");
		assertNotNull(u);
		System.out.println(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
	}

	@Test
	public void test007SelectByPrimaryKeys() {
		
		List<String> ids = new ArrayList<String>(); 
		
		ids.add("1");
		ids.add("2");
		
		List<SysUser> users = userService.selectByPrimaryKeys(ids);
		assertNotNull(users);
		System.out.println(JSON.toJSONString(users));
	}
	
	@Test
	public void test008GetUsersByPage() {
		
		Page<SysUser> page = userService.getUsersByPage(1, 10);
		assertNotNull(page);
		System.out.println(JSON.toJSONString(page));
		
	}

	@Test
	public void test009ActivateUser() {
		user.setPassword("active");
		user.setModifyTime(new Date());
		user.setExpired(0);
		user.setLocked(0);
		user.setCredentialsExpired(0);
		user.setStatus(1);
		int i = userService.updateByPrimaryKey(user);
		assertEquals(1, i);
	}
	
	@Test
	public void test010DeleteByPrimaryKeys() {
		
		List<String> ids = new ArrayList<String>();
		
		ids.add("a59766ac695c11e8b7ed107b44f33502");
		ids.add("907aaf33695c11e8b7ed107b44f33502");
		int i = userService.deleteByPrimaryKeys(null);
		assertEquals(0, i);
	}

}
