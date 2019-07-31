package taojinsimu.com.mortgage.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author bmr
 * @time 2019-07-31 11:24
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor=new PaginationInterceptor();
        return paginationInterceptor;
    }

    /**
     * 打印 sql
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor =new PerformanceInterceptor();

        //格式化sql语句  format的默认值就是false   这里可以不设置  如果想格式化打印sql语句  将值设为true即可
        Properties properties =new Properties();
        properties.setProperty("format", "false");

        performanceInterceptor.setProperties(properties);

        return performanceInterceptor;
    }
}
