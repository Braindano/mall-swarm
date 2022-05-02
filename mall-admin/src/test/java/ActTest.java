import com.macro.mall.mapper.ActActMapper;
import com.macro.mall.model.ActAct;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

public class ActTest extends BaseTest{


    @Resource
    private ActActMapper actActMapper;

    @Test
    public void testInsertBatch(){
        ActAct act = new ActAct();
        act.setActName("活动名称");
        act.setClubId(1L);
        act.setActTypeId(1L);
        act.setActTypeName("飞盘");
        act.setActPics("1111,12121");
        act.setStartTime(new Date());
        act.setEndTime(new Date());
        act.setAddress("江汉路");
        act.setAddressDetail("江汉路58号");
        act.setProvideService("导航；水果；午餐");
        act.setLatitude(BigDecimal.ONE);
        act.setLongitude(BigDecimal.ONE);
        act.setPromotionPrice(BigDecimal.valueOf(12.8));
        act.setOriginalPrice(BigDecimal.valueOf(22));
        act.setActDetail("活动说明");
        actActMapper.insert(act);
    }

}
