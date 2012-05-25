package addressbook

class AddressbookController {
    // these will be injected by Griffon
    def model
    def view

    def newAction = {
        view.contactList.clearSelection()
        model.selectedIndex = -1
    }

    def saveAction = { 
        boolean isNew = model.selectedIndex == -1
        Contact contact = isNew ? new Contact() : model.contacts[model.selectedIndex]
        for (propName in Contact.PROPERTIES) {
            contact[propName] = model[propName]
        }
        if (isNew) {
            execInsideUIAsync {
                model.contacts << contact
                contact.id = model.contacts.size()
                view.contactList.selectedIndex = contact.id - 1
            }
        } else {
            view.contactList.repaint()
        }
    }

    def deleteAction = {
        if (model.selectedIndex > -1) {
            int index = model.selectedIndex
            model.selectedIndex = -1
            view.contactList.clearSelection()
            model.contacts.remove(index)
        }
    }

    void dumpAction(evt) {
        model.contacts.each { println it }
    }
}
