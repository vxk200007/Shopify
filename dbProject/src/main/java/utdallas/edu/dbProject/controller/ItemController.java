package utdallas.edu.dbProject.controller;

import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import utdallas.edu.dbProject.dbo.InventoryItem;

@RestController
@RequestMapping("/items")
public class ItemController {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String COMMA = ",";
	private static final String NEW_LINE = "\n";

	@ResponseBody
	@RequestMapping("/get/all")
	public String getItems() {
		String sql = "select * from inventory_items";

		List<InventoryItem> items = jdbcTemplate.query(
								sql,
								new BeanPropertyRowMapper<InventoryItem>(InventoryItem.class));

		if(items.size() > 0) {
			Gson gson = new Gson();
			String itemsJson = gson.toJson(items);
			System.out.println("/items/get/all output : " + itemsJson);
			return itemsJson;
		}else {
			return "No items found";
		}
	}
	
	@ResponseBody
	@RequestMapping("/get/{id}")
	public String getItem(@PathVariable int id) {
		String sql = "select * from inventory_items where item_id=";
		sql = sql + id;

		List<InventoryItem> items = jdbcTemplate.query(
								sql,
								new BeanPropertyRowMapper<InventoryItem>(InventoryItem.class));
		if(items.size() > 0) {
			Gson gson = new Gson();
			String itemJson = gson.toJson(items.get(0));
			System.out.println("/items/get/all output : " + itemJson);
			return itemJson;
		}else {
			return "No items found with id : " + id;
		}

	}
	
	@ResponseBody
	@RequestMapping("/delete/{id}")
	public String deleteItem(@PathVariable int id) {
		String sql = "delete from inventory_items where item_id=";
		sql = sql + id;

		try {
			jdbcTemplate.execute(sql);
			return "Item with item_id:" + id + " deleted";
		}catch(Exception e) {
			return "Exception while deleting item_id:" + id + " " + e.getMessage();
		}
	}
	
	@ResponseBody
	@RequestMapping("/insert")
	public String insertItem(@RequestBody final InventoryItem inventoryItem) {
		String sql = "insert into inventory_items values(?,?,?)";

		try {
			jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setInt(1, Integer.parseInt(inventoryItem.getItem_id()));
					ps.setString(2, inventoryItem.getItem_name());
					ps.setString(3, inventoryItem.getItem_description());
					return ps.execute();
				}
			});
			return "Item inserted successfully";
		}catch(Exception e) {
			return "Exception while inserting the item : "+ e.getMessage();
		}
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String updateItem(@RequestBody final InventoryItem inventoryItem) {
		String sql = "update inventory_items set item_name=?, item_description=? where item_id=?";

		try {
			jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					ps.setString(1, inventoryItem.getItem_name());
					ps.setString(2, inventoryItem.getItem_description());
					ps.setInt(3, Integer.parseInt(inventoryItem.getItem_id()));
					return ps.execute();
				}
			});
			return "Item updated successfully";
		}catch(Exception e) {
			return "Exception while updating the item : " + e.getMessage();
		}
	}
	
	@ResponseBody
	@RequestMapping("downloadCSV")
	public ResponseEntity<InputStreamResource> getItemsCSV() {
		String sql = "select * from inventory_items";

		List<InventoryItem> items = jdbcTemplate.query(
								sql,
								new BeanPropertyRowMapper<InventoryItem>(InventoryItem.class));
		StringBuffer sb = new StringBuffer("Item_id,Item_Name,Item_Descrption");
		sb.append(NEW_LINE);
		for(InventoryItem item : items) {
			sb.append(item.getItem_id()).append(COMMA);
			sb.append(item.getItem_name()).append(COMMA);
			sb.append(item.getItem_description()).append(NEW_LINE);
		}

		if(items.size() > 0) {
			InputStreamResource file = new InputStreamResource(new ByteArrayInputStream(sb.toString().getBytes()));
			return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "Items.csv")
			        .contentType(MediaType.parseMediaType("application/csv"))
			        .body(file);
		}else {
			return null;
		}
	}

}
