import org.scalatra._
import org.scalatra.servlet.ScalatraListener
import slick.jdbc.SQLiteProfile.api._
import javax.servlet.ServletContext

case class Contact(name: String, email: String, phone: String)

class ContactServlet extends ScalatraServlet {

  val db = Database.forConfig("sqlite")

  class Contacts(tag: Tag) extends Table[Contact](tag, "CONTACTS") {
    def name = column[String]("NAME")
    def email = column[String]("EMAIL")
    def phone = column[String]("PHONE")
    def * = (name, email, phone) <> (Contact.tupled, Contact.unapply)
  }

  val contacts = TableQuery[Contacts]

  // Creating the table if it doesn't exist
  db.run(DBIO.seq(contacts.schema.createIfNotExists))

  get("/") {
    contentType = "text/html"
    html.index()
  }

  post("/submit") {
    val name = params("name")
    val email = params("email")
    val phone = params("phone")

    val newContact = Contact(name, email, phone)
    db.run(contacts += newContact)

    redirect("/thankyou")
  }

  get("/thankyou") {
    contentType = "text/html"
    html.thankyou()
  }
}

object ContactApp extends LifeCycle {
  override def init(context: ServletContext): Unit = {
    context.mount(new ContactServlet, "/*")
  }
}
