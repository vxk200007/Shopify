//package utdallas.edu.dbProject.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.google.gson.Gson;
//
//import utdallas.edu.dbProject.dbo.Category;
//
//@RestController
//@RequestMapping("/category")
//public class CategoryController {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	@ResponseBody
//	@RequestMapping("/get/all")
//	public String getCategory() {
//		String sql = "select * from category";
//
//		List<Category> categories = jdbcTemplate.query(
//								sql,
//								new BeanPropertyRowMapper<Category>(Category.class));
//
//		Gson gson = new Gson();
//		String categoriesJson = gson.toJson(categories);
//		System.out.println("/category/get/all output : " + categories);
//		return categoriesJson;
//	}
//
//}
