package addressbook

class AddressbookController {
    // these will be injected by Griffon
    def model
    def view

    def newAction = { 
        println 'new'
    }

    def saveAction = { 
        println 'save'
    }

    def deleteAction = {
        println 'delete'
    }

    void dumpAction(evt) {
        println 'dump'
    }
}
