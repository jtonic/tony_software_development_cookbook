package ro.jtonic.handson.handsonsb23

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConf {

  @Bean
  fun mapper(): ObjectMapper = ObjectMapper()
}