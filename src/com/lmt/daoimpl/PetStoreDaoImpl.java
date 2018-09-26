package com.lmt.daoimpl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lmt.dao.PetStoreDao;
import com.lmt.domain.PetStore;
import com.lmt.utils.DataSourceUtils;

public class PetStoreDaoImpl implements PetStoreDao {
	/**
	 * 查询宠物商店信息
	 */
		@Override
		public List<PetStore> getAllStore() throws Exception {
			QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
			String sql = "select ID,NAME from petstore";
			return qr.query(sql, new BeanListHandler<PetStore>(PetStore.class));
		}

}
