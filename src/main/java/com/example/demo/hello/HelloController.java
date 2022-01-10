package com.example.demo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//画面外からリクエストを受け付けるクラス
@Controller
public class HelloController {
//	DIを使用するために付与
	@Autowired
	private HelloService service;

//	GETメソッドのHTTPリクエストを受け付けるために、@GetMappingアノテーションを使う
//	受け付けるURLを、@GetMappingの引数に設定
//	今回は、[http://localhost:8080/hello]へのGETメソッドでのHTTPリクエストを受け付ける
	@GetMapping("/hello")
	public String getHello() {
//		メソッドの戻り値には、拡張子を除いたHTMLのファイルパスを指定
//		[src/main/resources/templates]からの相対パスを戻り値に指定
		return "hello";
	}
//	POSTメソッドのHTTPアノテーションを受け付けるために＠PostMappingを使用
//	受け付けるURLを引数に指定（送り先ではなく、受付先のURL）
	@PostMapping("/hello")
//	画面で入力された値を、サーバーが受け取る方法の１つとして、@RequestParamアノテーションがある
//	メソッドの引数にこのアノテーションを付ける
//	そして、HTMLのname属性と一致するように、@RequestParamアノテーションの引数を指定
//	→つまり、＠PostMappingで指定したページの、どの入力データを受け取るのかの指定
	
//	また、Modelクラスを使うことで、別の画面に値を渡すことが可能
//	ModelクラスのaddAttributeメソッドにキー名と値を指定
//	Modelクラスにキーと値を登録しておくと、画面がこの値を受け取ることが可能
	public String postRequest(@RequestParam("text1")String str, Model model) {
//		前画面から受け取った文字列をModelに登録(キー名, 値)
		model.addAttribute("sample", str);
//		response.htmlに画面遷移
		return "hello/response";
	}
		
		@PostMapping("hello/db")
		public String postDbRequest(@RequestParam("text2")String id, Model model) {
//			1件検索
			Employee employee = service.getEmployee(id);
//			検索結果をmodelに登録
			model.addAttribute("employee", employee);
//			db.htmlに画面遷移
			return "hello/db";
			
			
		}
	}

