package example

import scala.util.Try
import com.typesafe.config.{Config, ConfigFactory, ConfigParseOptions, ConfigResolveOptions}

case class Sensitive(value: String) extends AnyVal {
  override def toString: String = "MASKED"
}

case class DbConf(
  user: String,
  pass: Sensitive,
  host: String,
  database: String)

case class AppConf(db: DbConf)

object AppConf {
  def loadClasspath(): Try[AppConf] = Try {
    val configFileName = "pure-spark.conf"
    val classpath = ConfigFactory.load(configFileName, ConfigParseOptions.defaults().setAllowMissing(false), ConfigResolveOptions.defaults())
    pureconfig.loadConfigOrThrow[AppConf](classpath.resolve)
  }
  def loadPath(path: String): Try[AppConf] = {
    val file = ConfigFactory.parseFile(new java.io.File(path))
    Try(pureconfig.loadConfigOrThrow[AppConf](file.resolve))
  }
}
