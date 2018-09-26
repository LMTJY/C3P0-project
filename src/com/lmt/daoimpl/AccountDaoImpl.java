package com.lmt.daoimpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.lmt.dao.AccountDao;
import com.lmt.domain.Account;
import com.lmt.domain.Pet;
import com.lmt.domain.PetOwner;
import com.lmt.domain.PetStore;
import com.lmt.utils.DataSourceUtils;
//Field      Type     Comment                                                                  
//---------  -------  -------------------------------------------------------------------------
//ID         int(11)  账单                                                                   
//DEAL_TYPE  int(11)  交易类型，1：商店卖给宠物主人2：宠物主人卖给商店  
//PET_ID     int(11)  宠物id                                                                 
//SELLER_ID  int(11)  买家id                                                                 
//BUYER_ID   int(11)  卖家id                                                                 
//PRICE      int(11)  交易价格                                                             
//DEAL_TIME  date     交易时间 
public class AccountDaoImpl implements AccountDao {
/**
 * 更新台账信息
 */
	@Override
	public int update(Account account,Pet pet) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		Date date = new Date();
		System.out.println(account.getDeal_type()+"\t"+pet.getId()+"\t"+pet.getOwner_id()+"\t"+pet.getStore_id()+"\t"+pet.getLove()+"\t"+sdf.format(date));
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into account(DEAL_TYPE,PET_ID,SELLER_ID,BUYER_ID,PRICE,DEAL_TIME)"
				+ "values(?,?,?,?,?,?)";
		return qr.update(sql,account.getDeal_type(),pet.getId(),pet.getOwner_id(),pet.getStore_id(),pet.getLove(),sdf.format(date));
	}

}
