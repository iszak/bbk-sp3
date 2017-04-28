package proxy.virtualproxy

import scala.collection.mutable.ListBuffer

class ContactListProxyImpl extends ContactList {

  private var contactList: ContactList = _

  override def employeeList: ListBuffer[Employee] = contactList match {
    case cl: ContactList => cl.employeeList
    case _ => {
      println("Creating contact list and fetching list of employees...")
      contactList = ContactListImpl()
      contactList.employeeList
    }
  }

}
