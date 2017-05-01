package proxy.remoteproxy

import java.rmi.Naming
import java.rmi.RemoteException
import java.rmi.server.UnicastRemoteObject
import java.util.Date
import java.text.SimpleDateFormat

object ReportGeneratorImpl extends App {
  try {
    val reportGenerator: ReportGenerator = new ReportGeneratorImpl()
    Naming.rebind("PizzaCoRemoteGenerator", reportGenerator)
  } catch {
    case e: Exception => e.printStackTrace()
  }
}

class ReportGeneratorImpl protected ()
  extends UnicastRemoteObject
  with ReportGenerator {

  @throws(classOf[RemoteException])
  override def generateDailyReport(): String = {
    val dateFormat = new SimpleDateFormat("E MMM d H:m:s z y")
    val date = new Date()

    "********************Location X Daily Report********************\n" +
      "Location ID: 012\n" +
      s"Today’s Date: ${dateFormat.format(date)}\n" +
      "Total Pizza Sell: 112\n" +
      "Total Sale: $2534\n" +
      "Net Profit: $1985\n" +
      "***************************************************************"
  }
}
