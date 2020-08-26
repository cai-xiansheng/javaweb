# XML

## XML简介

### 什么是xml？

> xml是可扩展标记语言（标签可以自定义，不是一程不变的）

### xml的作用？

xml的主要作用有：

1. 用来保存数据，而且这些数据具有自我描述性
2. 它还可以作为羡慕或者模块的配置模块
3. 还可以作为网络创数数据的格式（JSON为主）。

## XML语法

1. 文档声明
2. 元素（标签）
3. xml属性
4. xml注释
5. 文本区域（CDATA区）

### 文档声明

```xml
<?xml version="1.0" encoding="utf-8" ?>
<!--
    <?xml version="1.0" encoding="utf-8" ?>
    以上内容就是xml文件的声明
    version="1.0"       version 表示xml的版本
    encoding="utf-8"    encoding表示xml文件本身的编码
	standalone="yes/no"	表示这个xml文件是否是独立的xml文件
-->

```

```xml
<?xml version="1.0" encoding="utf-8" ?>
<!--
    <?xml version="1.0" encoding="utf-8" ?>
    以上内容就是xml文件的声明
    version="1.0"       version 表示xml的版本
    encoding="utf-8"    encoding表示xml文件本身的编码
-->
<books> <!--books表示多个图书信息-->
    <book sn="SN123141515"><!--book表示一个图书信息 sn表示图书序列号-->
        <name>时间简史</name><!--name标签表示书名-->
        <author>霍金</author>
        <price>75</price>
    </book>
    <book sn="SN123181515"><!--book表示一个图书信息 sn表示图书序列号-->
        <name>java从入门到入土</name><!--name标签表示书名-->
        <author>高淇</author>
        <price>0.9</price>
    </book>
</books>
```

### 文本区域(CDATA)

1. CDATA 语法可以告诉 xml 解析器，我 CDATA 里的文本内容，只是纯文本，不需要 xml 语法解析 

2. CDATA 格式：  `<![CDATA[这里可以把你输入的字符原样显示，不会解析 xml]]>`

## 使用dom4j解析xml

```java
	/**
     * 读取books.xml文件生成Book类
     */
    @Test
    public void test2() throws DocumentException {
        // 1. 读取books.xml文件
        SAXReader reader = new SAXReader();
        // 在Junit测试中，相对路径始从模块名开始算
        Document document = reader.read("src/books.xml");
        // 2. 通过Document对象获取根元素
        Element rootElement = document.getRootElement();
        //System.out.println(rootElement);
        // 3. 通过根元素获取book标签对象
        // element() 和 elements() 都是通过标签名查找子元素
        List<Element> books = rootElement.elements("book");
        // 4. 遍历，处理每个book标签转换为Book类
        for (Element book : books) {
            // asXML() 把标签对象，转化为标签字符串
            Element nameElement = book.element("name");
            // getText() 可以获取标签中的文本内容
            String nameText = nameElement.getText();
            // 直接获取指定标签名的文本内容
            String priceText = book.elementText("price");
            String authorText = book.elementText("author");

            String snValue = book.attributeValue("sn");
            // .attributeValue("sn"); 获取属性

            System.out.println(new Book(snValue, nameText, BigDecimal.valueOf(Double.parseDouble(priceText)), authorText));

        }
    }
```

**需要导入如下jar包**![image-20200812104947397](xml.assets\image-20200812104947397.png)

除过必须要导入的dom4j以外，junit的作用就是一个单元测试用例。

## XML解析过程

1. 导入相应的jar包
2. 读取xml文件
3. 获取标签对象，然后创建对象