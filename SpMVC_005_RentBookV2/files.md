# tiles layout 설정

- JSP를 위한 Layout 설정 도구
- tiles 를 설정하기 위한 dependencies 설정
- spring 5.x 이상에서는 tiles-extras 만 설정해도 기타 필요한 dependency를 모드 inport 해 준다.
- 다만 tiles-extras 를 설정한 후 Mavben Dependecies 에 tiles-core 가 함께 import 되어있는지 확인할 필요가 있다.

```xml
<properties>
	<tiles-version>3.0.8</tiles-version>
</properties>

	<dependencies>
		<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-extras -->
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-extras</artifactId>
			<version>${tiles-version}</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.tiles/tiles-core -->
		<dependency>
			<groupId>org.apache.tiles</groupId>
			<artifactId>tiles-core</artifactId>
			<version>${tiles-version}</version>
		</dependency>

	</dependencies>
```
- layout.xml 파일 생성
```xml
	<bean id="tilesConfigurer"
		class="org.springframework.web.servlet.view.tiles3.TilesConfigurer">
		<property name="definitions">
			<list>
				<value>/WEB-INF/spring/tiles-layout/*-layout.xml</value>
			</list>
		</property>
	</bean>

	<bean
		class="org.springframework.web.servlet.view.UrlBasedViewResolver">
		<property name="viewClass"
			value="org.springframework.web.servlet.view.tiles3.TilesView" />
		<property name="order" value="1"></property>
	</bean>
```


## InternalResourceViewResolver 와 협력관계 설정
- tiles-context.xml 설정 파일을 appServlet 폴더에 생성한다.

