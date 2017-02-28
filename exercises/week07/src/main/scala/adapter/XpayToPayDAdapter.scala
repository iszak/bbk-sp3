package adapter

import xpay._

class XpayToPayDAdapter(xpay:Xpay) extends PayD {
  override def getCustCardNo: String = xpay.getCreditCardNo

  override def setCustCardNo(custCardNo: String): Unit = xpay.setCreditCardNo(custCardNo)

  override def getCardOwnerName: String = xpay.getCustomerName

  override def setCardOwnerName(cardOwnerName: String): Unit = xpay.setCustomerName(cardOwnerName)

  override def getCardExpMonthDate: String = xpay.getCardExpMonth

  override def setCardExpMonthDate(cardExpMonthDate: String): Unit = xpay.setCardExpMonth(cardExpMonthDate)

  override def getCVVNo: Integer = xpay.getCardCVVNo.toInt

  override def setCVVNo(cVVNo: Integer): Unit = xpay.setCardCVVNo(cVVNo.toShort)

  override def getTotalAmount: Double = xpay.getAmount

  override def setTotalAmount(totalAmount: Double): Unit = xpay.setAmount(totalAmount)
}
