package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController //이곳을 Controller로 쓰겠다는 어노테이션 명령어. 그럼 위에 임포트가됨.
@RequestMapping("/api") //이곳으로 들어올 API주소를 매핑해주기 위함. 괄호안에는 어떤주소로 받을지 Path를 넣음
                        //이렇게되면 Localhost:8080/api까지 매칭된거임.
public class GetController {

    //메소드는 GET타입으로 받고, path는 어떤주소로 받아들이겠다는 명령. Localhost:8080/api/getMethod로 호출하면
    //사용자의 요청이 아래 getRequest로 들어옴
    @RequestMapping(method = RequestMethod.GET, path ="/getMethod")

    public String getRequest(){

        return "Hi getMethod";
    }//사용자 요청에 대해 한가지 메소드로 받아들일 수 있음

    //Get에대해 매핑할거라서 RequestMapping말고 이 명령어씀. 겟매핑은 메소드지정안하고 주소만설정해주면됨.
    //Localhost:8080/api/getParameter?id=1234&password=abcd로 매칭
    @GetMapping("/getParameter")
    //위에 getParameter뒤에 나오는 id와 password를 매칭시켜줌
    public String getParameter(@RequestParam String id, @RequestParam String password){
        System.out.println("id : "+id);
        System.out.println("password : "+password);

        return id+password;
    }

    //Localhost:8080/api/multiParameter?account=abcd&email=study@gamil.com&page=10

    /* 원래는 이렇게 되야할 메소드가 아래처럼 줄어들 수 있음. 그건 바로 Get Set 메소드 덕분이지.
    public String getMultiParameter(@RequestParam String account,
                                    @RequestParam String eamil,
                                    @RequestParam int page){
    */
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //파일주고받을때 json형태로 받으니까 다음 형식이 되야함 { "account" : "", "email" ; "", "page" : 0 }
        return searchParam;
    }


}
