package com.lmt.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lmt.dao.PetDao;

import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;
import com.lmt.utils.DataSourceUtils;

public class PetDaoImpl implements PetDao {

/**
 * 查询所有宠物信息
 */
	@Override
	public List<Pet> getAllPet() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select ID,NAME from pet";
		return qr.query(sql, new BeanListHandler<Pet>(Pet.class));
	}
/**
 * 显示库存宠物
 */
@Override
public List<Pet> getPetsInStock(int storeId) throws Exception {
	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	String sql = "select * from pet where STORE_ID = ?";
	return qr.query(sql,new BeanListHandler<Pet>(Pet.class),storeId);
}
/**
 * 	PetOwner petOwner = new PetOwner();
	PetStore petStore = new PetStore();
 * 买宠物时，更新信息
 */
@Override
public void update(Pet pet) throws Exception {
	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	System.out.println(pet.getOwner_id()+"\t"+pet.getId());
	String sql = "update pet set OWNER_ID = ?,STORE_ID = null where ID = ?";
	//指定ownerid
	qr.update(sql,pet.getOwner_id(),pet.getId());
	String sql1 = "UPDATE petowner SET MONEY = MONEY - (SELECT LOVE FROM pet WHERE ID = ?) WHERE ID = ?";
	//减少宠物主人的元宝数
	qr.update(sql1,pet.getId(),pet.getOwner_id());
	String sql2 = "UPDATE petstore SET BALANCE = BALANCE + (SELECT LOVE FROM pet WHERE ID = ?) WHERE ID = ?;";
	//增加元宝数
	qr.update(sql2,pet.getId(),pet.getOwner_id());
}

}