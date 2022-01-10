package com.example.demo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//画面外からリクエストを受け付けるクラス
@Controller
public class HelloController {

//	GETメソッドのHTTPリクエストを受け付けるために、@GetMappingアノテーションを使う
//	受け付けるURLを、@GetMappingの引数に設定
//	今回は、[http://localhost:8080/hello]へのGETメソッドでのHTTPリクエストを受け付ける
	@GetMapping("hello")
	public String getHello() {
//		メソッドの戻り値には、拡張子を除いたHTMLのファイルパスを指定
//		[src/main/resources/templates]からの相対パスを戻り値に指定
		return "hello";

	}
}
