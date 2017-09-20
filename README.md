# DaoSupport

A simple lightweight database operation framework :

 * Simple configuration, out-of-the-box
 * Very suitable for micro-service development
 * stands the test of time,an e-commerce company has been used for more than 10 years
## quick start
Add maven dependency
```xml
<dependency>
	<groupId>io.github.daosupport</groupId>
	<artifactId>jdbcTemplate-support</artifactId>
	<version>1.0.1-RELEASE</version>
</dependency>
```
```java
	@Autowired
	private IDaoSupport daoSupport;
    public List<Map<String,Object>> getTestList(){
		String sql="select * from t_example";
		return this.daoSupport.queryForList(sql);
	}
```
Look, it's works!

Thanks  for my last company ,they agree that I'm open source code.
Thanks  for the boss of my last company,he contributed most of the code.
If you want to buy the source code of  e-commerce,please contact him.
their website is http://www.javamall.com.cn .