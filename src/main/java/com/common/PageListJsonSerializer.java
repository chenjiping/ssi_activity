package com.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * 按照统一的grid分页机制，根据定制的json数据。封装提交到页面的json数据。
 * @author Tony.Zhou
 *
 */
public class PageListJsonSerializer extends JsonSerializer<PageList> {
	@Override
    public void serialize(PageList value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("total", value.getPaginator().getTotalCount());
        map.put("rows" , new ArrayList(value));
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(jgen, map);
    }
}
