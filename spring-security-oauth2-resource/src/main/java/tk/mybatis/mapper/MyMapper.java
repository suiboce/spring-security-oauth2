package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author wzh
 * @date 2019/10/30 - 11:02
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
