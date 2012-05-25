package addressbook

import griffon.fest.*
import org.fest.swing.fixture.*

class AddressbookSpec extends FestSpec {
    // instance variables:
    // app    - current application
    // window - value returned from initWindow()
    //          defaults to app.windowManager.windows[0]

    def 'sanity check: textfields should be empty'() {
        expect:
            for (propName in Contact.PROPERTIES) {
                window.textBox("${propName}TextField").requireEmpty()
            }
    }

    def 'Double clicking on the list should bind selected contact values to the form'() {
        when:
            window.list('contactList').item(0).doubleClick()
        
        then:
            window.textBox('nameTextField').with {
                requireText('Andres')
                text() == app.models.addressbook.contacts[0].name
            }

        cleanup:
            for (propName in Contact.PROPERTIES) {
                window.textBox("${propName}TextField").setText('')
            }
    }

    def 'Creating a new Contact'() {
        setup:
            window.button('newButton').click()
            
        when:
            for (propName in Contact.PROPERTIES) {
                window.textBox("${propName}TextField").setText(propName)
            }
            window.button('saveButton').click()
            
        then:
            window.list('contactList').with {
                requireItemCount(2)
                requireSelection(1)
            }
            for (propName in Contact.PROPERTIES) {
                assert app.models.addressbook.contacts[1][propName] == propName
            }

        cleanup:
            for (propName in Contact.PROPERTIES) {
                window.textBox("${propName}TextField").setText('')
            }
    }
}
