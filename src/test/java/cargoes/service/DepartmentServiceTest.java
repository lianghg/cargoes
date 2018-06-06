package cargoes.service;

import static org.junit.Assert.*;

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

import cargoes.model.po.Department;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;

	public static Department department;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Department parent = new Department();
		parent.setId("2ab2d31a689e11e8b7ed107b44f33502");
		department = new Department();
		department.setName("开发N组");
		department.setCode("100203");
		department.setCreateTime(new Date());
		department.setDescription("description!");
		department.setOrder(999);
		department.setParent(parent);

	}

	@Test
	public void test001Insert() {
		int i = departmentService.insert(department);
		assertEquals(1, i);
	}

	@Test
	public void test002InsertSelective() {
		int i = departmentService.insert(department);
		assertEquals(1, i);
	}

	@Test
	public void test003UpdateByPrimaryKeySelective() {
		int i = departmentService.updateByPrimaryKeySelective(department);
		assertEquals(1, i);
	}

	@Test
	public void test004UpdateByPrimaryKey() {
		int i = departmentService.updateByPrimaryKey(department);
		assertEquals(1, i);
	}

	@Test
	public void test007SelectByPrimaryKey() {
		Department d = departmentService.selectByPrimaryKey("215969a8689e11e8b7ed107b44f33502");
		assertNotNull(d);
	}

	@Test
	public void test008SelectByPrimaryKeys() {
		List<String> ids = new ArrayList<String>();
		ids.add("215969a8689e11e8b7ed107b44f33502");
		ids.add("2ab2d31a689e11e8b7ed107b44f33502");
		List<Department> departments = departmentService.selectByPrimaryKeys(ids);
		assertEquals(2, departments.size());
		
	}

	@Test
	public void test005DeleteByPrimaryKey() {
		int i = departmentService.deleteByPrimaryKey(department.getId());
		assertEquals(1, i);
	}

	@Test
	public void test006DeleteByPrimaryKeys() {
		List<String> ids = new ArrayList<String>();

		ids.add("1");
		ids.add("2");
		int i = departmentService.deleteByPrimaryKeys(ids);
		
		assertEquals(0, i);
		
	}

}
