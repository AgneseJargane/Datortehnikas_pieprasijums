package Uzdevums.eqRequest;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EqRequestMapper {
	List<EqRequest> getEquipmentRequestList();

}
