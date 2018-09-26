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
//ID         int(11)  �˵�                                                                   
//DEAL_TYPE  int(11)  �������ͣ�1���̵�������������2���������������̵�  
//PET_ID     int(11)  ����id                                                                 
//SELLER_ID  int(11)  ���id                                                                 
//BUYER_ID   int(11)  ����id                                                                 
//PRICE      int(11)  ���׼۸�                                                             
//DEAL_TIME  date     ����ʱ�� 
public class AccountDaoImpl implements AccountDao {
/**
 * ����̨����Ϣ
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
