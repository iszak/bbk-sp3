package flyweight

import java.util.HashMap
import java.util.Map

object PlatformFactory {

  private var map: Map[String, Platform] = new HashMap()

  def getPlatformInstance(platformType: String): Platform = map.containsKey(platformType) match {
    case true => map.get(platformType)
    case false => {
      map.put(platformType, platformType.toUpperCase match {
        case "SCALA" => new ScalaPlatform()
        case "C" => new CPlatform()
        case "JAVA" => new JavaPlatform()
        case "RUBY" => new RubyPlatform()
      })
      map.get(platformType)
    }
  }
  // this method will probably need to be synchronized

}
