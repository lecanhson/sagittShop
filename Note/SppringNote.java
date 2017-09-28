Spring Note 


Core Spring Container : Quản lý các bean application của Spring
Spring AOP Module : Giống như Dependencies Inject , chuẩn bị liên quan đến Object
Data Access and Integration : Làm việc trực tiếp với JDBC và Data-access Object


Declarative : Khai báo, Khai nhận
Improvement: sự cải thiện

@Component scanning : Spring automatically , bean thể hiện cho application

@Configuration
@ComponentScan : cách 1 là xài Annotation

<context:Component-scan base-package ="soundsystem"> : cách 2 là cấu hình ở xml 

@RunWith(SpringJUnit4ClassRunner.class) : tự động chạy class này khi test bắt đầu

@ContextConfiguration(classes=CDPlayerConfig.class) : Annotation này chỉ ra class cần
test là CDPlayerConfig.

@Component("lonelyHeartsClub") : luôn phải có id chỉ đích danh

hoặc có thể dùng import javax.inject.Named;
@Named("lonelyHeartsClub") : để thay cho

@Configuration
@ComponentScan("soundsystem") : xài cái này cho cả base-package luôn 
@ComponentScan(basePackages="soundsystem")


@Autowired
public CDPlayer(CompactDisc cd) {
this.cd = cd;
}   :// cái này xài cho set method

Autowired này dùng để liên kết các bean lại với nhau
If there are no matching beans, Spring will throw an exception as the application
context is being created. To avoid that exception, you can set the required attribute : Nếu ko tìm ra beans nào khớp thì Spring sẽ báo exception
on @Autowired to false : 
@Autowired(required=false)
public CDPlayer(CompactDisc cd) {
this.cd = cd;
}


import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=CDPlayerConfig.class)
public class CDPlayerTest {
@Rule
public final StandardOutputStreamLog log = new StandardOutputStreamLog();
	@Autowired
	private MediaPlayer player;

	@Autowired
	private CompactDisc cd;
	
	@Test
	public void cdShouldNotBeNull() {
	assertNotNull(cd);
	}
	
	public void play() {
	player.play();
	assertEquals(
	"Playing Sgt. Pepper's Lonely Hearts Club Band" +
	" by The Beatles\n",
	log.getLog());
	}
}


@Bean
public CompactDisc sgtPeppers() {
return new SgtPeppers();
}  : Như vậy là khai báo một bean trong Spring


obtained: đạt được



@Component
@Qualifier("cold")
@Qualifier("creamy")
public class IceCream implements Dessert { ... } 



@Component
@Qualifier("cold")
@Qualifier("fruity")
public class Popsicle implements Dessert { ... }

: Qualifier dùng để chỉ đích danh 1 định nghĩa của mình khai báo


Ở cơ bản, tất cả các bean được khởi tạo đều ở dạng Singleton

Singleton—One instance of the bean is created for the entire application.
Prototype—One instance of the bean is created every time the bean is injected
into or retrieved from the Spring application context.
Session—In a web application, one instance of the bean is created for each session.
Request—In a web application, one instance of the bean is created for each
request


@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) Dùng cái ConfigurableBeanFactory.SCOPE_PROTOTYPE nó chuẩn hơn và bảo mật hơn và ít lỗi hơn nữa 
public class Notepad { ... }

Alternatively : Sự lựa chọn , phó từ

typical: tiêu biểu


@Component
@Scope(
value=WebApplicationContext.SCOPE_SESSION,
proxyMode=ScopedProxyMode.INTERFACES)
public ShoppingCart cart() { ... }    Ở springframework khi chọn ở ô ShoppingCart , thường để Singleton sẽ mất session , nên chọn lại Scope , với như trên 

Suppose: cho rằng, tin tưởng rằng 


<bean id="cart"
		class="com.myapp.ShoppingCart"
		scope="session">
		<aop:scoped-proxy />
</bean>

placeholders: phần giữ chỗ 
ability : năng lực
expression : biểu thức 

public BlankDisc(@Value("#{systemProperties['disc.title']}") String title, @Value("#{systemProperties['disc.artist']}") String artist) {
	this.title = title;
	this.artist = artist;
	}


	Cấu hình ở file xml :
	 <bean id="sgtPeppers"
		class="soundsystem.BlankDisc"
		c:_title="#{systemProperties['disc.title']}"
		c:_artist="#{systemProperties['disc.artist']}" />





	aspects : vẻ bề ngoài, khía cạnh
	circumstances : trường hợp 


	@SuppressWarnings : tắt cảnh báo lỗi biên dịch của eclipse


	@Resource sử dụng cho filed, và setter method. @Qualifier và @Autowired cho constructor hoặc một multi-argument method injection.