package com.rubbish.rubbishcustomfeign.FallBackFactoryTest;

import com.rubbish.rubbishcustomfeign.Service.FeignService;
import com.rubbish.rubbishservice.Entity.Rubbish;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component//一定不要忘记加
public class RubbishClientFallBack implements FallbackFactory<FeignService> {
    @Override
    public FeignService create(Throwable throwable) {
        return new FeignService() {
            @Override
            public List<Rubbish> getAll() {
                return null;
            }

            @Override
            public Rubbish getById(int id) {
                Rubbish rubbish = new Rubbish();
                rubbish.setName("查询的用户的id" + id + "此服务器暂停服务");
                rubbish.setSource("查询的用户的id" + id + "此服务器暂停服务");
                return rubbish;
            }

            @Override
            public void deleteById(int id) {

            }

            @Override
            public Rubbish save(Rubbish rubbish) {
                return null;
            }

            @Override
            public Rubbish updateById(Rubbish rubbish) {
                return null;
            }

            @Override
            public Object getDiscovery() {
                return null;
            }
        };
    }
}
