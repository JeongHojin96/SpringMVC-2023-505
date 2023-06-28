# Component
- Spring MVC 프로젝트에서는 class 에 다양한 Annotation 을 부착할 수 있다.
- @Controller, @Service, @Component 등의 Annotation을 클래스에 부착하고 이러한 Annotation 이 부착된 클래스를 `Component[컴포넌트]` 라고 부른다.
- 분리된 구조적 모듈로 표현할수 있다.
- Spring MVC 프로젝트는 여러가지 다양한 Component 들이 모여서 서로 협력하며 프로젝트를 실행한다.

## component-scan
- Spring MVC 프로젝트가 `Run on Server (서버에의해 실행)`되면 Component Annotation 이 부착된 class 들은 자동으로 객체로 생성되고 Spring, Tomcat `Container` 에 보관된다.
- `Container`에 보관된 `Component`들은 필요한 경우 자동으로 서로 Wirering 된다.
- Spring MVC 프로젝트의 `Servlet	- contentext.xml` 파일을 확인해 보면 `component-sca` 이라는 항복이 있다.
- 프로젝트가 시작되면 servlet-contentext.xml 의 component-scan 항목에 설정된 대로 프로젝트의 class 들을 모두 scan 하고 Annotation 이 부착된 class 를 만나면 Componeent 로 만들어서 COntatiner 에 보관한다.