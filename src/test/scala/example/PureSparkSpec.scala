package example

import org.scalatest._
import scala.util.Success

class PureSparkSpec extends FlatSpec with Matchers {
  "config" should "load from explicit path" in {
    AppConf.loadPath("src/test/resources/pure-spark.conf") shouldBe Success(AppConf(DbConf("jim", Sensitive("secret"), "place", "time")))
  }
  "config" should "load from classpath" in {
    AppConf.loadClasspath() shouldBe Success(AppConf(DbConf("jim", Sensitive("secret"), "place", "time")))
  }
}
