

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
	
/**
 * 分页实体类
 */

public class PageData<T> implements Serializable {


	private static final long serialVersionUID = 1L;
	private Integer totalPage;
	private Integer pageSize;
	private Integer pageNo;
	private Long totalCount;
	private List<T> data;
	
	public PageData(Page<T> page) {
		this.data = page.getContent();
		totalCount=page.getTotalElements();
		totalPage=page.getTotalPages();
		pageSize=page.getSize();
		pageNo=page.getNumber()+1;
	}


	



	public List<T> getData() {
		return data;
	}






	public void setData(List<T> data) {
		this.data = data;
	}






	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}


	
}
