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