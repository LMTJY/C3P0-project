# C3P0-project
数据库连接池操作
####        导入文件

![](https://github.com/LMTJY/C3P0-project/blob/master/11.png)

#### 	数据库连接配置  c3p0-config.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<c3p0-config>
  <!-- 默认加载配置 -->
  <default-config>
     <property name="driverClass">com.mysql.jdbc.Driver</property> 
     <property name="jdbcUrl">jdbc:mysql://localhost:3306/petstore</property> 
     <property name="user">root</property> 
     <property name="password">root</property> 
     <property name="initialPoolSize">5</property> 
     <property name="maxPoolSize">10</property> 
  </default-config>
  <!-- 指定名称加载配置 -->
  <named-config name="C3P0TestName">
    <property name="driverClass">com.mysql.jdbc.Driver</property> 
     <property name="jdbcUrl">jdbc:mysql://localhost:3306/petstore</property> 
     <property name="user">root</property> 
     <property name="password">root</property> 
     <property name="initialPoolSize">5</property> 
     <property name="maxPoolSize">10</property> 
  </named-config>
  
</c3p0-config>
```

#### 	编写工具类 DataSourceUtils.java

```
public final class DataSourceUtils {
  private static ComboPooledDataSource ds = new ComboPooledDataSource();
  /**
   * 获取数据源
   * @return
   */
  public static DataSource getDataSource() {
	  return ds;
  }
  /**
   * 获取连接
   * @return 连接
   * @throws SQLException
   */
 public static Connection getConnection() throws SQLException {
	 return ds.getConnection();
 }
 /**
  * 释放链接
  * @param conn
  * @param st
  * @param rs
  */
 public static void closeResource(Connection conn,Statement st,ResultSet rs) {
	 closeResultSet(rs);
	 closeStatement(st);
	 closeConn(conn);
 }
   private static void closeConn(Connection conn){
	   if(conn != null) {
		   try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   conn =null;
	   }
}
private static void closeStatement(Statement st) {
	if(st != null) {
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		st = null;
	}
}
private static void closeResultSet(ResultSet rs) {
	if(rs != null) {
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	rs = null;
}
/**
 * 测试连接
 * @throws SQLException
 */
	@Test
   public void test() throws SQLException {
	   System.out.println(ds.getClass());
	   System.out.println(ds.getConnection().toString());
   }
}
```

#### 	查询操作

```
/**
 * 显示库存宠物
 */
@Override
public List<Pet> getPetsInStock(int storeId) throws Exception {
	QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());//数据库连接操作
	String sql = "select * from pet where STORE_ID = ?";//sql编写操作
	return qr.query(sql,new BeanListHandler<Pet>(Pet.class),storeId);
	//根据storeID查询 封装进对象数组 
}
```

#### 	更新操作

```
/**
 * 更新台账信息
 */
	@Override
	public int update(Account account,Pet pet) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		Date date = new Date();//设置日期格式
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into account(DEAL_TYPE,PET_ID,SELLER_ID,BUYER_ID,PRICE,DEAL_TIME)"
				+ "values(?,?,?,?,?,?)";//sql语句编写
		return qr.update(sql,account.getDeal_type(),pet.getId(),pet.getOwner_id(),pet.getStore_id(),pet.getLove(),sdf.format(date));
	}//将带参的数据库执行更新操作
 
```
