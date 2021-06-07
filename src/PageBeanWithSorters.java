

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;


/**
 * 后台接收对象继承此类（包含排序与分页） 前端组件s-table和SortComponent配合其使用
 * @author xjx
 *
 */
public class PageBeanWithSorters {
	
	private Integer pageNo = 1;
	private Integer pageSize = 10;
	List<Order> orders;
	
	public Pageable Pageable() {
		if(orders == null) {
			return PageRequest.of(getPageNo() - 1, getPageSize());
		}
//		orders.stream().filter(new Predicate<Order>() {
//			@Override
//			public boolean test(Order t) {
//				return !"".equals(t.getProperty());
//			}
//		});
		return PageRequest.of(getPageNo() - 1, getPageSize(), Sort.by(orders));
	}
	

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
}
