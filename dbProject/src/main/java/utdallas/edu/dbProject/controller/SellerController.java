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
//import utdallas.edu.dbProject.dbo.Seller;
//
//@RestController
//@RequestMapping("/seller")
//public class SellerController {
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	@ResponseBody
//	@RequestMapping("/get/all")
//	public String getSeller() {
//		String sql = "select * from seller";
//
//		List<Seller> sellers = jdbcTemplate.query(
//								sql,
//								new BeanPropertyRowMapper<Seller>(Seller.class));
//
//		Gson gson = new Gson();
//		String sellersJson = gson.toJson(sellers);
//		System.out.println("/seller/get/all output : " + sellersJson);
//		return sellersJson;
//	}
//
//}
