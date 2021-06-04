




import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CityDataMapper {

	Page<dataResult> listQuery(@Param("paramQuery") paramQuery paramQuery,Pageable pageable);

}
