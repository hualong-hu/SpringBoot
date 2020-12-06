package org.bigjava;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
/**
 * 快速体验缓存
 * 	步骤：
 * 		1、开启基于注解的缓存 @EnableCaching
 * 		2、标注缓存注解即可
 *          @Cacheable :
 *          	将方法的运行结果进行缓存，以后再要相同的数据，直接从缓存中获取，不用调用方法
 *      		CacheManager管理多个Cache组件的，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件有自己唯一一个名字
 *           	cacheNames/value：指定缓存组件的名字
 *            	key：缓存数据使用的key：可以用它来指定。默认是使用方法参数的值
 *                	编写SqEL： #id:参数id的值  #a0  #b0  #root.args[0]
 *            	keyGenerator：key的生成器，可以自己指定key的生成器的组件id
 *                	key/keyGenerator：二者选其一使用
 *            	cacheManager：指定缓存管理器，或者cacheResolver指定获取解析器
 *           	condition：指定符合条件的情况下才缓存；
 *           	unless：否定缓存，当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
 *                	unless = "#result == null"
 *            	sync：是否使用异步模式
 *
 *
 * 			@CacheEvict
 * 			@CachePut
 *
 *
 *
 */

@SpringBootApplication

@MapperScan(basePackages = "org.bigjava.mapper")
@EnableCaching
public class Day07Application {

	public static void main(String[] args) {
		SpringApplication.run(Day07Application.class, args);
	}

}
