##  170. Hepsiemlak Java Spring Bootcamp

###### Tacettin Utku Süer



#### Ödev 4 Soru 2-a



Aşağıda temel SQL komutları gösterilmiştir. Komutlar içerisinde tablo ismi ve tablo sütun isimleri girildikten sonra değer yazan kısımlara uygun sayıda '?' soru işareti yazılarak komutlar hazır hale getirilir. Bu hazır hale gelen komutlar String değişken olarak tanımlanmalıdır ve sonrada bu String tanımlanan kodlar çağırılarak database işlemleri yapılacaktır. 



| Komut      | JDBC ve JDBC Template                                        |
| ---------- | ------------------------------------------------------------ |
| Ekleme     | INSERT INTO "tablo_ismi" ("tablo_sütun_isimleri") VALUES ("değerleri") |
| Okuma      | SELECT * FROM "tablo_ismi"                                   |
| Filtreleme | SELECT * FROM "tablo_ismi" WHERE "filtrelenecek_sütun_adı" = "değeri" |
| Güncelleme | UPDATE "tablo_ismi" SET ADDRESS="yeni_adres_değeri" WHERE ID="güncellenecek_satırın_id_değeri" |
| Silme      | DELETE FROM "tablo_ismi" WHERE ID= "silinecek_satırın_id_değeri" |



JDBC kullanırken çağırılan komut String değişkeninde her bir soru işaretini tanımlamak için prepareStatement'ın uygun olan setInt veya setString komutlarıyla bu soru işaretlerine sırasıyla tanımlama yapılır. Dikkat edilmesi gereken soru işareti kadar bu komut kullanılmalı, index numarası artırılmalı ve soru işaretinde uygun yere denk düşecek şekilde yapılmalıdır. Aşağıda örnek kod yer almaktadır.



```java
String INSERT_ADVERT = "INSERT INTO ADVERT (ID, TITLE, ADDRESS) VALUES (?,?,?);";

PrepareStatement prepareStatement = connection.prepareStatement(INSERT_ADVERT);
prepareStatement.setInt(1, id);
prepareStatement.setString(2, "başlık");
prepareStatement.setString(3, "adres");
```



JDBC Template de benzer şekilde çalışmaktadır. Öncelikle soru işaretinden oluşan bir String değişken tanımlanması gerekmektedir. Sonraki işlemler aşağıda kod olarak gösterilmiştir.



```java
String INSERT_ADVERT = "INSERT INTO ADVERT (ID, TITLE, ADDRESS) VALUES (?,?,?);";

JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
public boolean createAdvert(Advert advert) {
	return jdbcTemplate.update(INSERT_ADVERT, advert.getId(), advert.getTitle(), advert.getAddress();
}
 
jdbcTemplate.createAdvert(new advert(id, "başlık", "adres"));
```



Başlangıçta verilmiş tablodaki diğer komutlar ise aynı mantıkla kullanılarak CRUD işlemleri gerçekleştirilir.



Hibernate de ise doğrudan SQL komutlarıyla ilgilenmemize gerek yoktur. Bu işlemleri arka planda Hibernate bizim için yapmaktadır. Aşağıda bu işlemler ile ilgili tablo yer almaktadır.



| Komut      | Hibernate                               |
| ---------- | --------------------------------------- |
| Ekleme     | .save("kaydedilecek_değer")             |
| Okuma      | .findAll()                              |
| Filtreleme | .findAllById("id_değeri")               |
| Güncelleme | .saveOrUpdate("güncellenecek_değerler") |
| Silme      | .delete("id_değeri")                    |



Hibernate'in kullanımıda çok daha kolay, aşağıda örnek kod yer almaktadır.



```java
	@Autowired
	private AdvertRepository advertRepository;
	
	 advertRepository.save(new advert(id, "başlık", "adres"));
```

