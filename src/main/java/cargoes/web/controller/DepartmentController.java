package cargoes.web.controller;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cargoes.model.dto.DataEntity;
import cargoes.model.dto.DepartmentInDto;
import cargoes.model.dto.DepartmentOutDto;
import cargoes.model.po.Department;
import cargoes.model.po.SysUser;
import cargoes.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * 根据ID查询部门
	 * @param id
	 * @return
	 */
	@GetMapping(value="/{id}")
	public ResponseEntity<DataEntity<DepartmentOutDto>> getDepartment(@PathVariable(name="id") String id){
		
		Department department = departmentService.selectByPrimaryKey(id);
		
		DepartmentOutDto departmentOutDto = new DepartmentOutDto();
		BeanUtils.copyProperties(department, departmentOutDto);
		
		DataEntity<DepartmentOutDto> dataEntity = new DataEntity<DepartmentOutDto>();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("查询成功");
		dataEntity.setResult(departmentOutDto);
		
		return new ResponseEntity<DataEntity<DepartmentOutDto>>(dataEntity,HttpStatus.OK);
		
	}
	
	/**
	 * 根据ID删除部门
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value="/{id}")
	public ResponseEntity<DataEntity> deleteDepartment(@PathVariable(name="id") String id){
		
		departmentService.deleteByPrimaryKey(id);
		
		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("删除成功");
		
		return new ResponseEntity<DataEntity>(dataEntity,HttpStatus.OK);
		
	}
	
	/**
	 * 根据一组ID删除多个角色
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@DeleteMapping(value="", consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DataEntity> deleteDepartments(@RequestParam(name="ids[]") List<String> ids){
		
		departmentService.deleteByPrimaryKeys(ids);
		
		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("删除成功");
		
		return new ResponseEntity<DataEntity>(dataEntity,HttpStatus.OK);
	}
	
	/**
	 * 根据ID更新部门
	 * @param id
	 * @param tempUser
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PutMapping(value="/{id}")
	public ResponseEntity<DataEntity> updateDepartment(@PathVariable(name="id") String id, DepartmentInDto departmentDto){
		
		Department parent = departmentService.selectByPrimaryKey(departmentDto.getParentId());
		List<Department> children = departmentService.selectByPrimaryKeys(departmentDto.getChildrenIds());
		
		Department dept = modelMapper.map(departmentDto, Department.class);
		
		Department department = departmentService.selectByPrimaryKey(id);
		
		department.setModifyTime(new Date());
		department.setCode(dept.getCode());
		department.setDescription(dept.getDescription());
		department.setName(dept.getName());
		department.setOrder(dept.getOrder());
		department.setParent(parent);
		department.setChildren(children);
		
		departmentService.updateByPrimaryKey(department);
		//
		DataEntity dataEntity = new DataEntity();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setMessage("更新成功");
		
		return new ResponseEntity<DataEntity>(dataEntity,HttpStatus.OK);
		
	}
	
	/**
	 * 新增部门
	 * @param tempUser
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@PostMapping(value="/")
	public ResponseEntity<DataEntity> addDepartment(DepartmentInDto departmentDto){
		
		Department parent = departmentService.selectByPrimaryKey(departmentDto.getParentId());
		List<Department> children = departmentService.selectByPrimaryKeys(departmentDto.getChildrenIds());
		
		Department department = modelMapper.map(departmentDto, Department.class);
		department.setCreateTime(new Date());
		department.setParent(parent);
		department.setChildren(children);
		
		departmentService.insertSelective(department);
		
		DataEntity dataEntity = new DataEntity<SysUser>();
		dataEntity.setFlag(true);
		dataEntity.setStatus(HttpStatus.CREATED.value());
		dataEntity.setMessage("添加成功");
		
		return new ResponseEntity<DataEntity>(dataEntity,HttpStatus.CREATED);
		
	}
	
	/**
	 * 分页查询部门列表
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@GetMapping(value = "",headers="api-version=1.1")
	public ResponseEntity<DataEntity<PageInfo<DepartmentOutDto>>> listDepartment(
			@RequestParam(name = "page_no", defaultValue = "1") int pageNo,
			@RequestParam(name = "page_size", defaultValue = "10") int pageSize) {

		Page<Department> sourcePage = departmentService.getDepartmentsByPage(pageNo, pageSize);
		
		Type type = new TypeToken<PageInfo<DepartmentOutDto>>() {}.getType();
		PageInfo<DepartmentOutDto> pageInfo = modelMapper.map(sourcePage, type);

		//
		DataEntity<PageInfo<DepartmentOutDto>> dataEntity = new DataEntity<PageInfo<DepartmentOutDto>>();
		dataEntity.setFlag(true);
		dataEntity.setMessage("查询成功");
		dataEntity.setStatus(HttpStatus.OK.value());
		dataEntity.setResult(pageInfo);

		return new ResponseEntity<DataEntity<PageInfo<DepartmentOutDto>>>(dataEntity, HttpStatus.OK);

	}
}
