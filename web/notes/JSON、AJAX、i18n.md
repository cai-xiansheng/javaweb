# JSON

## 什么是JSON

1. JSON(JavaScript Object Notation)是一种轻量级的数据交换格式。易于人阅读和编写。同时也易于机器解析和生成。JSON采用完全独立的文本格式，而且很多语言都提供了对JSON的支持（包括C，C++，C#，Java，JavaScript，Perl，Python等）。这样就使得JSON称为理想的数据交换格式。

2. JSON是一种轻量级的数据交换格式
3. 轻量级指的是跟xml作比较。
4. 数据交换指的是客户端和服务器之间业务数据的传递格式。

## JSON在JavaScript中的使用

### json的定义

1. json是由键值对，并且由花括号（大括号）包围。每个键由引号引起来，键和值之间使用冒号进行分隔，多组键值对之间进行逗号进行分隔。

2. json定义示例：

   ```json
   var jsonObj = {
       "key1": 12,
       "key2": "abc",
       "key3": true,
       "key4": [11, "arr", false],
       "key5": {
   		"key5_1": 551,
           "key5_2": "key5_2_value"
       },
       "key6": [
           {
               "key6_1_1": 6611,
               "key6_1_2": "key6_1_2_value"
           },
           {
               "key6_2_1": 6622,
               "key6_2_2": "key6_2_2_value"
           }
       ]
   };
   ```

   

### json的访问

1. json本身是一个对象
2. json中的key，我们可以理解为是对象中的一个属性。
3. json中的key访问就跟访问对象的属性一样：json对象.key
4. json访问示例：

```js
alert(typeof(jsonObj));// object json 就是一个对象
alert(jsonObj.key1); //12
alert(jsonObj.key2); // abc
alert(jsonObj.key3); // true
alert(jsonObj.key4);// 得到数组[11,"arr",false]
// json 中 数组值的遍历
for(var i = 0; i < jsonObj.key4.length; i++) {
	alert(jsonObj.key4[i]);
}
alert(jsonObj.key5.key5_1);//551
alert(jsonObj.key5.key5_2);//key5_2_value
alert( jsonObj.key6 );// 得到 json 数组
// 取出来每一个元素都是 json 对象
var jsonItem = jsonObj.key6[0];
// alert( jsonItem.key6_1_1 ); //6611
alert( jsonItem.key6_1_2 ); //key6_1_2_value
```

### json的两个常用方法

1. json存在两种形式。
2. 一种是：对象的形式存在，我们叫它json对象。
3. 一种是：字符串的形式存在，我们叫它json字符串。
4. 一般我们要操作json中的数据的时候。需要json对象的格式。
5. 一般我们要在客户端和服务器之间进行数据交换的时候，使用json的字符串。
6. **JSON.stringify()** 把json对象转换成为json字符串
7. **JSON.parse()** 把json字符串转换成为json对象

示例代码：

```js
// 把 json 对象转换成为 json 字符串
var jsonObjString = JSON.stringify(jsonObj); // 特别像 Java 中对象的 toString
alert(jsonObjString)
// 把 json 字符串。转换成为 json 对象
var jsonObj2 = JSON.parse(jsonObjString);
alert(jsonObj2.key1);// 12
alert(jsonObj2.key2);// abc
```

## JSON在Java中的使用

### JavaBean和json的互转

```java
    public void test1() {
        Person person = new Person(1, "cc");

        // 创建gson对象实例
        Gson gson = new Gson();


        // toJson方法 可以把Java对象转化为json字符串
        String personJsonString = gson.toJson(person);
        System.out.println(personJsonString);

        // fromJson把json字符串转换回Java对象
        // 第一个参数是json字符串
        // 第二个参数是转换回去的Java对象类型
        Person person1 = gson.fromJson(personJsonString, Person.class);
        System.out.println(person1);
    }
```



### List和json的互转

```java
    public void test2() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1, "cc"));
        personList.add(new Person(2, "aa"));
        Gson gson = new Gson();
        String persionJsonString = gson.toJson(personList);
        System.out.println(persionJsonString);

        List<Person> list = gson.fromJson(persionJsonString, new PersonListType().getType());
        System.out.println(list);
        Person person = list.get(0);
        System.out.println(person);
    }
```



### map和json的互传

```java
    public void test3() {
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "cc"));
        personMap.put(2, new Person(2, "aa"));

        Gson gson = new Gson();
        // 把map集合转换成json字符串
        String personMapJsonString = gson.toJson(personMap);
        System.out.println(personMapJsonString);

        //Map<Integer, Person> personMap1 = gson.fromJson(personMapJsonString, new PersonMapType().getType());
        // 使用匿名内部类
        Map<Integer, Person> personMap1 = gson.fromJson(personMapJsonString, new TypeToken<Map<Integer, Person>>() {
        }.getType());
        System.out.println(personMap1);
        System.out.println(personMap1.get(1));
    }
```



