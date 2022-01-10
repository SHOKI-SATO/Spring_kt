package com.example.demo.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

//データベースから従業員を検索する処理をするクラス
//＠RepositoryはDBアクセスを行うクラスに付与
@Repository
public class HelloRepository {
//	DIを使うためのアノテーション
@Autowired
//JdbcTemplateクラスを使えば、JDBCを使ってSQLを実行することができます。
//今回は、select文の結果をMapで取得しています。
//このMapのキーには、select結果のカラム名が入っています。
//Mapの値には、select結果の値が入っています。

private JdbcTemplate jdbcTemplate;

//Map<キーの型名, 値の型名> オブジェクト名 = new HashMap<>();
public Map<String, Object>findById(String id){
	
//	SELECT文
	String query ="SELECT * "
			+ "FROM employee "
			+ "WHERE id =?";
	
//	検索実行
	Map<String, Object>employee = jdbcTemplate.queryForMap(query, id);
	return employee;
}
}
