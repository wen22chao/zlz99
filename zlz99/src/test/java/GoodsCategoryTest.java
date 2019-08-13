import cn.tedu.store.entity.GoodsCategory;
import cn.tedu.store.service.IGoodsCategoryService;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class GoodsCategoryTest {

	@Test
	public void test1() {
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext(
				"spring-dao.xml", "spring-service.xml");
	
		IGoodsCategoryService service
			= ac.getBean("goodsCategoryService", IGoodsCategoryService.class);
		
		Long parentId = 161L;
		List<GoodsCategory> categories161 = 
				service.getList(parentId, 3);
		for (GoodsCategory goodsCategory : categories161) {
			System.out.println(goodsCategory);
			
			List<GoodsCategory> categories = 
					service.getList(goodsCategory.getId());
			for (GoodsCategory goodsCategory2 : categories) {
				System.out.println("\t" + goodsCategory2);
			}
			
			System.out.println();
		}
		
		ac.close();
	}
	
}
