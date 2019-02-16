通过maven整合ssm框架（通过c3p0配置数据源，spring与mybatis完美适应，若无特殊需求可以不在spring的配置文档中映射mybatis的配置文档） 
注意事项：1.项目所引入的jre版本及web dynamic版本不能过低及二者版本要适合（修改版本时注意修改pom.xml中jre版本的配置，否则每次更新maven项目时都自动引入默认的jre版本） 
2.通过maven依赖的各jar包（eg.：springframe版本、mybatis版本、mysql版本、spring-mybatis版本、mysql-connector版本等）版本之间的兼容性要适应，否则会导致在通过接口访问数据库时报错
配置文档：1.在web.xml文档中配置spring容器和映射springmvc配置文档等； 
2.在spring配置文档中配置数据源、事务处理、扫描dao接口、映射mapper.xml文档、整合mybatis等 3.在springmvc配置文档中扫描controller类、配置视图解析器等