# AJAX请求

## 什么是Ajax请求

1. Ajax即“Asynchronous Javascript And XML”（异步JavaScript和XML），是指一种创建交互式网页开发技术。
2. Ajax是一种浏览器通过js异步发起请求，局部更新新页面的技术。
3. Ajax请求的局部更新，浏览器地址栏不会发生变化。
4. 局部更新不会舍弃原来页面的内容。



## 原生Ajax请求的示例

```html
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
            // 在这里使用javascript语言发起ajax请求，烦问服务器AjaxServlet中javaScriptAjax
			function ajaxRequest() {
// 				1、我们首先要创建XMLHttpRequest 
                var xmlHttpRequest = new XMLHttpRequest();
// 				2、调用open方法设置请求参数
                xmlHttpRequest.open("GET", "http://localhost:8080/16_json_ajax_i18n/ajaxServlet?action=javaScriptAjax",true);
// 				4、在send方法前绑定onreadystatechange事件，处理请求完成后的操作。
                xmlHttpRequest.onreadystatechange = function () {
                    if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
                        // 把响应的数据显示在页面上
                        document.getElementById("div01").innerHTML = xmlHttpRequest.responseText;
                    }
                }
// 				3、调用send方法发送请求
                xmlHttpRequest.send();

			}
		</script>
	</head>
	<body>	
		<button onclick="ajaxRequest()">ajax request</button>
		<div id="div01">
		</div>
	</body>
</html>
```



## jQuery中的Ajax请求

### **$.ajax方法**

| url      | 表示请求的地址              |
| -------- | --------------------------- |
| type     | 表示请求的类型GET或POST请求 |
| data     | 表示发送给服务器的数据      |
| success  | 请求成功，响应的回调函数    |
| dataType | 响应的数据类型              |

**data**格式有两种

1. name=value&name=value
2. {key : value}

**dataType**常用的数据类型有：

1. text表示纯文本
2. xml表示xml数据
3. json表示json对象



```js
// ajax请求
$("#ajaxBtn").click(function () {

    $.ajax({
        url: "http://localhost:8080/16_json_ajax_i18n/ajaxServlet",
        // data: "action=jQueryAjax",
        data: {action: "jQueryAjax"},
        type: "GET",
        success: function (jsonObj) {
            alert("服务器返回的数据为：" + jsonObj);
            // var jsonObj = JSON.parse(data);
            // alert(jsonObj);
            $("#msg").html("get编号" + jsonObj.id + "，姓名：" + jsonObj.name);
        },
        dataType: "json"
    })

});
```





### $.get方法和$.post方法

| url      | 请求的url地址  |
| -------- | -------------- |
| data     | 发送的数据     |
| callback | 成功的回调函数 |
| type     | 返回的数据类型 |

```js
// ajax--get请求
$("#getBtn").click(function () {

    $.get("http://localhost:8080/16_json_ajax_i18n/ajaxServlet", "action=jQueryGet", function (jsonObj) {
        $("#msg").html("get编号" + jsonObj.id + "，姓名：" + jsonObj.name);
    }, "json")

});

// ajax--post请求
$("#postBtn").click(function () {
    // post请求
    $.post("http://localhost:8080/16_json_ajax_i18n/ajaxServlet", "action=jQueryPost", function (jsonObj) {
        $("#msg").html("post编号" + jsonObj.id + "，姓名：" + jsonObj.name);
    }, "json")


});

```



### $.getJSON方法

| url      | 请求的url地址      |
| -------- | ------------------ |
| data     | 发送给服务器的数据 |
| callback | 成功的回调函数     |

```js
// ajax--getJson请求
$("#getJSONBtn").click(function () {
    // 调用
    $.getJSON("http://localhost:8080/16_json_ajax_i18n/ajaxServlet", "action=jQueryJson", function (jsonObj) {
        $("#msg").html("post编号" + jsonObj.id + "，姓名：" + jsonObj.name);
    })

});
```



### 表单序列化**serialize()**

**serialize()**可以把表单中所有表单项的内容都获取到，并以name=value&name=value的形式进行拼接。

```js
// ajax请求
$("#submit").click(function () {
    // 把参数序列化
    alert($("#form01").serialize())
    $.getJSON("http://localhost:8080/16_json_ajax_i18n/ajaxServlet","action=jQuerySerialize&" + $("#form01").serialize(),function (jsonObj) {
        $("#msg").html("jQuerySerialize编号" + jsonObj.id + "，姓名：" + jsonObj.name);
    })
});
```



