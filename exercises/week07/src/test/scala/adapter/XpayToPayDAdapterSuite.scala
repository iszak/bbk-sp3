import adapter._
import xpay._
import org.scalatest.FunSuite

class XpayToPayDAdapterSuite extends FunSuite {
  test("card number") {
    val cardNumber = "4111 1111 1111 1111"
    val xpay = new XpayImpl()
    val adapter = new XpayToPayDAdapter(xpay)

    adapter.setCustCardNo(cardNumber)

    assert(xpay.getCreditCardNo == cardNumber)
  }

  test("customer name") {
    val customerName = "Iszak Bryan"
    val xpay = new XpayImpl()
    val adapter = new XpayToPayDAdapter(xpay)

    adapter.setCardOwnerName(customerName)

    assert(xpay.getCustomerName == customerName)
    assert(adapter.getCardOwnerName == customerName)
  }

  test("cvv") {
    val cvv = 321
    val xpay = new XpayImpl()
    val adapter = new XpayToPayDAdapter(xpay)

    adapter.setCVVNo(cvv)
    assert(xpay.getCardCVVNo == cvv)
    assert(adapter.getCVVNo == cvv)
  }

  test("card expiry month") {
    val cardExpiryMonth = 3
    val xpay = new XpayImpl()
    val adapter = new XpayToPayDAdapter(xpay)

    adapter.setCardExpMonthDate(cardExpiryMonth.toString)
    assert(xpay.getCardExpMonth == cardExpiryMonth.toString)
    assert(adapter.getCardExpMonthDate == cardExpiryMonth.toString)
  }

  test("total amount") {
    val totalAmount = 19.92
    val xpay = new XpayImpl()
    val adapter = new XpayToPayDAdapter(xpay)

    adapter.setTotalAmount(totalAmount)

    assert(xpay.getAmount == totalAmount)
    assert(adapter.getTotalAmount == totalAmount)
  }
}