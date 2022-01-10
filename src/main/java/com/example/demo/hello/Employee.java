package com.example.demo.hello;

import lombok.Data;

//検索結果格納用クラス
//@DataはLombokが用意しているアノテーションです。
//これを付けると、以下のメソッドを自動で生成してくれます。
//・getter
//・setter
//・toString
//・hashCode
//・equals
//→フィールド名を変更してもgetter、setterを作り直す手間が省ける
@Data
public class Employee {
	private String employeeId;
	private String employeeName;
	private int employeeAge;
}
