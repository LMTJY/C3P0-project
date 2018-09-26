package com.lmt.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lmt.dao.PetOwnerDao;
import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;
import com.lmt.utils.DataSourceUtils;

public class PetOwnerDaoImpl implements PetOwnerDao {
/**
 * 查询宠物主人信息
 */
	@Override
	public List<PetOwner> getAllOwner() throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select ID,NAME from petowner";
		return qr.query(sql, new BeanListHandler<PetOwner>(PetOwner.class));
	}

	/**
	 * 查询登录信息
	 * 
	 */
@Override
public PetOwner selectOwner(String username, String password) throws Exception {
	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	String sql = "select * from petowner where NAME = ? and PASSWORD = ?";
	return qr.query(sql, new BeanHandler<PetOwner>(PetOwner.class),username,password);
}
/**
 * 展示宠物列表
 */
	@Override
	public List<Pet> getListMyPet(PetOwner pet) throws Exception {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from pet where OWNER_ID = ?";
		return qr.query(sql, new BeanListHandler<Pet>(Pet.class),pet.getId());
	}
/**
 * 卖宠物 时更新的信息
 */
@Override
public void upadae(Pet pet) throws Exception {
	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	String sql = "update pet set OWNER_ID = null,STORE_ID = ? where ID = ?";
	//指定ownerid
	qr.update(sql,pet.getOwner_id(),pet.getId());
	String sql1 = "UPDATE petowner SET MONEY = MONEY + (SELECT LOVE FROM pet WHERE ID = ?) WHERE ID = ?";
	//增加宠物主人的元宝数
	qr.update(sql1,pet.getId(),pet.getOwner_id());
	String sql2 = "UPDATE petstore SET BALANCE = BALANCE - (SELECT LOVE FROM pet WHERE ID = ?) WHERE ID = ?;";
	//减少宠物店的元宝数
	qr.update(sql2,pet.getId(),pet.getStore_id());
}

}
