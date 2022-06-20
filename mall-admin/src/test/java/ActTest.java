import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import com.macro.mall.mapper.ActActMapper;
import com.macro.mall.model.ActAct;
import com.macro.mall.model.dto.HomeBanner;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
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

    @Test
    public void testJson(){
        HomeBanner b1 = new HomeBanner();
        b1.setImgUrl("http://act-info.oss-cn-hangzhou.aliyuncs.com/mall/images/20220603/22.png");
        b1.setHrefUrl("aaa");
        HomeBanner b2 = new HomeBanner();
        b2.setImgUrl("http://act-info.oss-cn-hangzhou.aliyuncs.com/mall/images/20220603/22.png");
        b2.setHrefUrl("aaa");
        HomeBanner b3 = new HomeBanner();
        b3.setImgUrl("http://act-info.oss-cn-hangzhou.aliyuncs.com/mall/images/20220603/22.png");
        b3.setHrefUrl("aaa");
        HomeBanner b4 = new HomeBanner();
        b4.setImgUrl("http://act-info.oss-cn-hangzhou.aliyuncs.com/mall/images/20220603/22.png");
        b4.setHrefUrl("aaa");
        ArrayList<HomeBanner> homeBanners = Lists.newArrayList(b1, b2, b3, b4);
        String s = JSONUtil.toJsonStr(homeBanners).toString();
        System.err.println(s);
    }
}
