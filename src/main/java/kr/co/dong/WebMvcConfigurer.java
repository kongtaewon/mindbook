package kr.co.dong;

import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;

public interface WebMvcConfigurer {

	

   
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters);
}
